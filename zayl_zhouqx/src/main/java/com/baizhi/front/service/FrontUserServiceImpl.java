package com.baizhi.front.service;

import com.baizhi.common.dao.UserDao;
import com.baizhi.common.entity.User;
import com.baizhi.common.util.SaltUtils;
import com.baizhi.front.mybean.AddCache;
import com.baizhi.front.mybean.RemoveCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created by Administrator on 2017/12/1.
 */
@Transactional
@Service("frontUserService")
public class FrontUserServiceImpl implements FrontUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) {
        //处理核心业务
        User userDB = userDao.queryByNickname(user.getNickname());
        if(userDB==null){
            //保存用户
            //1.生成id
            user.setId(UUID.randomUUID().toString());
            //2.生成salt
            String salt = SaltUtils.getSalt(4);
            //3.生成MD5密码   明文+salt 做md5加密
            String md5pwd = DigestUtils.md5DigestAsHex((user.getPassword() + salt).getBytes());
            //4.保存新的密码
            user.setPassword(md5pwd);
            //5.保存盐
            user.setSalt(salt);
            //6.保存状态
            user.setStatus("已激活");
            //7.保存用户
            userDao.insert(user);

        }else{
            throw new RuntimeException("用户名已经存在~~~");
        }
    }

    @Override
    @RemoveCache
    public void editUser(User user) {
        userDao.insert(user);

    }

    @Override
    @AddCache
    public User login(User user) {
//1.根据用户查询用户
        User userDB = userDao.queryByNickname(user.getNickname());
        if(userDB!=null){
            //2.验证密码
            //3.将用户前台输入明文密码+ 数据库中的salt  进行MD5加密
            String md5DigestAsHex = DigestUtils.md5DigestAsHex((user.getPassword() + userDB.getSalt()).getBytes());
            //4.比较md5密码与数据库用户的密码
            if(md5DigestAsHex.equals(userDB.getPassword())){
                if(userDB.getStatus().equals("未激活")){
                    throw new RuntimeException("该账户已经被冻结");
                }
                return userDB;
            }
            throw new RuntimeException("密码输入错误....");
        }
        throw  new  RuntimeException("用户名不存在~~~");
    }

}
