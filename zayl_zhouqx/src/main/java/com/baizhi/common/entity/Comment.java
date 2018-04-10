package com.baizhi.common.entity;

import java.util.Date;

public class Comment {
    private String id;
    private String userid;
    private String commentcontent;
    private String articleid;
    private Date date;

    private User user;
    private Article article;

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", userid='" + userid + '\'' +
                ", commentcontent='" + commentcontent + '\'' +
                ", articleid='" + articleid + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", article=" + article +
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

    public String getCommentcontent() {
        return commentcontent;
    }

    public void setCommentcontent(String commentcontent) {
        this.commentcontent = commentcontent;
    }

    public String getArticleid() {
        return articleid;
    }

    public void setArticleid(String articleid) {
        this.articleid = articleid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Comment(String userid, String commentcontent, String articleid, Date date) {

        this.userid = userid;
        this.commentcontent = commentcontent;
        this.articleid = articleid;
        this.date = date;
    }

    public Comment() {

    }
}
