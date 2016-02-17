package ru.kvk.skeleton.module.system_user.entity.dto;

import ru.kvk.skeleton.module.system_user.entity.SystemRoleEntity;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;

import java.util.Collection;

/**
 * Created by King on 07.01.2016.
 */
public class SystemUserWithRolesDto extends SystemUserLiteDto {

    public SystemUserWithRolesDto(SystemUserEntity systemUserEntity, Collection<SystemRoleEntity> systemRolesCollection) {
        super(systemUserEntity);
        this.systemRolesCollection = systemRolesCollection;
    }

    private Collection<SystemRoleEntity> systemRolesCollection;

    public Collection<SystemRoleEntity> getSystemRolesCollection() {
        return systemRolesCollection;
    }

    public void setSystemRolesCollection(Collection<SystemRoleEntity> systemRolesCollection) {
        this.systemRolesCollection = systemRolesCollection;
    }
}
