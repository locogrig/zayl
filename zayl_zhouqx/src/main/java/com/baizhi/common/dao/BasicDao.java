package com.baizhi.common.dao;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
public interface BasicDao <T>{

    public int insert(T t);

    public int delete(String id);

    public int update(T t);

    public T selectOne(String id);

    public List<T> selectAll();
}
