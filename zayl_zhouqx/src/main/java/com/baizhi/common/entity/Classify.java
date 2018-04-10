package com.baizhi.common.entity;

/**
 * Created by Administrator on 2017/11/29.
 */
public class Classify {
    private String id;
    private String cname;
    private String parentid;

    @Override
    public String toString() {
        return "classify{" +
                "id='" + id + '\'' +
                ", cname='" + cname + '\'' +
                ", parentid='" + parentid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Classify(String id, String cname, String parentid) {

        this.id = id;
        this.cname = cname;
        this.parentid = parentid;
    }

    public Classify() {

    }
}
