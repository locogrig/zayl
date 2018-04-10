package com.baizhi.test;

import com.baizhi.back.service.ManagerService;
import com.baizhi.common.entity.Manager;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2017/11/28.
 */
public class ManagerTest extends BaseTest {
    @Autowired
    private ManagerService managerService;
    @Test
    public void test1(){
        managerService.sava(new Manager(null,"袁飞","123456"));
    }

    @Test
    public void test2(){
        Manager manager = managerService.login(new Manager(null, "袁飞", "123456"));
        System.out.println(manager);
    }
}
