package cn.xiaoyu.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtils {
    private Logger logger = LoggerFactory.getLogger(RedisUtils.class);

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set key and value to redis
     */
    public boolean set(String key, String value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        return true;
    }

    /**
     * set key and value to redis
     */
    public boolean set(String key, long seconds, String value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
        expire(key, seconds);
        return true;
    }

    /**
     * 更新指定key的value，剩余过期时间不变
     */
    public boolean update(String key, String value) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        //获取当前key的过期时间
        Long expireTime = redisTemplate.getExpire(key);
        //重新设置设置过期时间
        if (expireTime == null)
            return false;
        if (expireTime == -2 || expireTime == 0)
            return false;
        vo.set(key, value);
        if (expireTime > 0)
            expire(key, expireTime);
        return true;
    }

    /**
     * 获取剩余过期时间
     */
    public Long getExpire(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        //获取当前key的过期时间
        return redisTemplate.getExpire(key);
    }

    /**
     * 判断某个key是否存在
     */
    public boolean exist(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        Object value = vo.get(key);
        return !EmptyUtils.isEmpty(value);
    }

    public Object get(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        ValueOperations<String, Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

    public void delete(String key) {
        try {
            redisTemplate.setKeySerializer(new StringRedisSerializer());
            //设置序列化Value的实例化对象
            redisTemplate.setValueSerializer(new StringRedisSerializer());
            redisTemplate.delete(key);
        } catch (Exception e) {
            logger.error("Redis delete Fail", e);
        }
    }

    public Boolean setnx(final String key, final String value) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            boolean flag = false;
            try {
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                //设置序列化Value的实例化对象
                redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
                StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
                byte[] keys = stringRedisSerializer.serialize(key);
                byte[] values = stringRedisSerializer.serialize(value);
                flag = redisConnection.setNX(keys, values);
            } catch (Exception e) {
                logger.error("Redis setnx Fail", e);
            }
            return flag;
        });
    }

    public Boolean expire(final String key, final long expireTime) {
        return redisTemplate.execute((RedisCallback<Boolean>) redisConnection -> {
            try {
                redisTemplate.setKeySerializer(new StringRedisSerializer());
                //设置序列化Value的实例化对象
                redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
                StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
                byte[] keys = stringRedisSerializer.serialize(key);
                return redisConnection.expire(keys, expireTime);
            } catch (Exception e) {
                logger.error("Redis expire Fail", e);
            }
            return false;
        });
    }

    public boolean lock(String key) {
        boolean flag = false;
        try {
            String lockKey = generateLockKey(key);
            flag = setnx(lockKey, "lock");
            if (flag) {
                Boolean expire = expire(lockKey, Constants.Redis_Expire.DEFAULT_EXPIRE);
                logger.info("key expired {}", expire);
            }
            return flag;
        } catch (Exception e) {
            logger.error("Redis lock fail", e);
        }
        return flag;
    }

    public Object getValueNx(String key) {
        String lockKey = generateLockKey(key);
        return get(lockKey);
    }

    public void unlock(String key) {
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        //设置序列化Value的实例化对象
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        String lockKey = generateLockKey(key);
        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.del(lockKey.getBytes());
        connection.close();
    }

    private String generateLockKey(String key) {
        return String.format("LOCK:%s", key);
    }

    public boolean validate(String token) {
        return exist(token);
    }
}
