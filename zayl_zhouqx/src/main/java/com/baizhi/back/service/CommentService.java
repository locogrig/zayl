package com.baizhi.back.service;



import com.baizhi.common.entity.Carousel;
import com.baizhi.common.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface CommentService {
    public List< Comment> queryAll();
    public void add( Comment  comment);
    public void remove(String id);
    public  Comment queryOne(String id);

    public List<Comment> queryAll(Integer page, Integer rows);
    public Integer queryCount();

    public List< Comment> queryBySerch(String name, String value, Integer page, Integer rows);

    public Integer queryCountBySearch(String name, String value);
}
