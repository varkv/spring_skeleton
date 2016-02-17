package ru.kvk.skeleton.module.system_user.entity;

import ru.kvk.skeleton.module.system_user.entity.enums.SystemRole;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


/**
 * Created by King on 11.12.2015.
 */
@Entity
@Table(name="system_role")
public class SystemRoleEntity {

    @Column(name = "ID", nullable = false, length = 36)
    @Id
    protected String id;

    @Basic(optional = false)
    @Column(name="rec_date", nullable = false)
    protected Date recDate;

    @Basic(optional = false)
    @Column(name="system_role", nullable = false)
    @Enumerated(EnumType.STRING)
    protected SystemRole systemRole;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "system_id_fk", nullable = false)
    protected SystemUserEntity systemUserEntity;

    public SystemRoleEntity() {
        this.id = UUID.randomUUID().toString();
        this.recDate = new Date();
    }

    public String getId() {
        return id;
    }

    public Date getRecDate() {
        return recDate;
    }

    public SystemRole getSystemRole() {
        return systemRole;
    }

    public void setSystemRole(SystemRole systemRole) {
        this.systemRole = systemRole;
    }

    public SystemUserEntity getSystemUserEntity() {
        return systemUserEntity;
    }

    public void setSystemUserEntity(SystemUserEntity systemUserEntity) {
        this.systemUserEntity = systemUserEntity;
    }

    @Override
    public String toString() {
        return "SystemRoleEntity{" +
                "id='" + id + '\'' +
                ", recDate=" + recDate +
                ", system_role=" + systemRole +
                '}';
    }
}
