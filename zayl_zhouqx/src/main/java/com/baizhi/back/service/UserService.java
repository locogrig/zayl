package com.baizhi.back.service;

import com.baizhi.common.entity.User;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface UserService {
    public List<User> selectAll();
    public List<User> queryAll();

    public void add(User user);

    public void remove(String id);

    public User queryOne(String id);

    public void edit(User user);

    public List<User> queryAll(Integer page,Integer rows);

    public Integer queryCount();

    public List<User> queryBySerch(String name,String value,Integer page,Integer rows);

    public Integer queryCountBySearch(String name,String value);
}
