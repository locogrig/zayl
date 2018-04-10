package com.baizhi.common.entity;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Manager {
    private String id;
    private String mname;
    private String password;

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", mname='" + mname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manager(String id, String mname, String password) {

        this.id = id;
        this.mname = mname;
        this.password = password;
    }

    public Manager() {

    }
}
