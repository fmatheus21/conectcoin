package com.firecode.app.controller.service;

import com.firecode.app.controller.util.AppUtil;
import com.firecode.app.controller.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class GlobalService {

    @Autowired
    private PathUtil pathUtil;

    public Model returnGlobalModal(Model model) {
        // String avatar = pathUtil.getDirUpload()+ pathUtil.getDirAvatar() + "avatar.png";
        String avatar = pathUtil.getDirAvatarSystem();
        model.addAttribute("userLogged", "");
        model.addAttribute("avatar", avatar);
        model.addAttribute("name", "Fernando Braga Matheus");
        model.addAttribute("userName", "fmatheus");
        model.addAttribute("firstName", this.returnFirstName("Fernando Braga Matheus"));
        model.addAttribute("firstCharacter", this.returnFirstCharacter("Fernando Braga Matheus"));
        model.addAttribute("footerLink", "http://firecodesystems.com");
        model.addAttribute("footerName", "Firecode Systems");

        return model;
    }

    /* Retorta o primeiro nome */
    private String returnFirstName(String value) {
        value = AppUtil.convertFirstUppercaseCharacter(value);
        return AppUtil.returnDelimiterString(value, " ");
    }

    /* Retorta o primeiro caracter de uma string */
    private String returnFirstCharacter(String value) {
        value = AppUtil.convertFirstUppercaseCharacter(value);
        return AppUtil.returnFirstWord(value);
    }

}
