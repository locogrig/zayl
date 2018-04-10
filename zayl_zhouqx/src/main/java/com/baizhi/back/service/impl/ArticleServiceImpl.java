package com.baizhi.back.service.impl;

import com.baizhi.back.service.ArticleService;
import com.baizhi.common.dao.ArticleDao;
import com.baizhi.common.entity.Article;
import com.baizhi.common.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> queryAll() {
        return articleDao.selectAll();
    }

    public void sava(Article article){
        article.setId(UUID.randomUUID().toString());
        article.setUserid("manager");
        article.setDate(new Date());
        article.setClickcount(1);
        article.setStatus("审核不通过");
        article.setClassifyid("6");
        article.setReadCount(1);

        articleDao.insert(article);
    }

    @Override
    public void remove(String id) {
        articleDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Article queryOne(String id) {
        return articleDao.selectOne(id);
    }

    @Override
    public void edit(Article article) {
        articleDao.update(article);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> queryAll(Integer page, Integer rows) {
        int a = (page-1)*rows;
        System.out.println(a);
        return articleDao.queryAll(a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return articleDao.queryCount();
    }

    public void editStatus(String id){

        articleDao.editStatus(id);
    }

    /*三行情书*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public  Integer  querySan(){
        return  articleDao.selectSan();
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public   List<Article>  querySanAll(Integer  page,Integer  rows){
        int  a=(page-1)*rows;
        return   articleDao.selectSanAll(a,rows);
    }

    /*短文*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public  Integer  queryDuan(){
        return  articleDao.selectDuan();
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    public   List<Article>  queryDuanAll(Integer  page,Integer  rows){
        int  a=(page-1)*rows;
        return   articleDao.selectDuanAll(a,rows);
    }
    /*远方*/
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryYuan() {
        return articleDao.selectYuan();
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> queryYuanAll(Integer page, Integer rows) {
        int  a=(page-1)*rows;
        return   articleDao.selectYuanAll(a,rows);
    }




}
