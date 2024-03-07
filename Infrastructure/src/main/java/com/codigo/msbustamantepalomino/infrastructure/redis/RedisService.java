package com.codigo.msbustamantepalomino.infrastructure.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {
    private final StringRedisTemplate stringRedisTemplate;


    //We now create a method to save values
    public void saveInRedis(String key,String value, int expirationTime)
    {
        stringRedisTemplate.opsForValue().set(key,value);
        stringRedisTemplate.expire(key,expirationTime, TimeUnit.MINUTES);
    }

    //We now create a method to return values
    public String getFromRedis(String key)
    {
        return stringRedisTemplate.opsForValue().get(key);
    }


    //When we want to delete a value in redis by searched key
    public void deleteKey(String key)
    {
        stringRedisTemplate.delete(key);
    }

    //Example
    //When we generate a dynamic key, so the service generate a dynamic key for 2 minutes
}
