/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amv;

import com.renory.model.dao.impl.AmvRulesDaoImpl;
import com.renory.model.dao.interfaces.AmvRulesDao;
import com.renory.model.entity.amvrules.AmvPermissions;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author smit
 */
public class AmvRulesDaoTest {
    
    private final AmvRulesDao amvRules = new AmvRulesDaoImpl();
    
    @Test
    public void write(){
        int amvId = 1;
        AmvPermissions rules = new AmvPermissions();
        rules.setAmvId(amvId);
        amvRules.write(rules);
        
        AmvPermissions rules2 = amvRules.getByAmvId(amvId);
    }
    
    @Test
    public void update(){
        int amvId = 2;
        AmvPermissions rules = new AmvPermissions();
        rules.setAmvId(amvId);
        amvRules.write(rules);
        
        AmvPermissions rules2 = amvRules.getByAmvId(amvId);
        rules2.getPermissions().setAccessRuleEnable(true);
        amvRules.update(rules2);
        
        AmvPermissions rules3 = amvRules.getByAmvId(amvId);
        assertEquals(true, rules3.getPermissions().isAccessRuleEnable());
    }
    
    @Test
    public void delete(){
        int amvId = 3;
        AmvPermissions rules = new AmvPermissions();
        rules.setAmvId(amvId);
        amvRules.write(rules);
        amvRules.delete(rules);
    }
    
    @After
    public void clearDb(){
        amvRules.clearDb();
    }
}
