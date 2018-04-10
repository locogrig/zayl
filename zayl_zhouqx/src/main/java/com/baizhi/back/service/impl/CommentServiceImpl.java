package com.baizhi.back.service.impl;

import com.baizhi.back.service.CarouselService;
import com.baizhi.back.service.CommentService;
import com.baizhi.common.dao.CarouselDao;
import com.baizhi.common.dao.CommentDao;

import com.baizhi.common.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service("commentService")
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Comment> queryAll() {
        List<Comment> comments = commentDao.selectAll();

        return comments;
    }

    @Override
    public void add(Comment comment) {
        comment.setId(UUID.randomUUID().toString());
        comment.setDate(new Date());
        commentDao.insert(comment);
    }

    @Override
    public void remove(String id) {
        commentDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Comment queryOne(String id) {
        return commentDao.selectOne(id);
    }



    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Comment> queryAll(Integer page, Integer rows) {
        int a = (page-1)*rows;
        System.out.println(a);
        return commentDao.queryAll(a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return commentDao.queryCount();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Comment> queryBySerch(String name, String value, Integer page, Integer rows) {
        int a=(page-1)*rows;
        return commentDao.selectBySearch(name,value,a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCountBySearch(String name, String value) {
        return commentDao.queryCountBySearch(name,value);
    }
}
