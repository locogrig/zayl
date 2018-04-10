package com.baizhi.common.dao;

import com.baizhi.common.entity.Carousel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface CarouselDao extends BasicDao<Carousel> {
    public Integer queryCount();
    public List<Carousel> queryAll(@Param("page") Integer page, @Param("rows") Integer rows);
    public List<Carousel> selectBySearch(@Param("name") String name,@Param("value") String value,@Param("page") Integer page,@Param("rows") Integer rows);
    public Integer queryCountBySearch(@Param("name") String name,@Param("value") String value);
}
