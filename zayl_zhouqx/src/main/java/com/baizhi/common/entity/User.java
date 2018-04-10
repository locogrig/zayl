package com.baizhi.common.entity;

/**
 * Created by Administrator on 2017/11/28.
 */
public class User {
    private String id;
    private String nickname;
    private String uname;
    private String sign;
    private String password;
    private String salt;
    private String path;
    private String status;

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", nickname='" + nickname + '\'' +
                ", uname='" + uname + '\'' +
                ", sign='" + sign + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", path='" + path + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User(String id, String nickname, String uname, String sign, String password, String salt, String path, String status) {

        this.id = id;
        this.nickname = nickname;
        this.uname = uname;
        this.sign = sign;
        this.password = password;
        this.salt = salt;
        this.path = path;
        this.status = status;
    }

    public User() {

    }
}
