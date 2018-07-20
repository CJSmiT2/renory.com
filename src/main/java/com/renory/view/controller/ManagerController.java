/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.renory.view.controller;

<<<<<<< OURS
import com.renory.secure.main.UserSecureService;
import com.renory.secure.user.UserSecure;
=======
>>>>>>> THEIRS
import com.renory.service.AmvService;
import com.renory.service.PermissionService;
import com.renory.service.UserService;
import com.renory.service.impl.AmvServiceImpl;
import com.renory.service.impl.PermissionServiceImpl;
import com.renory.service.impl.UserServiceImpl;
import com.renory.view.dto.AmvBaseInfoDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
<<<<<<< OURS
import com.renory.service.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> THEIRS

/**
 *
 * @author smit
 */
@Controller
@RequestMapping(value = {"manage/"})
public class ManagerController {
    
    public static final String AUTHOR_NOT_FOUND_ERR = "redirect:/add_author?error=1";
    public static final String YOU_NOT_HAVE_ACCESS_FOR_EDIT_ERR = "redirect:/add_author?error=2";
    
    private final UserService userService = new UserServiceImpl();
    private final AmvService amvService = new AmvServiceImpl();
    private final PermissionService permissionService = new PermissionServiceImpl();
    
    @Autowired
    private UserSecureService userSecureService;
    
    @RequestMapping(value = {"upload_amv"})
    public Object uploadAmv(){
        return new ModelAndView("manage/upload_amv");
    }
    
    @RequestMapping(value = {"upload_amv_simple_mod"})
    public Object uploadAmvSimpleMod(){
        return new ModelAndView("manage/upload_amv_simple_mod");
    }
    
    
    
    @RequestMapping(value = {"update_base_info"})
    public Object updateBaseInfo(AmvBaseInfoDto info){
    /*
        Update: title, alias, description, timeCreated, urls
    */
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping(value = {"add_author"}, method = RequestMethod.POST)
    public Object addAuthor(
            @RequestParam("amvId") int amvId,
            @RequestParam("authorId") int authorId){
        
        //auth check!!!
        int userId = 0;
        if (!permissionService.userHaveAccessForEdit(userId, amvId, userService, amvService)){
            return new ModelAndView(YOU_NOT_HAVE_ACCESS_FOR_EDIT_ERR);
        }
        
        if (userService.isUserExist(authorId)){
            amvService.addAuthor(amvId, authorId);
        } else {
            return new ModelAndView(AUTHOR_NOT_FOUND_ERR);
        }
        
        
        throw new UnsupportedOperationException();
    }
    
    @RequestMapping(value = {"update_poster/{alias}"})
    public Object updatePoster(@PathVariable("alias") String alias){
    /*
        Update: posterFile
    */
        throw new UnsupportedOperationException();
    }

    
}
