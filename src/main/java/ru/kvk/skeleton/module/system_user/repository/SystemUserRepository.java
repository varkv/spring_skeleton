package ru.kvk.skeleton.module.system_user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.kvk.skeleton.module.system_user.entity.SystemUserEntity;

/**
 * Created by King on 11.12.2015.
 */
@Repository
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public interface SystemUserRepository extends JpaRepository<SystemUserEntity,String> {
}
