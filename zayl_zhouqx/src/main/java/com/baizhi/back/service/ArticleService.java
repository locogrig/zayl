package com.baizhi.back.service;



import com.baizhi.common.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ArticleService {
    public List<Article> queryAll();

    public void remove(String id);
    public Article queryOne(String id);
    public void edit(Article article);
    public void sava(Article article);
    public List<Article> queryAll(Integer page, Integer rows);
    public Integer queryCount();
    public void editStatus(String id);


    //查询三行情书
    public  Integer   querySan();
    public  List<Article>  querySanAll(Integer  page,Integer  rows);

    //查询短文
    public  Integer   queryDuan();
    public  List<Article>  queryDuanAll(Integer  page,Integer  rows);

    //查询远方
    public  Integer   queryYuan();
    public  List<Article>  queryYuanAll(Integer  page,Integer  rows);



}
