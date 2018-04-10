package com.baizhi.test;

import com.baizhi.common.entity.User;
import com.baizhi.front.service.FrontUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/12/1.
 */
public class UserTest extends BaseTest{
    @Autowired
    private FrontUserService frontUserService;
    @Test
    public void test1(){
        frontUserService.save(new User(null,"小飞飞",null,null,"123456",null,null,null));
    }
}
