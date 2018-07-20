package secure;

import com.renory.secure.dto.RegInfoDto;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author smit
 */
public class ContentCreater {

    RegInfoDto getMember() {
        RegInfoDto dto = new RegInfoDto();
        dto.setLogin("TestLogin");
        dto.setNickName("testNickname");
        dto.setPassword("test_password");
        dto.setPassword2("test_password");
        dto.setEmail("test_email@mail.com");
        return dto;
    }
    
    RegInfoDto getBadMember() {
        RegInfoDto dto = new RegInfoDto();
        dto.setLogin("fuck");
        dto.setNickName("sex");
        dto.setPassword("test_password");
        dto.setPassword2("test_password");
        dto.setEmail("test_email@mail.com");
        return dto;
    }
    
}
