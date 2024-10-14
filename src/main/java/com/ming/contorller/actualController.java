package com.ming.contorller;

import com.ming.bean.Result;
import com.ming.service.Impl.QueryServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@ResponseBody
@RestController
@Slf4j
@RequestMapping("/mybatis")
public class actualController {
    @Autowired
    private QueryServiceImpl queryService;


    // order by 注入
    @RequestMapping("/sqli-1")
    public Result bool(String sort){
        log.info("order by 注入，请求参数 ->  {}  <-",sort);
        if (sort == null || sort.isEmpty()){return Result.error("?sort=id，按id来排序，可选id,username,password，或者输入1,2,3");}
        List users = queryService.selectListSort(sort);
        return Result.success(users);
    }

    // 模糊 like 注入
    @RequestMapping("/sqli-2")
    public Result queryByName(String name){
        log.info("模糊查询 like 注入，请求参数 ->  {}  <-",name);
        if (name == null || name.isEmpty()){return Result.error("?name=a，输入用户名进行查询");}
        List users = queryService.searchByName(name);
        return Result.success(users);
    }

    // in 注入
    @RequestMapping("/sqli-3")
    public Result queryByIds(String ids){
        log.info("批量 in 注入，请求参数 ->  {}  <-",ids);
        if (ids == null || ids.isEmpty()){return Result.error("?isds=1,2,3，输入用户名进行查询");}
        List users = queryService.searchByIds(ids);
        return Result.success(users);
    }
}
