package com.baizhi.common.dao;

import com.baizhi.common.entity.Carousel;
import com.baizhi.common.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface CommentDao extends BasicDao<Comment> {
    public Integer queryCount();
    public List<Comment> queryAll(@Param("page") Integer page, @Param("rows") Integer rows);
    public List<Comment> selectBySearch(@Param("name") String name, @Param("value") String value, @Param("page") Integer page, @Param("rows") Integer rows);
    public Integer queryCountBySearch(@Param("name") String name, @Param("value") String value);

    //根据文章id查询对应的所有评论
    public List<Comment> queryDuiyingComment(String articleid);
}
