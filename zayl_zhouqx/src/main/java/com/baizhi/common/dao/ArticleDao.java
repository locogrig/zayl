package com.baizhi.common.dao;

import com.baizhi.common.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/30.
 */
public interface ArticleDao extends BasicDao<Article> {
    //查询语录
    public Integer queryCount();
    public List<Article> queryAll(@Param("page") Integer page, @Param("rows") Integer rows);
    //修改状态
    public void editStatus(String id);
    //查询三行情书
    public  Integer   selectSan();
    public  List<Article>   selectSanAll(@Param("page")Integer page, @Param("rows")Integer rows);
    //查询短文
    public  Integer   selectDuan();
    public  List<Article>   selectDuanAll(@Param("page")Integer page, @Param("rows")Integer rows);
    //查询远方
    public  Integer   selectYuan();
    public  List<Article>   selectYuanAll(@Param("page")Integer page, @Param("rows")Integer rows);
    //同过类别id查询所属类别下的所有文章
    public  Integer   queryLei();
    public List<Article> quertByClassifypage(@Param("calssifyid")String calssifyid,@Param("page")Integer page, @Param("rows")Integer rows);

}
