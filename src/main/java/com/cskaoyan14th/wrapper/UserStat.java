package com.cskaoyan14th.wrapper;


import java.sql.Date;

public class UserStat {
    private Date day;
    private int users;

    public UserStat() {
    }

    public UserStat(Date day, int users) {
        this.day = day;
        this.users = users;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "UserStat{" +
                "day=" + day +
                ", users=" + users +
                '}';
    }
}
