package com.baizhi.common.dao;

import com.baizhi.common.entity.Classify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ClassifyDao extends BasicDao<Classify> {
    public Integer queryCount();
    public List<Classify> queryAll(@Param("page") Integer page,@Param("rows") Integer rows);
    public List<Classify> selectBySearch(@Param("name") String name,@Param("value") String value,@Param("page") Integer page,@Param("rows") Integer rows);
    public Integer queryCountBySearch(@Param("name") String name,@Param("value") String value);

    //查询所有语录模块下的子分类名称
    public List<Classify> querySecond();
    //查询所有没有子类的一级分类
    public List<Classify> queryFirst();
}
