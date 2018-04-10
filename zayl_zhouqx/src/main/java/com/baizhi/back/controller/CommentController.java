package com.baizhi.back.controller;

import com.baizhi.back.service.CarouselService;
import com.baizhi.back.service.CommentService;
import com.baizhi.common.entity.BasePage;
import com.baizhi.common.entity.Carousel;
import com.baizhi.common.entity.Classify;
import com.baizhi.common.entity.Comment;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
@RequestMapping("comment")
public class CommentController {
    @Resource
    private CommentService commentService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public BasePage<Comment> queryAllComment(Integer page, Integer rows){

        List<Comment> list = commentService.queryAll(page,rows);
        Integer count = commentService.queryCount();
        BasePage tls = new BasePage();
        tls.setRows(list);
        tls.setTotal(count);
        System.out.println(tls);
        return tls;
    }

    @RequestMapping("/delete")
    public void removeComment(String id){

        commentService.remove(id);
    }
    @RequestMapping("/queryOne")
    @ResponseBody
    public Comment queryOne(String id){
        Comment comment = commentService.queryOne(id);
        return comment;
    }

    @ResponseBody
    @RequestMapping("/queryBySearch")
    public BasePage<Comment> carouselService(Integer page,Integer rows,String name,String value){
        Integer total = commentService.queryCountBySearch(name, value);
        List<Comment> list = commentService.queryBySerch(name, value, page, rows);
        BasePage totalRows = new BasePage(total, list);
        return totalRows;

    }


}
