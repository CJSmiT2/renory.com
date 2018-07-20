/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amv;

<<<<<<< OURS
import com.renory.config.GeneralConfig;
import com.renory.model.entity.amv.Amv;
=======
>>>>>>> THEIRS
import com.renory.service.AmvService;
import com.renory.service.impl.AmvServiceImpl;
<<<<<<< OURS
import com.renory.view.dto.AmvBaseInfoDto;
import com.renory.util.FilesUtil;
import content.AmvContentCreater;
import java.io.File;
import org.junit.After;
import static org.junit.Assert.assertEquals;
=======
>>>>>>> THEIRS
import org.junit.Test;

/**
 *
 * @author smit
 */
public class AmvServiceTest {
    private final AmvService amvService = new AmvServiceImpl();
    
    @Test
    public void createAmv(){
        
<<<<<<< OURS
        Amv amv2 = amvService.get(amv.getId());
        
        assertEquals(true, amv2.getDescription().equals(baseInfo.getDescription()));
    }
    
    @Test
    public void addAnimeSrc(){
        String alias = amvService.createAmv(title, userId);
        Amv amv = amvService.get(alias);
        amvService.addAnimeSrc(amv.getId(), animeSrc);
        assertEquals(true, amvService.isAnimeSrcExist(amv.getId(), animeSrc));
    }
    
    @Test
    public void deleteAnimeSrc(){
        String alias = amvService.createAmv(title, userId);
        Amv amv = amvService.get(alias);
        amvService.addAnimeSrc(amv.getId(), animeSrc);
        amvService.deleteAnimeSrc(amv.getId(), animeSrc);
        assertEquals(false, amvService.isAnimeSrcExist(amv.getId(), animeSrc));
    }
    
    @After
    public void clearDb(){
        amvService.clearDb();
        FilesUtil.deleteAllInFolder(new File(GeneralConfig.AMV_FOLDER));
=======
>>>>>>> THEIRS
    }
}
