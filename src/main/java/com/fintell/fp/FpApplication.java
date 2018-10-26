package com.fintell.fp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author chen
 */
@EnableWebMvc
@SpringBootApplication(exclude = {RedisAutoConfiguration.class, /*DataSourceAutoConfiguration.class*/})
@MapperScan("com.fintell.fp.mapper")
public class FpApplication implements CommandLineRunner {

    @Override
    public void run(String[] args){
        // TODO
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(FpApplication.class, args);
    }
}
