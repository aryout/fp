package com.fintell.fp.service;

import com.fintell.fp.vo.Order;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 17:40 2018/10/25
 **/
public interface OrderService {
    public Order getByOrderId(String orderNo);
    public void saveOrder(Order order);
    public void removeOrderByOrderId(String orderNo);
    public void updateOrder(Order order);
}
