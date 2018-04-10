package com.baizhi.front.service;

import com.baizhi.common.dao.ClassifyDao;
import com.baizhi.common.entity.Classify;
import com.baizhi.front.mybean.AddCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("frontClassifyService")
public class FrontClassifyServiceImpl implements FrontClassifyService{
    @Autowired
    private ClassifyDao classifyDao;
    @Override
    @AddCache
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Classify> querySecond() {
        return classifyDao.querySecond();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Classify> queryFirst() {
        return classifyDao.queryFirst();
    }
}
