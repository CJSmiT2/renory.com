/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.model.dao.impl;

import com.renory.model.dao.interfaces.AmvRulesDao;
import com.renory.model.entity.amvrules.AmvPermissions;

/**
 *
 * @author smit
 */
public class AmvRulesDaoImpl implements AmvRulesDao{
    
    private final TableAmvRules db = new TableAmvRules();

    @Override
    public void write(AmvPermissions rules) {
        db.write(rules.getAmvId(), ConverterJsonUtil.toStringRulesByUser(rules.getPermissions()));
    }

    @Override
    public AmvPermissions getByAmvId(int amvId) {
        AmvPermissions permissions = new AmvPermissions();
        permissions.setAmvId(amvId);
        String rules = db.getByAmvId(amvId);
        permissions.setPermissions(ConverterJsonUtil.toEntityRulesByUser(rules));
        return permissions;
    }

    @Override
    public void update(AmvPermissions rules) {
        db.update(rules.getAmvId(), ConverterJsonUtil.toStringRulesByUser(rules.getPermissions()));
    }

    @Override
    public void delete(AmvPermissions rules) {
        db.delete(rules.getAmvId());
    }

    @Override
    public void clearDb() {
        db.clearDb();
    }
    
}
