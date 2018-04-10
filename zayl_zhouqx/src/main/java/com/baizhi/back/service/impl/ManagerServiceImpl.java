package com.baizhi.back.service.impl;

import com.baizhi.back.service.ManagerService;
import com.baizhi.common.dao.ManagerDao;
import com.baizhi.common.entity.Count;
import com.baizhi.common.entity.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/28.
 */
@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService {
    @Resource
    private ManagerDao managerDao;

    @Override
    public int sava(Manager manager) {
        Manager managerDB = managerDao.selectByName(manager.getMname());
        int result = 0;
        if (managerDB == null) {
            //保存用户
            //1.生成id
            manager.setId(UUID.randomUUID().toString());

            result = managerDao.insert(manager);

        } else {
            throw new RuntimeException("管理员已经存在~~~");
        }


        return result;
    }

    @Override
    public Manager login(Manager manager) {
        //1.根据用户查询用户
        Manager managerDB = managerDao.selectByName(manager.getMname());
        if (managerDB != null) {
            //2.验证密码

            if ((managerDB.getPassword()).equals(manager.getPassword())) {
                return managerDB;
            }
            throw new RuntimeException("密码输入错误....");
        }
        throw new RuntimeException("用户名不存在~~~");

    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Count> queryClassifyCount() {
        List<Count> counts = managerDao.queryClassifyCount();
        return counts;
    }
}
