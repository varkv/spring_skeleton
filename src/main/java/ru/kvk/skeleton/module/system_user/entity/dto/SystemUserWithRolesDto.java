package ru.kvk.skeleton.module.system_user.entity.dto;

import ru.kvk.skeleton.module.system_user.entity.SystemRoleEntity;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by King on 07.01.2016.
 */
public class SystemUserWithRolesDto extends SystemUserLiteDto {

    private Collection<SystemRoleDto> systemRolesCollection;

    public SystemUserWithRolesDto(SystemUserEntity systemUserEntity) {
        super(systemUserEntity);
        this.systemRolesCollection = systemUserEntity.getSystemRolesCollection().stream().map(SystemRoleDto::new)
                .collect(Collectors.toList());
    }

    public Collection<SystemRoleDto> getSystemRolesCollection() {
        return systemRolesCollection;
    }

    public void setSystemRolesCollection(Collection<SystemRoleDto> systemRolesCollection) {
        this.systemRolesCollection = systemRolesCollection;
    }
}
