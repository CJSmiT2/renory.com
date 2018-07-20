package secure;


import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.dto.UserDataDto;
import com.renory.secure.main.UserSecureService;
import com.renory.secure.main.UserSecureServiceImpl;
import com.renory.secure.user.UserSecure;
import java.io.File;
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
public class CommonTest2 {
    private final SqlSettings settings = new SqlSettings();
    private final UserSecureService userSecureService;
    private final File badWorsFile = new File("src/test/java/secure/badWords.txt");
    
    public CommonTest2(){
        settings.initForTest();
        userSecureService = new UserSecureServiceImpl(settings, badWorsFile);
    }
    
    @Before
    public void prepare(){
        userSecureService.clearDB();
    }
    
    @Test
    public void createByUserData(){
        System.out.println("Start create By User Data");
        
        UserDataDto data = new UserDataDto();
        data.setLogin("User");
        data.setNickName("User");
        data.setPassword("password");
        data.setGroups("ADMIN,CONTENT");
        data.setUsertype("MEMBER");
        data.setEmail("w@w.com");
        
        userSecureService.createByUserData(data);
    }
    
    @Test
    public void updateUserData(){
        System.out.println("Start update User Data");
        
        
        UserDataDto data = new UserDataDto();
        data.setLogin("User");
        data.setNickName("User");
        data.setPassword("password");
        data.setGroups("ADMIN,CONTENT");
        data.setUsertype("MEMBER");
        data.setEmail("w@w.com");
        
        int id = userSecureService.createByUserData(data);
        UserDataDto data2 = new UserDataDto();
        data2.setId(id);
        data2.setLogin("SmiT2");
        data2.setNickName("SmiT2");
        data2.setGroups("TEST_GROUP");
        data2.setUsertype("ROOT");
        data2.setEmail("w@w2.com");
        
        userSecureService.updateUserData(data2);
        
        UserSecure user = userSecureService.getById(id);
        
        boolean equals1 = data2.getLogin().equals(user.getLogin());
        boolean equals2 = data2.getNickName().equals(user.getNickName());
        boolean equals3 = data2.getEmail().equals(user.getEmail());
        
        assertEquals(true, equals1 & equals2 & equals3);
        
    }
}
