package com.baizhi.front.controller;

import com.baizhi.common.entity.Comment;
import com.baizhi.front.service.FrontCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Controller
@RequestMapping("/frontComment")
public class FrontCommentController {
    @Autowired
    private FrontCommentService frontCommentService;
    @RequestMapping("/queryComment")
    @ResponseBody
    public List<Comment> queryComment(String articleid){
        List<Comment> comments = frontCommentService.queryDuiyingComment(articleid);
        return comments;
    }
}
