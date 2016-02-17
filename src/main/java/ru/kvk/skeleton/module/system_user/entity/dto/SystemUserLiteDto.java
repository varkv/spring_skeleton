package ru.kvk.skeleton.module.system_user.entity.dto;

import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;

import java.util.Date;

/**
 * Created by King on 07.01.2016.
 */
public class SystemUserLiteDto {

    protected String id;
    protected Date recDate;
    protected String login;
    protected Boolean enabled;

    public SystemUserLiteDto(String id, Date recDate, String login, Boolean enabled) {
        this.id = id;
        this.recDate = recDate;
        this.login = login;
        this.enabled = enabled;
    }

    public SystemUserLiteDto(SystemUserEntity systemUserEntity) {
        this.id = systemUserEntity.getId();
        this.recDate = systemUserEntity.getRecDate();
        this.login = systemUserEntity.getLogin();
        this.enabled = systemUserEntity.getEnabled();
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public String toString() {
        return "SystemUserLiteDto{" +
                "id='" + id + '\'' +
                ", recDate=" + recDate +
                ", login='" + login + '\'' +
                ", enabled=" + enabled +
                '}';
    }
}
