package com.dianwoyin.price.respository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dianwoyin.price.BusinessException;
import com.dianwoyin.price.constants.enums.ErrorCodeEnum;
import com.dianwoyin.price.constants.enums.OrderStatusEnum;
import com.dianwoyin.price.mapper.SuperOrderMapper;
import com.dianwoyin.price.model.SuperOrder;
import com.dianwoyin.price.vo.response.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author chunxu.dong
 * @date 2021/6/24
 */
@Repository
public class SuperOrderRepository {

    @Autowired
    private SuperOrderMapper superOrderMapper;

    public Boolean deleteOrder(Integer orderId, Integer operator) {

        SuperOrder superOrder = queryOrderById(orderId);

        if (superOrder == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "订单不存在");
        }
        if (!superOrder.getCreatedId().equals(operator)) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "禁止操作");
        }

        superOrder.setDeleted(true);
        superOrderMapper.updateById(superOrder);
        return true;
    }

    private SuperOrder queryOrderById(Integer orderId) {
        QueryWrapper<SuperOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id", orderId)
                .eq("deleted", 0);
        return superOrderMapper.selectOne(queryWrapper);
    }

    public Boolean confirmReceipt(Integer orderId, Integer operator) {
        SuperOrder superOrder = queryOrderById(orderId);

        if (superOrder == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "订单不存在");
        }
        if (!superOrder.getCreatedId().equals(operator)) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "禁止操作");
        }

        superOrder.setStatus(OrderStatusEnum.Finished.getCode());
        superOrderMapper.updateById(superOrder);
        return true;
    }


    public SuperOrder getOrderById(Integer orderId, Integer operator) {
        SuperOrder superOrder = queryOrderById(orderId);
        if (superOrder == null) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "订单不存在");
        }
        if (!superOrder.getCreatedId().equals(operator)) {
            throw new BusinessException(ErrorCodeEnum.ERROR_COMMON_PARAM.getCode(), "禁止操作");
        }
        return superOrder;
    }

    public PageResult<SuperOrder> getOrderList(Integer userId, Integer orderStatus, Integer page, Integer pageSize) {
        Page<Object> pageTotal = PageHelper.startPage(page, pageSize);

        QueryWrapper<SuperOrder> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("created_id", userId)
                .eq("deleted", 0)
                .orderByDesc("created_time");

        if (orderStatus != null) {
            queryWrapper.eq("status", orderStatus);
        }
        List<SuperOrder> superOrders = superOrderMapper.selectList(queryWrapper);

        return PageResult.of(superOrders, page, pageSize, pageTotal.getTotal());
    }
}
