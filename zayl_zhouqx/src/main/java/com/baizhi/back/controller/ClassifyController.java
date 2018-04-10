package com.baizhi.back.controller;

import com.baizhi.back.service.ClassifySservice;
import com.baizhi.common.entity.BasePage;
import com.baizhi.common.entity.Classify;
import com.baizhi.common.entity.TotalRows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
@RequestMapping("classify")
public class ClassifyController {
    @Resource
    private ClassifySservice classifySservice;


    @RequestMapping("/queryAll")
    @ResponseBody
    public BasePage<Classify> queryAllUser(Integer page, Integer rows){

        List<Classify> list = classifySservice.queryAll(page,rows);
        Integer count = classifySservice.queryCount();
        BasePage tls = new BasePage();
        tls.setRows(list);
        tls.setTotal(count);
        System.out.println(tls);
        return tls;
    }
    @RequestMapping("/sava")
    public void savaClassify(Classify classify){
        classifySservice.add(classify);

    }
    @RequestMapping("/delete")
    public void removeClassify(String id){

        classifySservice.remove(id);
    }
    @RequestMapping("/queryOne")
    @ResponseBody
    public Classify queryOne(String id){
        Classify classify = classifySservice.queryOne(id);
        return classify;
    }
    @RequestMapping("/edit")
    public void editClassify(Classify classify){

        classifySservice.edit(classify);
    }
    @ResponseBody
    @RequestMapping("/queryBySearch")
    public BasePage<Classify> queryBySearch(Integer page,Integer rows,String name,String value){
        Integer total = classifySservice.queryCountBySearch(name, value);
        List<Classify> list = classifySservice.queryBySerch(name, value, page, rows);
        BasePage totalRows = new BasePage(total, list);
        return totalRows;

    }
}
