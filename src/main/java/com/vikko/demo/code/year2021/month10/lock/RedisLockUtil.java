package com.vikko.demo.code.year2021.month10.lock;

import com.vikko.demo.code.year2021.month10.inject.SpringContextUtil;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;

import lombok.extern.slf4j.Slf4j;

/**
 * @Desc : 分布式锁
 * @Company : 晨创科技
 * @author : Chenweixian 陈惟鲜
 * @Date : 2018年6月5日 下午2:41:03
 */
@Slf4j
public class RedisLockUtil {

    private static final Long RELEASE_SUCCESS = 1L;

    private static final StringRedisTemplate stringRedisTemplate = (StringRedisTemplate) SpringContextUtil
        .getBean("stringRedisTemplate");

    private static final DefaultRedisScript<Long> redisScript = (DefaultRedisScript<Long>) SpringContextUtil.getBean("redisScript");

    private static long timeout = 65 * 1000L; // 锁定65S
    /**
     * 上锁
     * @param key 锁标识
     * @param value 线程标识
     * @return 上锁状态
     */
    public static boolean lock(String key, String value, long mytimeout) {
        long start = System.currentTimeMillis();
        // 检测是否超时
        if (System.currentTimeMillis() - start > mytimeout) {
            return false;
        }
        // 执行set命令
        Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent(key, value, mytimeout, TimeUnit.MILLISECONDS);// 毫秒
        // 是否成功获取锁
        if (absent) {
            return true;
        }
        return false;
    }
    
    /**
     * 上锁
     * @param key 锁标识
     * @param value 线程标识
     * @return 上锁状态
     */
    public static boolean lock(String key, String value) {
        long start = System.currentTimeMillis();
        while (true) {
            // 检测是否超时
            if (System.currentTimeMillis() - start > timeout) {
                return false;
            }
            // 执行set命令
            Boolean absent = stringRedisTemplate.opsForValue().setIfAbsent(key, value, timeout, TimeUnit.MILLISECONDS);// 毫秒
            // 是否成功获取锁
            if (absent) {
                return true;
            }
            // 不能休眠
//            try {
//                Thread.sleep(5);// 等待50毫秒
//            } catch (InterruptedException e) {
//            }
        }
    }

    /**
     * 解锁
     *  @param key 锁标识
     * @param value 线程标识
     * @return 解锁状态
     */
    public static boolean unlock(String key, String value) {
        // 使用Lua脚本：先判断是否是自己设置的锁，再执行删除
        Long result = stringRedisTemplate.execute(redisScript, Arrays.asList(key, value));
        // 返回最终结果
        return RELEASE_SUCCESS.equals(result);
    }
}