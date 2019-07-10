package com.cskaoyan14th.bean;

import java.util.Arrays;

public class LogInfo {

    String avatar;

    String name;

    String[] perms;

    String[] roles;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPerms() {
        return perms;
    }

    public void setPerms(String[] perms) {
        this.perms = perms;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "LogInfo{" +
                "avatar='" + avatar + '\'' +
                ", name='" + name + '\'' +
                ", perms=" + Arrays.toString(perms) +
                ", roles=" + Arrays.toString(roles) +
                '}';
    }
}
