package com.fintell.fp;

import com.fintell.fp.mapper.UserMapper;
import com.fintell.fp.vo.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import javax.sql.DataSource;
import java.util.Objects;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author chen dao peng
 * @program fp
 * @description
 * @date 15:45 2018/10/24
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigApplicationTests {

    @Autowired
    DataSourceProperties dataSourceProperties;

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    DataSource druidDataSource;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    MongoTemplate mongoTemplate;


    @Autowired
    JedisConnectionFactory jedisConnectionFactory;

    @Autowired
    UserMapper userMapper;

    @Test
    public void isDruidConfigWork(){
        System.out.println(druidDataSource);
        System.out.println(druidDataSource.getClass().getName());
        System.out.println(dataSourceProperties);

    }

    @Test
    public void isJedisConfigWork(){
        System.out.println(redisTemplate.getKeySerializer());
        System.out.println(jedisConnectionFactory.getHostName());
        System.out.println(jedisConnectionFactory.getDatabase());
        System.out.println(jedisConnectionFactory.getPassword());
        System.out.println(jedisConnectionFactory.getClientName());

        // 新支持 不响应配置
        System.out.println(Objects.requireNonNull(jedisConnectionFactory.getPoolConfig()).getMaxIdle()); // 8
        System.out.println(jedisConnectionFactory.getPoolConfig().getMaxTotal()); // 8
        System.out.println(jedisConnectionFactory.getPoolConfig().getMinIdle()); // 0
        System.out.println(jedisConnectionFactory.getClientConfiguration().getConnectTimeout()); // PT2S
        System.out.println(Objects.requireNonNull(jedisConnectionFactory.getStandaloneConfiguration()).getPassword()); // RedisPassword[<none>]
        System.out.println(jedisConnectionFactory.getTimeout()); // 2000
        System.out.println(jedisConnectionFactory.getConnection());
    }



    @Test
    public void isMybatisConfigWork(){
        int a = userMapper.insertUser("test");
        assertEquals(a, 1);
        String b = userMapper.queryUserByName("test").getName();
        assertEquals(b, "test");
        userMapper.deleteUser("test");
    }


    @Test
    public void isMongoConfigWork(){
        Order order = new Order();
        order.setOrderId("X797468");

        mongoTemplate.save(order);

        Query query = Query.query(Criteria.where("orderId").is("X797468"));
        order = mongoTemplate.findOne(query, Order.class);

        if (order == null){
            System.out.println("null");
            assertNull(order);
        }
        assertEquals(order.getOrderId(), "X797468");
        mongoTemplate.remove(query, Order.class);
    }
}
