/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;


import com.renory.util.CookieUtil;
import java.io.File;
import com.renory.secure.dto.RegInfoDto;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.renory.secure.dao.DaoLayer;
import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.dto.UserDataDto;
import com.renory.secure.alhoritm.Password;
import com.renory.secure.user.UserSecure;
import com.renory.secure.user.UserType;

/**
 *
 * @author smit
 */
public class UserSecureServiceImpl implements UserSecureService{
    private CheckUserUniqeData check;
    private final UsersWorker usersService = new UsersWorker();
    private final CookieUtil coockie = new CookieUtil();
    
    private static final String SESSION_NAME = "renory_session";
    
    private boolean registration = true;
    private final ValidUserData valid = new ValidUserData();
    private final Converter converter = new Converter();
    private final BadWords badWords;
    
    private final DaoLayer dao;
    
    public UserSecureServiceImpl(SqlSettings settings, File file){
        dao = new DaoLayer(settings);
        badWords = new BadWords(file);
    }

    
    @Override
    public int createNewUser(RegInfoDto info, ArrayList<String> ips) {
        
        boolean check = valid.theRegInfoIsValid(info);
        if (!check) return 0;
        
        UserSecure user = new UserSecure();
        
        user.setLogin(info.getLogin().trim());
        user.setNickName(info.getNickName().trim());
        String password = Password.getSaltedHash(info.getPassword().trim());
        user.setPassword(password);
        user.setEmail(info.getEmail());
        user.setIsMember();
        user.setIsOkStatus();
        user.setRandomSession();
        user.setTimeOfLastLogin(System.currentTimeMillis());
        user.setTimeOfRegistration(System.currentTimeMillis());
        
        return this.writeUser(user);
    }
    
    @Override
    public void signInTheUser(String login, HttpServletResponse response, ArrayList<String> ips) {
        String sessionId = UUID.randomUUID().toString();
        coockie.write(SESSION_NAME, sessionId, "/", response);
        UserSecure user = this.getUserByLogin(login);
        user.setLastIpsLogined(ips);
        user.setSessionId(sessionId);
        this.updateUser(user);
    }

    @Override
    public ArrayList<UserSecure> getAllUsers() {
        return converter.toEntityArray(dao.getAllUsers());
    }

    @Override
    public UserSecure getUserBySession(HttpServletRequest request) {
        String sessionId = coockie.read(SESSION_NAME, request);
        return getUserBySession(sessionId);
    }
    
    @Override
    public void updateSession(String login, HttpServletResponse response) {
        String sessionId = UUID.randomUUID().toString();
        coockie.write(SESSION_NAME, sessionId, "/", response);
        updateSession(login, sessionId);
    }
    
    @Override
    public void updateSession(String login, String session) {
        UserSecure user = this.getUserByLogin(login);
        user.setSessionId(session);
        this.updateUser(user);
    }

    @Override
    public boolean theUserIsset(String login) {
        return usersService.theUserIsset(login, getAllUsers());
        
    }

    @Override
    public boolean passwordsInUserEquals(String login, String password) {
        UserSecure user = getUserByLogin(login);
        try {
            return Password.check(password, user.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(UserSecureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }


    
    
    @Override
    public void makeARootUser(int userId) {
        UserSecure user = this.getById(userId);
        user.setIsRoot();
        this.updateUser(user);
    }

    @Override
    public UserSecure getUserByLogin(String login) {
        return usersService.getUserByLogin(login, getAllUsers());
    }
    
    @Override
    public UserSecure getById(int id) {
        return converter.toEntity(dao.getUser(id));
    }

    @Override
    public boolean theLoginUniqe(String login) {
        check = new CheckUserUniqeData(getAllUsers());
        return check.theLoginUniqe(login);
    }

    @Override
    public boolean theNickNameUniqe(String nickName) {
        check = new CheckUserUniqeData(getAllUsers());
        return check.theNickNameUniqe(nickName);
    }

    @Override
    public boolean theEmailUniqe(String email) {
        check = new CheckUserUniqeData(getAllUsers());
        return check.theEmailUniqe(email);
    }

    @Override
    public boolean thePasswordIsValid(String password) {
        return valid.thePasswordIsValid(password);
    }

    @Override
    public boolean thePasswordIsCorrect(String login, String password) {
        try {
            UserSecure user = this.getUserByLogin(login);
            return Password.check(password, user.getPassword());
        } catch (Exception ex) {
            Logger.getLogger(UserSecureServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public void removeSession(HttpServletResponse response, HttpServletRequest request) {
        coockie.write(SESSION_NAME, "empty_session", "/",response);
        UserSecure user = this.getUserBySession(request);
        user.setRandomSession();
        dao.update(converter.toDto(user));
    }

    @Override
    public boolean updateUserPassword(HttpServletRequest request, String oldPassword, String newPassword) {
        String sessionId = coockie.read(SESSION_NAME, request);
        return updateUserPassword(sessionId, oldPassword, newPassword);
    }

    @Override
    public boolean passwordsInUserEquals(HttpServletRequest request, String oldPassword) {
        String sessionId = coockie.read(SESSION_NAME, request);
        if (sessionId!=null){
            UserSecure user = usersService.getBySession(sessionId, getAllUsers());
            String hashedPassword = Password.getSaltedHash(oldPassword);
            boolean check = Password.check(oldPassword, user.getPassword());
            if (check){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void setRegistrationIsClosed() {
        this.registration = false;
    }

    @Override
    public void setRegistrationIsOpen() {
        this.registration = true;
    }

    @Override
    public boolean registrationIsOpen() {
        return this.registration;
    }

    @Override
    public UserSecure getUserBySession(String sessionId) {
        if (sessionId!=null){
            UserSecure user = usersService.getBySession(sessionId, getAllUsers());
            return user;
        } else {
            UserSecure user = new UserSecure();
            user.setIsGuest();
            return user;
        }
    }

    @Override
    public boolean updateUserPassword(String sessionId, String oldPassword, String newPassword) {
        if (sessionId!=null){
            UserSecure user = this.getUserBySession(sessionId);
            boolean passwordCorrect = passwordsInUserEquals(user.getLogin(), oldPassword);
            if (passwordCorrect){
                String newHashedPassword = Password.getSaltedHash(newPassword);
                user.setPassword(newHashedPassword);
                this.updateUser(user);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    @Override
    public void addUser(UserSecure user) {
        this.dao.write(converter.toDto(user));
    }

    @Override
    public String getHashedPassword(String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void updateUser(UserSecure user) {
        this.dao.update(converter.toDto(user));
    }

    private int writeUser(UserSecure user) {
        return dao.write(converter.toDto(user));
    }

    @Override
    public void clearDB() {
        dao.clearDB();
    }

    @Override
    public void addInGroup(int userId, String groupName) {
        UserSecure user = this.getById(userId);
        user.addInGroup(groupName);
        this.updateUser(user);
    }

    @Override
    public void removeGroup(int userId, String groupName) {
        UserSecure user = this.getById(userId);
        user.removeGroup(groupName);
        this.updateUser(user);
    }

    @Override
    public void updateUserData(UserDataDto data) {
        UserSecure user = this.getById(data.getId());
        user.setLogin(data.getLogin());
        user.setNickName(data.getNickName());
        user.setType(UserType.valueOf(data.getUsertype()));
        user.setGroups(converter.converByComma(data.getGroups()));
        user.setEmail(data.getEmail());
        
        this.updateUser(user);
    }

    @Override
    public int createByUserData(UserDataDto data) {
        checkLoginByUniqe(data.getLogin());
        
        UserSecure user = new UserSecure();
        user.setLogin(data.getLogin().trim());
        user.setNickName(data.getNickName().trim());
        String password = Password.getSaltedHash(data.getPassword().trim());
        user.setPassword(password);
        user.setType(UserType.valueOf(data.getUsertype()));
        user.setGroups(converter.converByComma(data.getGroups()));
        user.setEmail(data.getEmail());
        user.setIsMember();
        user.setIsOkStatus();
        user.setRandomSession();
        user.setTimeOfLastLogin(System.currentTimeMillis());
        user.setTimeOfRegistration(System.currentTimeMillis());
        
        return this.writeUser(user);
    }

    private void checkLoginByUniqe(String login) {
        if (!theLoginUniqe(login)) {
            throw new RuntimeException("The login '" + login + "' not uniqe!");
        }
    }

    @Override
    public boolean theLoginNotBad(String login) {
        return badWords.theWordNotBad(login);
    }

    @Override
    public boolean theNickNameNotBad(String nickName) {
        return badWords.theWordNotBad(nickName);
    }

    @Override
    public void makeTheUserBanned(int id) {
        UserSecure user = this.getById(id);
        user.setIsBannedStatus();
        this.updateUser(user);
    }
    

}
