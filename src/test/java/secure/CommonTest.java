package secure;


import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.main.UserSecureService;
import com.renory.secure.main.UserSecureServiceImpl;
import com.renory.secure.user.UserSecure;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smit
 */
public class CommonTest {
    private final SqlSettings settings = new SqlSettings();
    private final UserSecureService userSecureService;
    private final ContentCreater content = new ContentCreater();
    private ArrayList<String> ips;
    private final File badWorsFile = new File("src/test/java/secure/badWords.txt");
    
    int idDefaultmember = 0;
    String sessionTest = "GHKJDS7564563GHJLAS";
    
    public CommonTest(){
        settings.initForTest();
        userSecureService = new UserSecureServiceImpl(settings, badWorsFile);
    }
    
    
    @Before
    public void prepare(){
        ips = new ArrayList();
        ips.add("127.0.0.1");
        ips.add("192.168.56.11");
        ips.add("8.8.8.8");
        userSecureService.clearDB();
    }
    
    @Test
    public void createNewUser(){
        System.out.println("Start createNewUser");
        int id = userSecureService.createNewUser(content.getMember(), ips);
        assertEquals(true, id>0);
    }
    
    @Test
    public void makeARootUser(){
        System.out.println("Start makeARootUser");
        initDefaultMember();
        userSecureService.makeARootUser(idDefaultmember);
        UserSecure user = userSecureService.getById(idDefaultmember);
        assertEquals(true, user.isRoot());
    }
    

    
    
    @Test
    public void theUserIssetTrue(){
        System.out.println("Start theUserIssetTrue");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theUserIsset(user.getLogin());
        assertEquals(true, result);
    }
    
    @Test
    public void theUserIssetFalse(){
        System.out.println("Start theUserIssetFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theUserIsset("wrongLogin");
        assertEquals(false, result);
    }
    
    @Test
    public void theLoginUniqeTrue(){
        System.out.println("Start theLoginUniqeTrue");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theLoginUniqe("UniqeLogin");
        assertEquals(true, result);
    }
    
    @Test
    public void theLoginUniqeFalse(){
        System.out.println("Start theLoginUniqeFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theLoginUniqe(user.getLogin());
        assertEquals(false, result);
    }
    
    @Test
    public void theNickNameUniqeTrue(){
        System.out.println("Start theNickNameUniqeTrue");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theNickNameUniqe("uniqueNickName");
        assertEquals(true, result);
    }
    
    @Test
    public void theNickNameUniqeFalse(){
        System.out.println("Start theNickNameUniqeFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theNickNameUniqe(user.getNickName());
        assertEquals(false, result);
    }
    
    @Test
    public void theEmailUniqeTrue(){
        System.out.println("Start theEmailUniqeTrue");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theEmailUniqe("eniqeEmqil@fd.com");
        assertEquals(true, result);
    }
    
    @Test
    public void theEmailUniqeFalse(){
        System.out.println("Start theEmailUniqeFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.theEmailUniqe(user.getEmail());
        assertEquals(false, result);
    }
    
    @Test
    public void getUserBySessionTrue(){
        System.out.println("Start getUserBySessionTrue");
        initDefaultMember();
        UserSecure user = userSecureService.getUserBySession(sessionTest);
        assertEquals(true, !user.isGuest());
    }
    
    @Test
    public void getUserBySessionFalse(){
        System.out.println("Start getUserBySessionFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getUserBySession("wrongSession");
        assertEquals(true, user.isGuest());
    }
    
    @Test
    public void getUserByLogin(){
        System.out.println("Start getUserByLogin");
        initDefaultMember();
        UserSecure userById = userSecureService.getById(idDefaultmember);
        UserSecure userByLogin = userSecureService.getUserByLogin(userById.getLogin());
    }
    
    
    
    @Test
    public void updateUserPasswordFalse(){
        System.out.println("Start updateUserPasswordFalse");
        initDefaultMember();
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.updateUserPassword(sessionTest, "wrongPass", "newTestPassword");
        assertEquals(false, result);
    }
    
    @Test
    public void thePasswordIsValid1(){
        System.out.println("Start thePasswordIsValid1");
        assertEquals(false, userSecureService.thePasswordIsValid(null));
    }
    
    @Test
    public void thePasswordIsValid2(){
        System.out.println("Start thePasswordIsValid2");
        assertEquals(false, userSecureService.thePasswordIsValid(""));
    }
    
    @Test
    public void thePasswordIsValid3(){
        System.out.println("Start thePasswordIsValid3");
        assertEquals(false, userSecureService.thePasswordIsValid("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx")); // >30
    }
    
    @Test
    public void thePasswordIsValid4(){
        System.out.println("Start thePasswordIsValid4");
        assertEquals(false, userSecureService.thePasswordIsValid("xxxxxxx")); // <8
    }
    
    @Test
    public void userIssetInGroupTrue(){
        System.out.println("Start user Isset In Group true");
        initDefaultMember();
        String groupName1 = "ADMIN";
        String groupName2 = "MANAGER";
        userSecureService.addInGroup(idDefaultmember, groupName1);
        userSecureService.addInGroup(idDefaultmember, groupName2);
        
        UserSecure user = userSecureService.getById(idDefaultmember);
        
        boolean result1 = user.issetInGroup(groupName1);
        boolean result2 = user.issetInGroup(groupName2);
        
        assertEquals(true, result1 & result2);
    }
    
    @Test
    public void userIssetInGroupFalse(){
        System.out.println("Start user Isset In Group false");
        initDefaultMember();
        String groupName1 = "ADMIN";
        String groupName2 = "MANAGER";
        userSecureService.addInGroup(idDefaultmember, groupName1);
        userSecureService.addInGroup(idDefaultmember, groupName2);
        
        UserSecure user = userSecureService.getById(idDefaultmember);
        
        boolean result1 = user.issetInGroup(groupName1);
        boolean result2 = user.issetInGroup("wrong_group");
        
        assertEquals(false, result1 & result2);
    }
    
    private void initDefaultMember(){
        idDefaultmember = userSecureService.createNewUser(content.getMember(), ips);
        UserSecure user = userSecureService.getById(idDefaultmember);
        userSecureService.updateSession(user.getLogin(), sessionTest);
    }
}
