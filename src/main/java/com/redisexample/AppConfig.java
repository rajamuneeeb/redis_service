package com.redisexample;

import com.redisexample.entity.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;


@Configuration
@EnableRedisRepositories
public class AppConfig {

    @Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Employee> employeeRedisTemplate() {
        RedisTemplate<String, Employee> employeeRedisTemplate = new RedisTemplate<>();
        employeeRedisTemplate.setConnectionFactory(redisConnectionFactory());
        return employeeRedisTemplate;
    }
}
