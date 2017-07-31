package com.mmall.service;

import com.mmall.common.ServerResponse;
import com.mmall.vo.CartVo;

/**
 * Created by My_coder on 2017-07-27.
 */
public interface ICartService {
    /**
     * 增加
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    /**
     * 修改
     * @param userId
     * @param productId
     * @param count
     * @return
     */
    ServerResponse<CartVo> update(Integer userId, Integer productId, Integer count);

    /**
     * 删除
     * @param userId
     * @param productIds
     * @return
     */
    ServerResponse<CartVo> deleteProduct(Integer userId, String productIds);

    /**
     * 查询购物车商品
     */
     ServerResponse<CartVo> list(Integer userId);

    /**
     * 全选或全反选或单选
     */
    ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId,Integer checked);

    /**
     * 获取选取的所有数量
     */
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
