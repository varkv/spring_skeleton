package ru.kvk.skeleton.module.system_user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;
import ru.kvk.skeleton.module.system_user.repository.SystemUserRepository;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

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
}
