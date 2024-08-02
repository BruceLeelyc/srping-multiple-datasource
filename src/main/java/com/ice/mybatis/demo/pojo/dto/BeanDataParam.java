package com.ice.mybatis.demo.pojo.dto;

import lombok.Data;

/**
 * @ClassName: DomainBeanDataStream
 * @Description:
 * @Author: ice
 * @Date: 2021/6/12 15:42
 */
@Data
public class BeanDataParam {

    private String flag;

    private BaseBean param;

    private int expire;
}
