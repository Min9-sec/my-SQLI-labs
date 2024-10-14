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
@RequestMapping("/blind")
public class blindController {
    @Autowired
    private QueryServiceImpl queryService;

    // 布尔盲注
    @RequestMapping("/sqli-1")
    public Result bool(String id){
        log.info("布尔SQL盲注-sqli-1，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNum(id);
        if (user == null){
            return Result.success("请检查输入，没有对应用户");
        }else {
            return Result.success("存在");
        }
    }

    // 时间盲注
    @RequestMapping("/sqli-2")
    public Result time(String id){
        log.info("时间SQL盲注-sqli-2，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNum(id);
        return Result.success();
    }

    // 报错盲注
    @RequestMapping("/sqli-3")
    public Result error(String id){
        log.info("报错SQL盲注-sqli-3，请求参数 ->  {}  <-",id);
        if (id == null || id.isEmpty()){return Result.error("id参数不能为空");}
        User user = queryService.selectByIdNum(id);
        return Result.success("data...");
    }
}
