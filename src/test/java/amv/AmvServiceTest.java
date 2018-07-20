/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amv;

import com.renory.config.GeneralConfig;
import com.renory.model.entity.amv.Amv;
import com.renory.service.AmvService;
import com.renory.service.impl.AmvServiceImpl;
import com.renory.view.dto.AmvBaseInfoDto;
import com.renory.util.FilesUtil;
import content.AmvContentCreater;
import java.io.File;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class AmvServiceTest {
    private final AmvService amvService = new AmvServiceImpl();
    final int userId = 1;
    final int animeSrc = 2;
    final String title = "test title";
    
    
    @Test
    public void createAmv(){
        String alias = amvService.createAmv(title, userId);
        assertEquals(true, !alias.isEmpty());
    }
    
    @Test
    public void delete(){
        String alias = amvService.createAmv(title, userId);
        Amv amv = amvService.get(alias);
        amvService.delete(amv.getId());
        assertEquals(false, amvService.isAmvExist(amv.getId()));
    }
    
    @Test
    public void updateBaseInfo(){
        AmvBaseInfoDto baseInfo = AmvContentCreater.baseInfo();
        String alias = amvService.createAmv(title, userId);
        Amv amv = amvService.get(alias);
        baseInfo.setId(amv.getId());
        amvService.updateBaseInfo(baseInfo);
        
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
    }
}
