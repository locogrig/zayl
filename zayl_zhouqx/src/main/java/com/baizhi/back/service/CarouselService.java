package com.baizhi.back.service;



import com.baizhi.common.entity.Carousel;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface CarouselService {
    public List<Carousel> queryAll();
    public void add(Carousel carousel);
    public void remove(String id);
    public Carousel queryOne(String id);
    public void edit(Carousel carousel);
    public List<Carousel> queryAll(Integer page, Integer rows);
    public Integer queryCount();

    public List<Carousel> queryBySerch(String name, String value, Integer page, Integer rows);

    public Integer queryCountBySearch(String name, String value);
}
