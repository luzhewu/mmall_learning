package com.mmall.service;

import com.github.pagehelper.PageInfo;
import com.mmall.common.ServerResponse;
import com.mmall.pojo.Shipping;

/**
 * Created by My_coder on 2017-07-30.
 */
public interface IShippingService {

    /**
     * 增加地址
     */
    ServerResponse add(Integer userId, Shipping shipping);
    /**
     * 删除地址
     */
    ServerResponse del(Integer userId, Integer shippingId);

    /**
     * 修改地址
     */
    ServerResponse update(Integer userId, Shipping shipping);

    /**
     * 查询指定地址
     */
    ServerResponse<Shipping> select(Integer userId, Integer shippingId);

    /**
     * 查询该用户下所有地址
     */
    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);
}
