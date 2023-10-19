package com.safvan.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.safvan.model.Student;

@Configuration
public class AppConfig {

    // 1. Redis Connection Configuration
    /**
     * Create and configure a RedisConnectionFactory using Lettuce.
     * The RedisConnectionFactory manages the connection to the Redis server.
     *
     * @return A RedisConnectionFactory for connecting to Redis using Lettuce.
     */
    @Bean
    public RedisConnectionFactory cf() {
        return new LettuceConnectionFactory();
    }

    // 2. Redis Template Configuration

    /**
     * Create a RedisTemplate for working with Redis data, specifically for storing and
     * retrieving data associated with the Student model.
     *
     * This RedisTemplate provides a high-level API to interact with Redis. It allows
     * you to perform operations like storing, retrieving, updating, and deleting data
     * in the Redis data store. In this configuration, we specify that this RedisTemplate
     * will work with keys of type String and values of type Student.
     *
     * @return A RedisTemplate configured with a connection factory to interact with Redis.
     */
    @Bean
    public RedisTemplate<String, Student> rt() {
        RedisTemplate<String, Student> template = new RedisTemplate<>();
        
        // Set the connection factory so that this template knows how to connect to Redis.
        template.setConnectionFactory(cf());

        // With this RedisTemplate, you can perform operations like saving, retrieving,
        // updating, and deleting Student objects in the Redis data store. For example,
        // you can use template.opsForValue().set("student1", studentObject) to save a
        // Student object with a specific key "student1". Later, you can retrieve this
        // object using template.opsForValue().get("student1").
        // It simplifies interaction with Redis by providing a familiar data access pattern.
        
        return template;
    }
}
