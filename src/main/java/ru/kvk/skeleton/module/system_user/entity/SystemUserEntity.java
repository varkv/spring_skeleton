package ru.kvk.skeleton.module.system_user.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;


/**
 * Created by King on 11.12.2015.
 */
@Entity
@Table(name="system_user")
public class SystemUserEntity {

    @Column(name = "ID", nullable = false, length = 36)
    @Id
    protected String id;

    @Basic(optional = false)
    @Column(name="rec_date", nullable = false)
    protected Date recDate;

    @Basic(optional = false)
    @Column(name="login", nullable = false, unique = true)
    protected String login;

    @Basic(optional = false,fetch = FetchType.LAZY)
    @Column(name="password", nullable = false)
    protected String password;

    @Basic(optional = false)
    @Column(name="enabled", nullable = false)
    protected Boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "systemUserEntity", cascade = CascadeType.ALL, targetEntity = SystemRoleEntity.class)
    protected Collection<SystemRoleEntity> systemRolesCollection;

    public SystemUserEntity() {
        this.id = UUID.randomUUID().toString();
        this.recDate = new Date();
        this.enabled = true;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<SystemRoleEntity> getSystemRolesCollection() {
        return systemRolesCollection;
    }

    public void setSystemRolesCollection(Collection<SystemRoleEntity> systemRolesCollection) {
        this.systemRolesCollection = systemRolesCollection;
    }

    @Override
    public String toString() {
        return "SystemUserEntity{" +
                "id='" + id + '\'' +
                ", recDate=" + recDate +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", systemRolesCollection=" + systemRolesCollection +
                '}';
    }
}
