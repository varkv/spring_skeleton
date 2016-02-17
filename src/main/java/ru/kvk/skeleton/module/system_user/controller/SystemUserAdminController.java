package ru.kvk.skeleton.module.system_user.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;
import ru.kvk.skeleton.module.system_user.entity.dto.SystemUserLiteDto;
import ru.kvk.skeleton.module.system_user.entity.dto.SystemUserWithRolesDto;
import ru.kvk.skeleton.module.system_user.service.SystemUserService;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by King on 11.06.2015.
 */
@RequestMapping("/module/system_user/admin")
@Controller
public class SystemUserAdminController {
    final static String moduleViewPath = "/system_user/admin/";
    final static Logger logger = Logger.getLogger(SystemUserAdminController.class);

    @Autowired
    SystemUserService systemUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model){
        logger.debug("Request on /module/system_user/admin/");
        model.addAttribute("roles",systemUserService.gelListUserRoleName());
        return moduleViewPath+"main";
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST
            ,produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody Collection<SystemUserLiteDto> getUserList(){
        logger.debug("Request on /module/system_user/admin get user list");
        Collection<SystemUserLiteDto>  res =  systemUserService.gelListUser().stream().map(systemUserEntity ->  new SystemUserLiteDto(systemUserEntity)).collect(Collectors.toList());
        System.out.println(res);
        return res;
    }

    @RequestMapping(value = "/{guid}",
            method = RequestMethod.GET
            ,produces = MediaType.APPLICATION_JSON_VALUE
            ,consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public @ResponseBody SystemUserWithRolesDto getUserFullData(
            @PathVariable(value = "guid") String guid
    ){
        logger.debug("Request on /module/system_user/admin get user full data");
        return systemUserService.getSystemUserWithRoles(guid);
    }

}
