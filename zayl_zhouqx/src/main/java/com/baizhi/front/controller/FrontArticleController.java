package com.baizhi.front.controller;

import com.baizhi.common.entity.Article;
import com.baizhi.common.entity.BasePage;
import com.baizhi.front.service.FrontArticleService;
import com.baizhi.front.service.FrontUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Controller
@RequestMapping("/frontArticle")
public class FrontArticleController {

    @Autowired
    private FrontArticleService frontArticleService;

    //展示各个分类下面对应的所有文章
    @RequestMapping("/duiying")
    @ResponseBody
    public BasePage showYuan(String id,Integer  page, Integer   rows){
        BasePage<Article>  tr=new BasePage<Article>();
        List<Article> articles = frontArticleService.queryLeiArticle(id,page, rows);
        Integer integer = frontArticleService.queryLei();
        tr.setTotal(integer);
        tr.setRows(articles);
        System.out.println(tr);
        return  tr;
    }
}
