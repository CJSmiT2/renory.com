/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.secure.main;

import com.renory.secure.dto.RegInfoDto;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.renory.secure.dto.UserDataDto;
import com.renory.secure.user.UserSecure;

/**
 *
 * @author smit
 */
public interface UserSecureService {
    
    UserSecure getUserBySession(HttpServletRequest request);
    
    UserSecure getUserBySession(String session);
    
    UserSecure getUserByLogin(String login);
    
    UserSecure getById(int id);
    
    ArrayList<UserSecure> getAllUsers();
    
    public boolean passwordsInUserEquals(String login, String oldPassword);
    
    boolean thePasswordIsCorrect(String login, String password);
    
    boolean theUserIsset(String login);
    
    void updateSession(String login, HttpServletResponse response);
    
    void signInTheUser(String login, HttpServletResponse response, ArrayList<String> ips);
    
    void updateSession(String login, String session);
    
    boolean theLoginUniqe(String login);
    
    boolean theNickNameUniqe(String nickName);
    
    boolean theLoginNotBad(String login);
    
    boolean theNickNameNotBad(String nickName);
    
    boolean theEmailUniqe(String email);

    
    
    int createNewUser(RegInfoDto info, ArrayList<String> ips);
    
    void makeARootUser(int userId);

    public boolean thePasswordIsValid(String login);

    public void removeSession(HttpServletResponse response, HttpServletRequest request);

    public boolean updateUserPassword(HttpServletRequest request, String oldPassword, String newPassword);
    
    public boolean updateUserPassword(String session, String oldPassword, String newPassword);

    public boolean passwordsInUserEquals(HttpServletRequest request, String oldPassword);
    
    public String getHashedPassword(String password);
    
    
    void setRegistrationIsClosed();
    
    void setRegistrationIsOpen();
    
    boolean registrationIsOpen();
    
    
    public void addInGroup(int userId, String groupName);
    
    public void removeGroup(int userId, String groupName);
    
    // tests
    
    void addUser(UserSecure user);
    
    void clearDB();

    public void updateUserData(UserDataDto userDataDto);

    public int createByUserData(UserDataDto userDataDto);

    public void makeTheUserBanned(int id);
}
