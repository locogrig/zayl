package com.baizhi.common.dao;

import com.baizhi.common.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface UserDao extends BasicDao<User>{

    public User queryByNickname(String nickname);
    public Integer queryCount();

    public List<User> queryAll(@Param("page") Integer page, @Param("rows") Integer rows);

    public List<User> selectBySearch(@Param("name") String name,@Param("value") String value,@Param("page") Integer page,@Param("rows") Integer rows);

    public Integer queryCountBySearch(@Param("name") String name,@Param("value") String value);
}
