package com.ming.service;

import com.ming.bean.User;

import java.util.List;

public interface QueryService {
    /**
     * 查询所有数据，不需要参数
     * @return  Users表所有数据
     */
    List<User> selectList();

    /**
     * 通过ID查询对应用户
     * @param id
     * @return  id对应用户对象
     */
    User selectByIdNum(String id);


    /**
     * 通过ID查询对应用户 一个pro表示括号一对
     * @param id
     * @return  id对应用户对象
     */
    User selectByIdNumPro(String id);

    /**
     * 通过ID查询对应用户 一个pro表示括号一对
     * @param id
     * @return  id对应用户对象
     */
    User selectByIdNumProPro(String id);

    /**
     * 通过ID查询对应用户   单引号闭合
     * @param id
     * @return id对应用户对象
     */
     User selectByIdStr(String id);

    /**
     * 双引号闭合
     * @param id
     * @return
     */
     User selectByIdStrS(String id);

    /**
     * ('{id}')闭合方式
     * @param id
     * @return
     */
     User selectByidStrPro1(String id);

    /**
     * ("${id}")闭合方式
     * @param id
     * @return
     */
    User selectByidStrPro2(String id);

    /**
     * 实战order by注入
     */
    List<User> selectListSort(String sort);

    /**
     * 模糊查询
     * @param name  用户名
     * @return
     */
    List<User> searchByName(String name);


    List<User> searchByIds(String ids);
}
