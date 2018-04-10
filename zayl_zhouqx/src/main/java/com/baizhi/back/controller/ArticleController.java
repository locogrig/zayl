package com.baizhi.back.controller;

import com.alibaba.fastjson.JSONObject;
import com.baizhi.back.service.ArticleService;
import com.baizhi.common.entity.BasePage;
import com.baizhi.common.entity.Result;
import com.baizhi.common.entity.TotalRows;
import com.baizhi.common.entity.Article;
import com.baizhi.common.util.FileBrowserUtil;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public BasePage<Article> queryAllArticle(Integer page, Integer rows){

        List<Article> list = articleService.queryAll(page,rows);
        Integer count = articleService.queryCount();
        BasePage tls = new BasePage();
        tls.setRows(list);
        tls.setTotal(count);
        System.out.println(tls);
        return tls;
    }

    @ResponseBody
    @RequestMapping("/saveArticle")
    public Result save(String content,HttpServletRequest request){
        System.out.println(content);
        try{

            Article article = new Article();

            article.setContent(content);

            articleService.sava(article);


        }catch (Exception e){

            e.printStackTrace();


            return new Result(false,e.getMessage());
        }
        return new Result(true,"发表成功，等待审核");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void removeArticle(String id){
        articleService.remove(id);
    }

    @RequestMapping("/queryOne")
    @ResponseBody
    public Article queryOne(String id){
        Article article = articleService.queryOne(id);
        return article;
    }
    @RequestMapping("/edit")
    public void editArticle(Article Article){

        articleService.edit(Article);
    }

    @RequestMapping("/update")
    @ResponseBody
    public Result update(String id){
        try {
            articleService.editStatus(id);
        }catch (Exception e){
            e.printStackTrace();
            return new Result(false,e.getMessage());
        }
        return new Result(true,"操作成功");

    }

    /*三行情书*/
    //查询所有
    @RequestMapping("/showSan")
    @ResponseBody
    public  BasePage<Article>  showSan(Integer  page,Integer   rows){
        BasePage<Article>  tr=new BasePage<Article>();
        List<Article> articles = articleService.querySanAll(page, rows);
        Integer integer = articleService.querySan();
        tr.setTotal(integer);
        tr.setRows(articles);
        System.out.println(tr);
        return  tr;

    }
    /*短文*/
    @RequestMapping("/showDuan")
    @ResponseBody
    public  BasePage  showDuan(Integer  page,Integer   rows){
        BasePage<Article>  tr=new BasePage<Article>();
        List<Article> articles = articleService.queryDuanAll(page, rows);
        Integer integer = articleService.queryDuan();
        tr.setTotal(integer);
        tr.setRows(articles);
        System.out.println(tr);
        return  tr;
    }

    /*远方*/
    @RequestMapping("/showYuan")
    @ResponseBody
    public  BasePage  showYuan(Integer  page,Integer   rows){
        BasePage<Article>  tr=new BasePage<Article>();
        List<Article> articles = articleService.queryYuanAll(page, rows);
        Integer integer = articleService.queryYuan();
        tr.setTotal(integer);
        tr.setRows(articles);
        System.out.println(tr);
        return  tr;
    }


}
