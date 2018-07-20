/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.service.impl;

import com.renory.model.dao.interfaces.AmvDao;
import com.renory.model.entity.amv.Amv;
<<<<<<< OURS
import com.renory.util.AliasUtil;
=======
import com.renory.model.util.alias.AliasUtil;
>>>>>>> THEIRS
import com.renory.view.dto.AmvBaseInfoDto;

/**
 *
 * @author smit
 */
public class AmvServiceUtil {

    static Amv createAmv(String title, int userId, AmvDao dao) {
        Amv amv = new Amv();
        amv.setUploaderUserId(userId);
        amv.setTitle(title);
        amv.setAlias(AliasUtil.makeUniqeAlias(title, dao.getAllAliaces()));
        dao.write(amv);
        amv.makeFolder();
        return amv;
    }

    static void updateBaseInfo(AmvBaseInfoDto baseInfo, AmvDao dao) {
        Amv amv = dao.get(baseInfo.getId());
        amv.setTitle(baseInfo.getTitle());
        amv.setAlias(baseInfo.getAlias());
        amv.setDescription(baseInfo.getDescription());
        amv.setDateCreated(baseInfo.getDateCreated());
        if (!amv.getAlias().equalsIgnoreCase(amv.getFolderOnDisk().getName())){
            amv.renameFolderOnDisk();
        }
        dao.update(amv);
    }

    
}
