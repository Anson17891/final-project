
package com.bootcamp.project_stock_data.codeLib;

import java.time.Duration;
import java.util.List;

import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;

import tools.jackson.databind.ObjectMapper;
@Component
public class RedisManager {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisManager(RedisConnectionFactory factory, ObjectMapper objectMapper){
        RedisTemplate<String,String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
  this.redisTemplate = redisTemplate;
  this.objectMapper = objectMapper;
  }

  public <T> T get(String key, Class<T> clazz){
    String json = this.redisTemplate.opsForValue().get(key);
    if(json == null){
      return null;
    }
    else{
      return this.objectMapper.readValue(json, clazz);
    }
  }

  public <T> List<T> getList(String key, Class<T> clazz) {  //!ai : prevent quoteController.getQuotes return wrong type .of list
    String json = this.redisTemplate.opsForValue().get(key);
    if (json == null) {
        return null;
    }
    try {
        return this.objectMapper.readValue(
            json, this.objectMapper.getTypeFactory().constructCollectionType(List.class, clazz)  //!constructCollectionType(List.class, clazz) -> List<clazz>
        );
    } catch (Exception e) {
        throw new RuntimeException("Redis deserialization failed", e);
    }
}


  public <T> void set(String key, T value, Duration duration){
    String json = this.objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, json, duration);
  }

  public <T> void setByHash(String key, String hashKey, T value, Duration duration){
    try{
    String json = this.objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForHash().put(key, hashKey, json);
    this.redisTemplate.expire(key, duration);
    }catch (Exception e){
      throw new RuntimeException("Redis serialization failed", e);
    }
  }

  public <T> T getByHash(String key, String hashKey, Class<T> clazz){
    Object json = this.redisTemplate.opsForHash().get(key, hashKey);
    if(json == null){
      return null;
    }
    try {
        return this.objectMapper.readValue(json.toString(), clazz);
    } catch (Exception e) {
      throw new RuntimeException("Redis deserialization failed" ,e);
    }
  }

}
