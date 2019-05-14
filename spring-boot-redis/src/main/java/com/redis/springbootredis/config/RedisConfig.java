package com.redis.springbootredis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: GWL
 * @Description: redis配置
 * redisTemplate 序列化使用的jdkSerializeable, 存储二进制字节码, 所以自定义序列化类
 * 一般redis的序列化方式主要有：字符串序列化、json序列化、xml序列化、jdk序列化
 * 默认为 JdkSerializationRedisSerializer
 * @Date: Create in 14:43 2019/5/14
 */
@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisCollectionFactory) {
        RedisTemplate template = new RedisTemplate();
        template.setConnectionFactory(redisCollectionFactory);

        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        //解决查询缓存转换异常的问题
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        // 设置value的序列化规则
        //json序列化
        template.setValueSerializer(jackson2JsonRedisSerializer);
        //String序列化
//        template.setValueSerializer(new StringRedisSerializer());
        //jdk序列化
//        template.setValueSerializer(new JdkSerializationRedisSerializer());

        //设置key序列-String序列化
        template.setKeySerializer(new StringRedisSerializer());

        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();

        return template;
    }

}
