package secure;


import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.main.UserSecureService;
import com.renory.secure.main.UserSecureServiceImpl;
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
public class WriteNewUser {
        private final SqlSettings settings = new SqlSettings();
        private final UserSecureService userSecureService;
        private final ContentCreater content = new ContentCreater();
        private ArrayList<String> ips;
        private final File badWorsFile = new File("src/test/java/secure/badWords.txt");

        int idDefaultmember = 0;
        String sessionTest = "GHKJDS7564563GHJLAS";

        public WriteNewUser(){
            String path = WriteNewUser.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            settings.initForTest();
            userSecureService = new UserSecureServiceImpl(settings, badWorsFile);
        }


        @Before
        public void prepare(){
            ips = new ArrayList();
            ips.add("127.0.0.1");
            ips.add("192.168.56.11");
            ips.add("8.8.8.8");
        }
        
        @Test
        public void createNewUser(){
            System.out.println("Start createNewUser");
            int id = userSecureService.createNewUser(content.getMember(), ips);
            assertEquals(true, id>0);
        }
        
        @Test
        public void theLoginNotBadTrue(){
            System.out.println("Start theLoginNotBadTrue");
            boolean result = userSecureService.theLoginNotBad(content.getMember().getLogin());
            assertEquals(true, result);
        }
        
        @Test
        public void theLoginNotBadFalse(){
            System.out.println("Start theLoginNotBadFalse");
            boolean result = userSecureService.theLoginNotBad(content.getBadMember().getLogin());
            assertEquals(false, result);
        }
}
