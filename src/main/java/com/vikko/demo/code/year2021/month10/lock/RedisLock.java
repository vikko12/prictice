package com.vikko.demo.code.year2021.month10.lock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Desc : redisLock注解标签，使用该标签后，并且在app中配置RedisLockAop后，项目将实现注解分布式锁,
 * key为当前类+方法名
 * @author : Chenweixian 陈惟鲜
 * @Date : 2018年5月7日 下午7:44:56
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RedisLock {
    
}