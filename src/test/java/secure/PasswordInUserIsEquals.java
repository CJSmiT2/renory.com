package secure;


import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.dto.RegInfoDto;
import com.renory.secure.main.UserSecureService;
import com.renory.secure.main.UserSecureServiceImpl;
import com.renory.secure.user.UserSecure;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
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
public class PasswordInUserIsEquals {
    private final SqlSettings settings = new SqlSettings();
    private final UserSecureService userSecureService;
    private final ContentCreater content = new ContentCreater();
    private ArrayList<String> ips;
    private final File badWorsFile = new File("src/test/java/secure/badWords.txt");
    
    String sessionTest = "GHKJDS7564563GHJLAS";
    
    public PasswordInUserIsEquals(){
        settings.initForTest();
        userSecureService = new UserSecureServiceImpl(settings, badWorsFile);
    }
    
    @Test
    public void passwordsInUserEqualsTrue(){
        System.out.println("Start passwordsInUserEqualsTrue");
        
        RegInfoDto dto  = content.getMember();
        int idDefaultmember = userSecureService.createNewUser(dto, ips);
        
        UserSecure user = userSecureService.getById(idDefaultmember);
        
        boolean result = userSecureService.passwordsInUserEquals(user.getLogin(), dto.getPassword());
        assertEquals(true, result);
    }
    
    @Test
    public void passwordsInUserEqualsFalse(){
        System.out.println("Start passwordsInUserEqualsFalse");
        
        RegInfoDto dto  = content.getMember();
        int idDefaultmember = userSecureService.createNewUser(dto, ips);
        
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.passwordsInUserEquals(user.getLogin(), "wrong_password");
        assertEquals(false, result);
    }
    
    @Test
    public void updateUserPasswordTrue(){
        System.out.println("Start updateUserPasswordTrue");
        
        RegInfoDto dto  = content.getMember();
        int idDefaultmember = userSecureService.createNewUser(dto, ips);
        
        UserSecure user = userSecureService.getById(idDefaultmember);
        boolean result = userSecureService.updateUserPassword(sessionTest, dto.getPassword(), "newTestPassword");
        assertEquals(true, result);
    }
    

}
