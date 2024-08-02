package com.ice.mybatis.demo.dao.user;

import com.ice.mybatis.demo.pojo.User;

/**
 * @ClassName: UserDao
 * @Description:
 * @Author: ice
 * @Date: 2021/6/9 15:43
 */
public interface UserDao {

    User findById(Long userId);

    Integer deleteByPrimaryKey(Long userId);

    Integer insert(User user);

    Integer update(User user);

}
