package com.ice.mybatis.demo.dao.user;

import com.ice.mybatis.demo.pojo.User;
import org.apache.ibatis.annotations.*;

/**
 * @ClassName: UserDao
 * @Description:
 * @Author: ice
 * @Date: 2021/6/9 15:43
 */
public interface UserMapper {

    @Select(" select * from sys_user where user_id = #{userId}")
    User findById(@Param("userId") Long userId);

    @Delete(" delete from sys_user where user_id = #{userId}")
    Integer deleteByPrimaryKey(@Param("userId") Long userId);

    @Insert("")
    Integer insert(User user);

    @Update("")
    Integer update(User user);

}
