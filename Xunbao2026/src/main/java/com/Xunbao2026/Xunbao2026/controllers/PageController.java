package com.Xunbao2026.Xunbao2026.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {


    @RequestMapping("/login")
    public String login(@RequestParam(required = false) boolean registered,Model model) {
        if(registered){
            model.addAttribute("showSuccessMsg", "true");
        }
        else{
            model.addAttribute("showSuccessMsg", "false");
        }
        return "loginpage";
    }


}
