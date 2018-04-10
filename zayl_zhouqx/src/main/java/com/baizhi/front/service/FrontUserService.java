package com.baizhi.front.service;

import com.baizhi.common.entity.User;

/**
 * Created by Administrator on 2017/12/1.
 */
public interface FrontUserService {
    public void save(User user);

    public void editUser(User user);

    public User login(User user);
}
