package com.baizhi.front.service;

import com.baizhi.common.dao.CommentDao;
import com.baizhi.common.entity.Comment;
import com.baizhi.front.mybean.AddCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Service
@Transactional
public class FrontCommentServiceImpl implements FrontCommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    @AddCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Comment> queryDuiyingComment(String articleid) {
        return commentDao.queryDuiyingComment(articleid);
    }
}
