package com.baizhi.front.service;

import com.baizhi.common.entity.Comment;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface FrontCommentService {
    public List<Comment> queryDuiyingComment(String articleid);
}
