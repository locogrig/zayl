package com.baizhi.common.entity;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/28.
 */
public class Article {

    private String id;
    private String userid;

    private Date date;
    private Integer clickcount;
    private String content;
    private String status;
    private String classifyid;
    private Integer readCount;
    private String title;

    private User user;
    private Classify classify;


    @Override
    public String toString() {
        return "Article{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", date=" + date +
                ", clickcount=" + clickcount +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                ", classifyid='" + classifyid + '\'' +
                ", readCount=" + readCount +
                ", title='" + title + '\'' +
                ", user=" + user +
                ", classify=" + classify +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getClickcount() {
        return clickcount;
    }

    public void setClickcount(Integer clickcount) {
        this.clickcount = clickcount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getClassifyid() {
        return classifyid;
    }

    public void setClassifyid(String classifyid) {
        this.classifyid = classifyid;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Classify getClassify() {
        return classify;
    }

    public void setClassify(Classify classify) {
        this.classify = classify;
    }

    public Article(String id, String userid, Date date, Integer clickcount, String content, String status, String classifyid, Integer readCount, String title) {

        this.id = id;
        this.userid = userid;
        this.date = date;
        this.clickcount = clickcount;
        this.content = content;
        this.status = status;
        this.classifyid = classifyid;
        this.readCount = readCount;
        this.title = title;
    }

    public Article() {

    }
}
