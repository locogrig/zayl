package com.baizhi.front.service;

import com.baizhi.common.dao.ArticleDao;
import com.baizhi.common.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Service("frontArticleService")
@Transactional
public class FrontArticleServiceImpl implements FrontArticleService {
    @Autowired
    private ArticleDao articleDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryLei() {

        return articleDao.queryLei();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Article> queryLeiArticle(String calssifyid,Integer page, Integer rows) {
        int  a=(page-1)*rows;
        return   articleDao.quertByClassifypage(calssifyid,a,rows);

    }
}
