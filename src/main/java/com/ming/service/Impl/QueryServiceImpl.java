package com.ming.service.Impl;

import com.ming.bean.User;
import com.ming.mapper.QueryMapper;
import com.ming.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryServiceImpl implements QueryService {
    @Autowired
    private QueryMapper queryMapper;
    @Override
    public List<User> selectList() {
        return null;
    }

    @Override
    public User selectByIdNum(String id) {
        User user = queryMapper.selectByIdNum(id);
        return user;
    }

    @Override
    public User selectByIdNumProPro(String id) {
        User user = queryMapper.selectByIdNumProPro(id);
        return user;
    }


    @Override
    public User selectByIdNumPro(String id) {
        User user = queryMapper.selectByIdNumPro(id);
        return user;
    }

    @Override
    public User selectByIdStr(String id) {
        User user = queryMapper.selectByIdStr(id);
        return user;
    }

    @Override
    public User selectByIdStrS(String id) {
        User user = queryMapper.selectByidStrS(id);
        return user;
    }

    @Override
    public User selectByidStrPro1(String id) {
        User user = queryMapper.selectByIdStrPro1(id);
        return user;
    }

    @Override
    public User selectByidStrPro2(String id) {
        User user = queryMapper.selectByIdStrPro2(id);
        return user;
    }

    @Override
    public List<User> selectListSort(String sort) {
        List users = queryMapper.selectListSort(sort);
        return users;
    }

    @Override
    public List<User> searchByName(String name) {
        List users = queryMapper.searchByName(name);
        return users;
    }

    @Override
    public List<User> searchByIds(String ids) {
        return queryMapper.searchByIds(ids);
    }
}
