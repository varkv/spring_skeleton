package ru.kvk.skeleton.module.system_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;
import ru.kvk.skeleton.module.system_user.entity.dto.SystemUserWithRolesDto;
import ru.kvk.skeleton.module.system_user.entity.enums.SystemRole;
import ru.kvk.skeleton.module.system_user.repository.SystemUserRepository;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by King on 11.12.2015.
 */
@Service
public class SystemUserService {
    @Autowired
    SystemUserRepository systemUserRepository;
    public SystemUserRepository getSystemUserRepository() {
        return systemUserRepository;
    }

    public String encryptPassword(String pwd){
        return BCrypt.hashpw(pwd, BCrypt.gensalt());
    }
    public boolean checkEncryptPassworD(String pwd,String hashedRwd){
        return BCrypt.checkpw(pwd, hashedRwd);
    }

    public Collection<SystemUserEntity> gelListUser(){
        return systemUserRepository.findAll();
    }

    public Collection<Map<String,String>> gelListUserRoleName(){
        return Arrays.stream(SystemRole.values()).map(
            systemRole -> {
                Map<String, String> map = new HashMap<String, String>();
                map.put("code_name",systemRole.name());
                map.put("name",systemRole.toString());
                return map;
        }).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public SystemUserWithRolesDto getSystemUserWithRoles(String guid){
        SystemUserEntity systemUserEntity = systemUserRepository.findOne(guid);
        return new SystemUserWithRolesDto(systemUserEntity);
    }
}
