package ru.kvk.skeleton.module.main.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by King on 11.06.2015.
 */
@Controller
public class AuthorizationController {

    final static String moduleViewPath = "/main/authorization/";
    final static Logger logger = Logger.getLogger(AuthorizationController.class);

    @RequestMapping(value = "/sign_in",method = RequestMethod.GET)
    public ModelAndView signIn(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String logout,
            ModelAndView model){
        if (error != null) {
            logger.debug("Someone catch error on login form");
            model.addObject("error", "Неправильный логин или пароль!!");
        }else if (logout != null) {
            logger.debug("Someone logout");
            model.addObject("msg", "Вы вышли из системы.");
        }else{
            logger.debug("Someone open login form");
        }
        model.setViewName(moduleViewPath + "sign_in");
        return model;
    }

    @RequestMapping(value = "/access_denied",method = RequestMethod.GET)
    public String accessDenied(){
        logger.debug("Someone get 403 error");
        return moduleViewPath + "access_denied";
    }

}
