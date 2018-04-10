package com.baizhi.front.aspect;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/11/21.
 */
@Configuration
@Aspect
public class CacheAdvice {
    //添加缓存方法，为所有查询方法加上一个环绕通知
        //在service层进行只切查询方法的配置

    //@Around("execution(* com.baizhi.service.*.*(..))")切入点表达式
    //下面为注解的切入点表达式
    @Around("@annotation(com.baizhi.front.mybean.AddCache)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object proceed = null;
        //为相同类的整个方法配置map键
        String mapkey = proceedingJoinPoint.getTarget().getClass().getName();
        System.out.println(mapkey);
        ///获取目标方法的返回值类型
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        //获得file的key值
        String filekey=getFilekey(proceedingJoinPoint);
        //进行是否包含redis键（key）判断
            //注意用hash类型进行存储
        Jedis jedis = new Jedis("39.106.125.100", 6379);
        if(jedis.hexists(mapkey,filekey)){//存在
            //则从redis中取值
            String json = jedis.hget(mapkey, filekey);
            //对象类型的json转为对象，集合类型的json转为集合
            proceed = JSONObject.parseObject(json, signature.getReturnType());
        }else {//不存在
            proceed = proceedingJoinPoint.proceed();
            //存入redis中
            String json = JSONObject.toJSONStringWithDateFormat(proceed, "yyyy-MM-dd");
            jedis.hset(mapkey,filekey,json);
            proceed = JSONObject.parseObject(json,signature.getReturnType());
        }
        return proceed;
    }

    //获取file键的方法
    public String getFilekey(ProceedingJoinPoint proceedingJoinPoint){
        String filekey = proceedingJoinPoint.getSignature().toString();
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object arg : args) {
            filekey+=arg;
        }
        return DigestUtils.md5DigestAsHex(filekey.getBytes());
    }

    //删除缓存方法，为所有增删改方法加上一个后续通知
    @After("@annotation(com.baizhi.front.mybean.RemoveCache)")
    public void after(JoinPoint joinPoint){
        //业务层的整个map
        String mapkey = joinPoint.getTarget().getClass().getName();
        Jedis jedis = new Jedis("39.106.125.100", 6379);
        jedis.del(mapkey);
    }
}
