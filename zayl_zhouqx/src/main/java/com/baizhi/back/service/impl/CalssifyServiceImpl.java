package com.baizhi.back.service.impl;

import com.baizhi.back.service.ClassifySservice;
import com.baizhi.common.dao.ClassifyDao;
import com.baizhi.common.entity.Classify;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Service("classifySservice")
@Transactional
public class CalssifyServiceImpl implements ClassifySservice {
    @Autowired
    private ClassifyDao classifyDao;
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Classify> queryAll() {
        List<Classify> classifies = classifyDao.selectAll();

        return classifies;
    }

    @Override
    public void add(Classify classify) {
        classify.setId(UUID.randomUUID().toString());
        classifyDao.insert(classify);
    }

    @Override
    public void remove(String id) {
        classifyDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Classify queryOne(String id) {
        return classifyDao.selectOne(id);
    }

    @Override
    public void edit(Classify classify) {
        classifyDao.update(classify);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Classify> queryAll(Integer page, Integer rows) {
        int a = (page-1)*rows;
        System.out.println(a);
        return classifyDao.queryAll(a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCount() {
        return classifyDao.queryCount();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Classify> queryBySerch(String name, String value, Integer page, Integer rows) {
        int a=(page-1)*rows;
        return classifyDao.selectBySearch(name,value,a,rows);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer queryCountBySearch(String name, String value) {
        return classifyDao.queryCountBySearch(name,value);
    }
}
