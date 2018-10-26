package com.fintell.fp.service.impl;

import com.fintell.fp.service.OrderService;
import com.fintell.fp.vo.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 17:40 2018/10/25
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private MongoTemplate mongoTemplate;

/*    @Resource
    private OrderRepository orderRepository;*/

    @Override
    public Order getByOrderId(String orderId) {

        Query query = Query.query(Criteria.where("orderId").is(orderId));
        Order order = mongoTemplate.findOne(query, Order.class);
        return order;
        //return orderRepository.getByOrderId(orderId);
    }


    @Override
    public void saveOrder(Order order) {
        mongoTemplate.save(order);
        //orderRepository.save(order);

    }


    @Override
    public void removeOrderByOrderId(String orderNo) {
        Query q=new Query(new Criteria("orderId").is(orderNo));
        mongoTemplate.remove(q,Order.class);
    }

    @Override
    public void updateOrder(Order order) {
        Query q = new Query(new Criteria("orderId").is(order.getOrderId()));
        Update update=new Update().set("orderId", order.getOrderId());
        mongoTemplate.updateMulti(q, update, Order.class);
    }
}
