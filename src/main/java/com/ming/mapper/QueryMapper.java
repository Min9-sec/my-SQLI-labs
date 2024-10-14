package com.ming.mapper;

import com.ming.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 持久层，写数据存储
 */
@Mapper
public interface QueryMapper {
    // 数字型开始
    @Select("select * from users where id = ${id}")
    User selectByIdNum(String id);

    @Select("select * from users where id = (${id})")
    User selectByIdNumPro(String id);

    @Select("select * from users where id = ((${id}))")
    User selectByIdNumProPro(String id);

    // 数字型结束

    // 字符型开始
    @Select("select * from users where id = '${id}'")
    User selectByIdStr(String id);

    @Select("select * from users where id = \"${id}\"")
    User selectByidStrS(String id);

    @Select("select * from users where id = ('${id}')")
    User selectByIdStrPro1(String id);


    @Select("select * from users where id = (\"${id}\")")
    User selectByIdStrPro2(String id);

    // 字符型结束
    // 实战mybatis常见注入
    @Select("select * from users order by ${sort} asc")     // 安全写法，不直接拼接上sql语句，在服务层接收指定的排序方式即可
    List<User> selectListSort(String sort);

    // 实战mybatis 模糊查询注入

    // 安全SQL语句写法 @Select("select * from users where username like concat('%',#{name},'%')")
    @Select("select * from users where username like '%${name}%'")
    List<User> searchByName(String name);

    @Select("select * from users where id in (${ids})")
    List<User> searchByIds(String ids);
}
