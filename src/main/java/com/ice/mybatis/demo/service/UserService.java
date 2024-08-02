package com.ice.mybatis.demo.service;

import com.ice.mybatis.demo.pojo.SysTable;
import com.ice.mybatis.demo.pojo.User;

import java.util.List;

/**
 * @ClassName: UserService
 * @Description:
 * @Author: ice
 * @Date: 2021/6/9 15:30
 */
public interface UserService {

    User findById(Long userId);

    User findAnnotateById(Long userId);

    List<SysTable> findAll();
}
