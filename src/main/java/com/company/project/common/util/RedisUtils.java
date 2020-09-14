package com.company.project.common.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author Ray。
 * @version 1.0
 * @date 2020/6/29 15:04
 */
@Component
public class RedisUtils {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 删除key
     * @return 成功返回true 失败返回false
     */
    public Boolean delete(String key) {
        if (null==key){
            return false;
        }
        return redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     * @return 返回成功删除key的数量
     */
    public Long delete(Collection<String> keys) {
        return redisTemplate.delete(keys);
    }

    /**
     * 是否存在key
     * @return
     */
    public Boolean hasKey(String key) {
        if (null==key){
            return false;
        }
        return redisTemplate.hasKey(key);
    }

    /**
     * 设置过期时间
     * @return
     */
    public Boolean expire(String key, long timeout, TimeUnit unit) {
        if (null==key||null==unit){
            return false;
        }
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 查找匹配的key
     * @return
     */
    public Set<String> keys(String pattern) {
        if (null==pattern){
            return null;
        }
        return redisTemplate.keys(pattern);
    }

    /**
     * 移除 key 的过期时间，key 将持久保持
     * @return
     */
    public Boolean persist(String key) {
        if (null==key){
            return false;
        }
        return redisTemplate.persist(key);
    }

    /**
     * 返回 key 的剩余的过期时间
     * @return 当 key 不存在时，返回 -2 。当 key 存在但没有设置剩余生存时间时，返回 -1 。否则，以秒为单位，返回 key的剩余生存时间
     */
    public Long getExpire(String key, TimeUnit unit) {
        if(null==key||null==unit){
            throw new RuntimeException("key or TomeUnit 不能为空");
        }
        return redisTemplate.getExpire(key, unit);
    }

    /**
     * 设置指定 key 的值
     * @return
     */
    public void set(String key, Object value) {

        if(null==key||null==value){
            return;
        }
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置key 的值 并设置过期时间
     * @return
     */
    public void set(String key,Object value,long time,TimeUnit unit){
        if(null==key||null==value||null==unit){
            return;
        }
        if(time<0){
            redisTemplate.opsForValue().set(key,value);
        }else {
            redisTemplate.opsForValue().set(key,value,time,unit);
        }

    }

    /**
     * 获取指定Key的Value。如果与该Key关联的Value不是string类型，Redis将抛出异常，
     * 因为GET命令只能用于获取string Value，如果该Key不存在，返回null
     * @return
     */
    public Object get(String key){
        if(null==key){
            return null;
        }
        return  redisTemplate.opsForValue().get(key);
    }

    /**
     * 很明显先get再set就说先获取key值对应的value然后再set 新的value 值。
     * @return
     */
    public Object getSet(String key,Object value){
        if(null==key){
            return null;
        }
        return redisTemplate.opsForValue().getAndSet(key,value);
    }

}

