package org.attestation_final.config;

import org.attestation_final.model.DTO.response.EmployeeResponseDTO;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;

@Configuration
@EnableRedisRepositories
public class RedisCacheConfig {

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory()
//    {
//        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//
//        // redis server properties we write here if we are in same machine than there is no need to write properties
//
//        // jedisConnectionFactory.setHostName("localhost");
//        // jedisConnectionFactory.setPort(6379);
//
//        return jedisConnectionFactory;
//    }
//
//    @Bean
//    public RedisTemplate<String, EmployeeResponseDTO> redisTemplate()
//    {
//        RedisTemplate<String, EmployeeResponseDTO> redisTemplate=new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("employee-data",
                        RedisCacheConfiguration
                                .defaultCacheConfig()
                                .entryTtl(Duration.ofMinutes(20)));
    }

}
