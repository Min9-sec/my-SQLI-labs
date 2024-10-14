package com.ming.contorller;


import com.ming.bean.Result;
import com.ming.bean.User;
import com.ming.service.Impl.QueryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@ResponseBody
@RestController
@Slf4j
@RequestMapping("/union")

public class unionController {
    @Autowired
    private QueryServiceImpl queryService;


    // 数字型注入-1
    @RequestMapping("/sqli-1")
    public Result number1(String id){
        log.info("常规SQL联合数字型注入-1，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNum(id);
        return Result.success(user);
    }

    // 数字型注入-2
    @RequestMapping("/sqli-2")
    public Result number2(String id){
        log.info("常规SQL联合数字型注入-2，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNumPro(id);
        return Result.success(user);
    }
    // 数字型注入-3
    @RequestMapping("/sqli-3")
    public Result number3(String id){
        log.info("常规SQL联合数字型注入-3，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNumProPro(id);
        return Result.success(user);
    }



    // 字符型注入-1
    @RequestMapping("sqli-4")
    public Result string1(String id){
        log.info("常规SQL联合字符型注入-1，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdStr(id);
        return Result.success(user);
    }
    // todo 字符型 单双引号各一个，单双引号互相配合，单双引号括号配合 2 * 2 * 2 ，'',""  "''",'""'  (''),("")

    // 字符型注入-2
    @RequestMapping("sqli-5")
    public Result string2(String id){
        log.info("常规SQL联合字符型注入-5，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdStrS(id);
        return Result.success(user);
    }

    // 字符型注入-3
    @RequestMapping("sqli-6")
    public Result string3(String id){
        log.info("常规SQL联合字符型注入-6，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByidStrPro1(id);
        return Result.success(user);
    }
    // 字符型注入-4
    @RequestMapping("sqli-7")
    public Result string4(String id){
        log.info("常规SQL联合字符型注入-7，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByidStrPro2(id);
        return Result.success(user);
    }
}
