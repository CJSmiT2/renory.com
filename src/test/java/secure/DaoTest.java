package secure;


import com.renory.secure.dao.DaoLayer;
import com.renory.secure.dao.dto.SqlSettings;
import com.renory.secure.dao.dto.UserDaoDto;
import java.sql.Timestamp;
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
public class DaoTest {
    final DaoLayer dao;

    public DaoTest() {
        SqlSettings settings = new SqlSettings();
        settings.initForTest();
        dao = new DaoLayer(settings.login, settings.password, settings.host, settings.base, settings.port);
    }
    
    @Before
    public void prepare(){
        dao.clearDB();
    }
    
    @Test
    public void write(){
        UserDaoDto dto = new UserDaoDto();
        dto.setLogin("SmiT");
        dto.setPassword("fhjdhasfklas$jgkfdjgkdasfkgodsfklg;ds");
        dto.setNickName("NickName");
        dto.setSessionId("fdsfds");
        dto.setStatus("status");
        dto.setEmail("eee@ee.com");
        dto.setType("tpe");
        dto.setLastIpsLogined("127.0.0.1,8.8.8.8");
        dto.setGroups("ADMIN,MANAGER");
        dto.setTimeOfLastLogin(new Timestamp(System.currentTimeMillis()));
        dto.setTimeOfRegistration(new Timestamp(System.currentTimeMillis()));
        
        assertEquals(1, dao.write(dto));
    }
    
    
}
