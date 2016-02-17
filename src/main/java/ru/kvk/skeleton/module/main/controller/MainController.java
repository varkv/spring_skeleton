package ru.kvk.skeleton.module.main.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by King on 11.06.2015.
 */
@Controller
public class MainController {

    final static String moduleViewPath = "/main/";
    final static Logger logger = Logger.getLogger(MainController.class);

    @RequestMapping("/")
    public String main(){
        logger.debug("Request on main /");
        return moduleViewPath+"main";
    }

    @RequestMapping("/component/main_panel")
    public String main_panel(ModelMap model, Principal principal){
        logger.debug("Request on main/main_panel");
        if(principal != null) {
            model.addAttribute("login", principal.getName());
        }
        return moduleViewPath+"component/main_panel";
    }
}
