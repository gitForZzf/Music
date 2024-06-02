package com.zzf.music.gateway.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundSetOperations;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

@SuppressWarnings(value = {"unchecked", "rawtypes"})
@Component
public class RedisCache {

    @Resource
    public RedisTemplate redisTemplate;

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key   缓存的键值
     * @param value 缓存的值
     * @param <T>   缓存的对象
     */
    public <T> void setCacheObject(final String key, final T value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 缓存基本的对象，Integer、String、实体类等
     *
     * @param key      缓存的键值
     * @param value    缓存的值
     * @param time     缓存的过期时间
     * @param timeUnit 缓存的过期时间单位
     * @param <T>      缓存的对象
     */
    public <T> void setCacheObject(final String key, final T value, final Integer time, final TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, time, timeUnit);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key     缓存的键值
     * @param timeout 缓存的过期时间
     * @param unit    缓存的过期时间单位
     * @return 缓存的对象
     */
    public boolean expire(final String key, final long timeout, final TimeUnit unit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, unit));
    }

    public boolean expire(final String key, final long timeout) {
        return expire(key, timeout, TimeUnit.SECONDS);
    }

    /**
     * 获得缓存的基本对象。
     *
     * @param key 缓存的键值
     * @param <T> 缓存的对象
     * @return 缓存的对象
     */
    public <T> T getCacheObject(final String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }


    public boolean deleteObject(final String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * 删除集合缓存
     *
     * @param collection 缓存集合
     * @return 删除数量
     */
    public long deleteObject(final Collection collection) {
        return redisTemplate.delete(collection);
    }

    /**
     * 缓存List数据
     *
     * @param key      缓存key
     * @param dataList 缓存List数据
     * @param <T>      缓存对象
     * @return 缓存数量
     */
    public <T> long setCacheList(final String key, final List<T> dataList) {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * 获得缓存的list对象
     * @param key 缓存key
     * @return 缓存list对象
     * @param <T> 缓存对象
     */
    public <T> List<T> getCacheList(final String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * 缓存set
     * @param key 缓存key
     * @param dataSet 缓存的数据
     * @return 缓存数量
     * @param <T> 缓存对象
     */
    public <T> BoundSetOperations<String, T> setCacheSet(final String key, final Set<T> dataSet) {
       BoundSetOperations<String, T> setOperations = redisTemplate.boundSetOps(key);
        for (T t : dataSet) {
            setOperations.add(t);
        }
       return setOperations;
    }

    /**
     * 获得缓存的set
     * @param key 缓存key
     * @return 缓存的数据
     * @param <T> 缓存对象
     */
    public <T> Set<T> getCacheSet(final String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     *  缓存Map
     * @param key 缓存key
     * @param dataMap 缓存的数据
     * @param <T> 缓存对象
     */
    public <T> void setCacheMap(final String key, final Map<String, T> dataMap) {
        if (dataMap != null) {
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * 获得缓存的Map
     * @param key 缓存key
     * @return 缓存的数据
     * @param <T> 缓存对象
     */
    public <T> Map<String, T> getCacheMap(final String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 对hash表中的字段进行增操作
     * @param key 缓存key
     * @param hkey 缓存hkey
     * @param value 缓存值
     * @param <T> 缓存对象
     */
    public <T> void setCacheMapValue(final String key, final String hkey,final T value) {
        redisTemplate.opsForHash().put(key, hkey, value);
    }

    /**
     * 获得缓存Hash中的hkey对应的value
     * @param key 缓存key
     * @param hkey 缓存hkey
     * @return 缓存对象
     * @param <T> 缓存对象
     */
    public <T> T getCacheMapValue(final String key, final String hkey) {
        return (T) redisTemplate.opsForHash().get(key, hkey);
    }

    /**
     * 删除hash表中的字段
     * @param key 缓存key
     * @param hkey 缓存hkey
     */
    public void deleteCacheMapValue(final String key, final String hkey) {
        redisTemplate.opsForHash().delete(key, hkey);
    }

    /**
     * 获得缓存Map中的所有数据
     * @param key 缓存key
     * @param hkeys 缓存hkey
     * @return 缓存对象
     * @param <T> 缓存对象
     */
    public <T> List<T> getMultiCacheMapValue(final String key, final Collection<Object> hkeys) {
        return redisTemplate.opsForHash().multiGet(key, hkeys);
    }

    /**
     * 获得缓存Map中的所有数据
     * @param pattern 查询内容
     * @return 缓存对象
     */
    public Collection<String> keys(final String pattern) {
        return redisTemplate.keys(pattern);
    }


}
