package ru.kvk.skeleton.module.system_user.entity.dto;

import ru.kvk.skeleton.module.system_user.entity.SystemRoleEntity;
import ru.kvk.skeleton.module.system_user.entity.enums.SystemRole;

import java.util.Date;

/**
 * Created by King on 07.01.2016.
 */
public class SystemRoleDto {

    protected String id;
    protected Date recDate;
    protected SystemRole systemRole;

    public SystemRoleDto() {}
    public SystemRoleDto(SystemRoleEntity systemRoleEntity) {
        this.id = systemRoleEntity.getId();
        this.recDate = systemRoleEntity.getRecDate();
        this.systemRole = systemRoleEntity.getSystemRole();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }
}
