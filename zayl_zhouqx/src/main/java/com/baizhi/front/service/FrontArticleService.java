package com.baizhi.front.service;

import com.baizhi.common.entity.Article;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface FrontArticleService {
    //查询各个分类下面所有的文章
    public Integer queryLei();
    public List<Article> queryLeiArticle(String classifyid, Integer page,Integer rows);


}
