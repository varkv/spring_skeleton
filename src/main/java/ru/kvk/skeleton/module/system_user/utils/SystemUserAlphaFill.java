package ru.kvk.skeleton.module.system_user.utils;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import ru.kvk.skeleton.module.system_user.entity.SystemRoleEntity;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;
import ru.kvk.skeleton.module.system_user.entity.enums.SystemRole;
import ru.kvk.skeleton.module.system_user.service.SystemUserService;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by King on 15.12.2015.
 */
@Profile("alpha")
@Component
public class SystemUserAlphaFill {
    final static Logger logger = Logger.getLogger(SystemUserAlphaFill.class);

    @Autowired
    SystemUserService systemUserService;

    @PostConstruct
    public void fillSystemUsersAtStartUp(){
        logger.info("Alpha version! Start fill users and roles");
        Map<String,SystemRole[]> users = new HashMap<>();
        users.put("user1",new SystemRole[]{SystemRole.ROLE_SYSTEM_USER_ADMIN});
        users.put("user",new SystemRole[]{SystemRole.ROLE_SYSTEM_USER_ADMIN});
        users.forEach((name, strings) -> {
            SystemUserEntity systemUser = new SystemUserEntity();
            systemUser.setLogin(name);
            systemUser.setPassword(systemUserService.encryptPassword(name));

            LinkedList<SystemRoleEntity> systemRolesList = new LinkedList<>();
            for (SystemRole role : users.get(name)) {
                SystemRoleEntity roleEntity = new SystemRoleEntity();
                roleEntity.setSystemRole(role);
                roleEntity.setSystemUserEntity(systemUser);
                systemRolesList.add(roleEntity);
            }
            systemUser.setSystemRolesCollection(systemRolesList);

            logger.debug("Added user " + systemUser);
            systemUserService.getSystemUserRepository().save(systemUser);
        });
        logger.debug("Alpha version! End fill users and roles");
    }
}
