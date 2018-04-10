package com.baizhi.back.service.impl;

import com.baizhi.back.service.CarouselService;

import com.baizhi.common.dao.CarouselDao;

import com.baizhi.common.entity.Carousel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service("carouselService")
@Transactional
public class CarouselServiceImpl implements CarouselService {
    @Autowired
    private CarouselDao carouselDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> queryAll() {
        List<Carousel> carousels = carouselDao.selectAll();

        return carousels;
    }

    @Override
    public void add(Carousel carousel) {
        carousel.setId(UUID.randomUUID().toString());

        carouselDao.insert(carousel);
    }

    @Override
    public void remove(String id) {
        carouselDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Carousel queryOne(String id) {
        return carouselDao.selectOne(id);
    }

    @Override
    public void edit(Carousel carousel) {
        carouselDao.update(carousel);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> queryAll(Integer page, Integer rows) {
        int a = (page-1)*rows;
        System.out.println(a);
        return carouselDao.queryAll(a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return carouselDao.queryCount();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Carousel> queryBySerch(String name, String value, Integer page, Integer rows) {
        int a=(page-1)*rows;
        return carouselDao.selectBySearch(name,value,a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCountBySearch(String name, String value) {
        return carouselDao.queryCountBySearch(name,value);
    }
}
