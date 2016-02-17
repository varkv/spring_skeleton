package ru.kvk.skeleton.module.system_user.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by King on 11.06.2015.
 */
@RequestMapping("/module/system_user")
@Controller
public class SystemUserController {

    final static String moduleViewPath = "/system_user/";
    final static Logger logger = Logger.getLogger(SystemUserController.class);

    @RequestMapping("/")
    public String index(){
        logger.debug("Request on /module/system_user/");
        return moduleViewPath+"default/main";
    }
}
