package ru.kvk.skeleton.module.system_user.entity.enums;

/**
 * Created by King on 14.12.2015.
 */
public enum SystemRole {
    ROLE_SYSTEM_USER_ADMIN,
    ROLE_GUEST,
    ROLE_TEST1,
    ROLE_TEST2;


    @Override
    public String toString() {
        String name = "";
        switch (this){
            case ROLE_GUEST: name = "Гость";break;
            case ROLE_SYSTEM_USER_ADMIN: name = "Администратор системных пользователей";break;
            case ROLE_TEST1: name = "Тест 1";break;
            case ROLE_TEST2: name = "Тест 1";break;
        }
        return name;
    }
}
