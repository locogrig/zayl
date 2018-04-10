package com.baizhi.front.controller;

import com.baizhi.common.entity.Classify;
import com.baizhi.front.service.FrontClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2017/12/1.
 */
@Controller
@RequestMapping("/frontClassify")
public class FrontClassifyController {
    @Autowired
    private FrontClassifyService frontClassifyService;

    /*查询所有二级标签*/
    @RequestMapping("/querySecond")
    @ResponseBody
    public List<Classify> queryScond(){
        List<Classify> classifies = frontClassifyService.querySecond();
        return classifies;
    }

    @RequestMapping("/queryFirst")
    @ResponseBody
    public List<Classify> queryFirst(){
        List<Classify> classifies = frontClassifyService.queryFirst();
        return classifies;
    }
}
