package com.baizhi.back.controller;

import com.baizhi.back.service.ManagerService;
import com.baizhi.common.entity.Count;
import com.baizhi.common.entity.Manager;
import com.baizhi.common.entity.Result;
import com.baizhi.common.util.VerifyCodeUtil;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Resource
    private ManagerService managerService;
    @RequestMapping("/login")
    @ResponseBody
    public Result login(Manager manager, HttpSession session,String code){
        Result result =new Result();
        String sessionCode =(String) session.getAttribute("code");
        System.out.println("sessionCode:"+sessionCode);
        System.out.println("code:"+code);
        //比较验证验证码
        if (sessionCode.equalsIgnoreCase(code)){
            Manager managerDB = managerService.login(manager);
            System.out.println("manager"+managerDB);
            if(managerDB!=null){
                session.setAttribute("manager",manager);
                result.setSuccess(true);
                result.setMsg("登录成功...");
            }else{
                result.setSuccess(false);
                result.setMsg("管理员不存在");
            }

        }
        return result;

    }

    /**
     * 生成验证码的方法
     */
    @RequestMapping("/getImage")
    public void getImage(HttpSession session, HttpServletResponse response) throws IOException {

        //生成验证码
        String code = VerifyCodeUtil.generateVerifyCode(4);
        //放入session中
        session.setAttribute("code", code);
        //生成验证码图片
        BufferedImage image = VerifyCodeUtil.getImage(120, 40, code);
        //响应图片到页面
        //设置响应类型
        response.setContentType("image/png");
        ServletOutputStream os = response.getOutputStream();
        //输出图片
        ImageIO.write(image, "png", os);

        //关闭流
        IOUtils.closeQuietly(os);
    }
    @ResponseBody
    @RequestMapping("/queryClassifyCount")
    public List<Count> queryClassifyCount(){
        List<Count> counts = managerService.queryClassifyCount();
        return counts;
    }
    }
