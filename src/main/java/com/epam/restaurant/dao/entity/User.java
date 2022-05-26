package com.epam.restaurant.dao.entity;

import java.io.Serializable;
import java.util.Date;

public class User {

    private long id;
    private String login;
    private String password;
    private long roleId;

    public User() {

    }

    public User(String login, String password, long roleId) {
        this.setLogin(login);
        this.setPassword(password);
        this.setRoleId(roleId);

    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }
}
