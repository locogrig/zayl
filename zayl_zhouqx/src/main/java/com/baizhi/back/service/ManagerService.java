package com.baizhi.back.service;

import com.baizhi.common.entity.Count;
import com.baizhi.common.entity.Manager;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public interface ManagerService {
    public int sava(Manager manager);
    public Manager login(Manager manager);
    public List<Count> queryClassifyCount();
}
