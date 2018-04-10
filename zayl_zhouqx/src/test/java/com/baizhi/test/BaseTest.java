package com.baizhi.test;

import com.baizhi.Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
@RunWith(SpringRunner.class)//在测试类实例化时自动初始化springboot相关配置
@SpringBootTest(classes = {Application.class})
public class BaseTest {


}
