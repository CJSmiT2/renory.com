/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amv;

import com.renory.model.dao.impl.AmvDaoImpl;
import com.renory.model.dao.interfaces.AmvDao;
import com.renory.model.entity.amv.Amv;
import java.util.ArrayList;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class AmvDaoTest {
    
    private final AmvDao amvDao = new AmvDaoImpl();
    
    @Test
    public void writeAndGet1(){
        Amv amv = AmvContentCreater.getAmv();
        int id = amvDao.write(amv);
        assertEquals(true, id>0);
    }
    
    @Test
    public void writeAndGet2(){
        Amv amv = AmvContentCreater.getAmv();
        int id = amvDao.write(amv);
        Amv amv2 = amvDao.get(amv.getAlias());
        assertEquals(true, id == amv2.getId());
    }
    
    @Test
    public void update(){
        Amv amv = AmvContentCreater.getAmv();
        int id = amvDao.write(amv);
        Amv amv2 = amvDao.get(id);
        amv2.setTitle("updated");
        amvDao.update(amv2);
        Amv amv3 = amvDao.get(id);
        assertEquals(true, amv2.getTitle().equals(amv3.getTitle()));
    }
    
    @Test
    public void getAll(){
        Amv amv = AmvContentCreater.getAmv();
        amvDao.write(amv);
        ArrayList<Amv> all = amvDao.getAll();
        assertEquals(false, all.isEmpty());
    }
    
    @Test
    public void delete(){
        Amv amv = AmvContentCreater.getAmv();
        int id = amvDao.write(amv);
        amvDao.delete(amv);
    }
    
    @After
    public void clearDb(){
        amvDao.clearDb();
    }
    
}
