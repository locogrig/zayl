package com.baizhi.back.controller;

import com.baizhi.back.service.UserService;
import com.baizhi.common.entity.TotalRows;
import com.baizhi.common.entity.User;
import com.baizhi.common.util.PoiUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import static org.apache.commons.io.FilenameUtils.getExtension;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/queryAll")
    @ResponseBody
    public TotalRows queryAllUser(Integer page, Integer rows){

        List<User> list = userService.queryAll(page,rows);
        Integer count = userService.queryCount();
        TotalRows tls = new TotalRows();
        tls.setRows(list);
        tls.setTotal(count);
        System.out.println(tls);
        return tls;
    }
    @RequestMapping("/sava")
    public void savaUser(User user){
        userService.add(user);

    }
    @RequestMapping("/delete")
    public void removeUser(String id){

        userService.remove(id);
    }
    @RequestMapping("/queryOne")
    @ResponseBody
    public User queryOne(String id){
        User user = userService.queryOne(id);
        return user;
    }
    @RequestMapping("/edit")
    public void editUser(User user){

        userService.edit(user);
    }
    @ResponseBody
    @RequestMapping("/queryBySearch")
    public TotalRows queryBySearch(Integer page,Integer rows,String name,String value){
        Integer total = userService.queryCountBySearch(name, value);
        List<User> list = userService.queryBySerch(name, value, page, rows);
        TotalRows totalRows = new TotalRows(total, list);
        return totalRows;

    }
/*    @RequestMapping("/importemp")
    @ResponseBody
    public String importemp() throws IOException, IllegalAccessException, InstantiationException {

        List<User> users = PoiUtil.importExcel(User.class, new FileInputStream("F://userExcle.xls"));
        for (User user : users) {
            userService.add(user);
        }

        return "ok";
    }*/

    @RequestMapping("/export")

    public void export(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException, IllegalAccessException {//String fileName,HttpServletRequest request,HttpServletResponse response
        System.out.println("下载的文件名: "+fileName);//E:\gitprojects\zayl_zhouqx\src\main\webapp\excel
        System.out.println(User.class);
        System.out.println(userService.selectAll());
        PoiUtil.exportExcel(User.class, userService.selectAll(),"E:\\gitprojects\\zayl_zhouqx\\src\\main\\webapp\\excel\\MyExcel.xls");
        //获取下载目录
        String realPath = request.getSession().getServletContext().getRealPath("/excel");
        //文件输入流 读取指定文件
        FileInputStream fis = new FileInputStream(new File(realPath, fileName));
        //响应类型 响应头
        response.setContentType(
                request.getSession().getServletContext().getMimeType(
                        "."+ getExtension(fileName)));
        //文件下载时为中文件名编码
        response.setHeader("content-disposition","attachment;fileName="+ URLEncoder.encode(fileName,"UTF-8"));

        //获取响应流
        ServletOutputStream os = response.getOutputStream();

        IOUtils.copy(fis, os);
        IOUtils.closeQuietly(fis);
        IOUtils.closeQuietly(os);

    }//F://MyExcel.xls

}
