package com.baizhi.back.service;

import com.baizhi.common.entity.Classify;

import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
public interface ClassifySservice {
    public List<Classify> queryAll();
    public void add(Classify classify);
    public void remove (String id);
    public Classify queryOne(String id);
    public void edit(Classify classify);
    public List<Classify> queryAll(Integer page,Integer rows);
    public Integer queryCount();

    public List<Classify> queryBySerch(String name,String value,Integer page,Integer rows);

    public Integer queryCountBySearch(String name,String value);
}
