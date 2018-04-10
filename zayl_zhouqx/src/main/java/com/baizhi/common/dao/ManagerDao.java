package com.baizhi.common.dao;

import com.baizhi.common.entity.Count;
import com.baizhi.common.entity.Manager;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface ManagerDao extends BasicDao<Manager> {
    public Manager selectByName(String mname);

    public List<Count> queryClassifyCount();

}
