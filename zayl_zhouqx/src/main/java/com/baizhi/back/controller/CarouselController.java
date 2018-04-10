package com.baizhi.back.controller;

import com.baizhi.back.service.CarouselService;
import com.baizhi.back.service.ClassifySservice;
import com.baizhi.common.entity.BasePage;
import com.baizhi.common.entity.Carousel;
import com.baizhi.common.entity.Classify;
import com.baizhi.common.entity.Result;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Administrator on 2017/11/29.
 */
@Controller
@RequestMapping("carousel")
public class CarouselController {
    @Resource
    private CarouselService carouselService;


    @RequestMapping("/queryAll")
    @ResponseBody
    public BasePage<Carousel> queryAllUser(Integer page, Integer rows){

        List<Carousel> list = carouselService.queryAll(page,rows);
        Integer count = carouselService.queryCount();
        BasePage tls = new BasePage();
        tls.setRows(list);
        tls.setTotal(count);
        System.out.println(tls);
        return tls;
    }
    @RequestMapping("/sava")
    public void savaCarousel(Carousel carousel){
        carouselService.add(carousel);

    }
    @RequestMapping("/delete")
    @ResponseBody
    public void removeCarousel(String id){

        carouselService.remove(id);
    }
    @RequestMapping("/queryOne")
    @ResponseBody
    public Carousel queryOne(String id){
        Carousel carousel = carouselService.queryOne(id);
        return carousel;
    }
    @RequestMapping("/edit")
    public void editCarousel(Carousel carousel){

        carouselService.edit(carousel);
    }
    @ResponseBody
    @RequestMapping("/queryBySearch")
    public BasePage<Classify> carouselService(Integer page,Integer rows,String name,String value){
        Integer total = carouselService.queryCountBySearch(name, value);
        List<Carousel> list = carouselService.queryBySerch(name, value, page, rows);
        BasePage totalRows = new BasePage(total, list);
        return totalRows;

    }
    @ResponseBody
    @RequestMapping("/upload")
    public Result insert(String title, String descs, MultipartFile aa, HttpServletRequest request){
        Result productVO=new Result();
        String newFileName=null;
        try {
            //获取文件名
            String fileName = aa.getOriginalFilename();
            System.out.println(title);
            System.out.println(descs);
            System.out.println("原文件名字"+fileName);
            //获取文件类型
            long size = aa.getSize();
            //处理上传
            String realPath = request.getRealPath("/upload");
            //上传文件
            //获得文件后缀
            String extension= FilenameUtils.getExtension(fileName);

            newFileName= UUID.randomUUID().toString().replace("-","")+"."+extension;

            aa.transferTo(new File(realPath,newFileName));
            //保存到数据库
            Carousel banner=new Carousel();
            //保存图片的路径
            banner.setPath(realPath);
            banner.setTitle(title);
            banner.setDescs(descs);
            banner.setFilename(newFileName);
            carouselService.add(banner);
            productVO.setSuccess(true);
            productVO.setMsg("添加轮播图成功");
            //throw new RuntimeException("出错了...");
        } catch (Exception e) {
            System.out.println("异常的名字："+newFileName);
            File file = new File(request.getRealPath("/upload"),newFileName);
            file.delete();
            e.printStackTrace();
            productVO.setSuccess(false);
            productVO.setMsg("添加轮播图失败");
        }
        return productVO;
    }

}
