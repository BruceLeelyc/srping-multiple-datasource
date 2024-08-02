package com.ice.mybatis.demo.dao.sys;

import com.ice.mybatis.demo.pojo.SysTable;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SysMapper {

    @Select("select * from sys_config")
    List<SysTable> findAll();
}
