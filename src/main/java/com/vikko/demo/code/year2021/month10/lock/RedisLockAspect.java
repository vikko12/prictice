package com.vikko.demo.code.year2021.month10.lock;

import java.util.UUID;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


import lombok.extern.slf4j.Slf4j;

/**
 * @Desc : 分布式锁切面拦截，方法上加上@RedisLock即可
 * @author : Chenweixian 陈惟鲜
 * @Date : 2018年5月7日 下午7:47:56
 */
@Slf4j
@Aspect
@Component
@Order(7) // @Order(1)数字越小优先级越高
public class RedisLockAspect {
    
    /**拦截所有controller包下的方法*/
    @Pointcut("@annotation(com.vikko.demo.code.year2021.month10.lock.RedisLock)")
    private void lockMethod(){
    }
    
    /** 
     *  日志打印
     * @author : 陈惟鲜 chenweixian
     * @Date : 2018年8月8日 下午5:29:47
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("lockMethod() && @annotation(redisLock)")  
    public Object doAround(ProceedingJoinPoint point, RedisLock redisLock) throws Throwable {
        String class_name = point.getTarget().getClass().getName();
        String method_name = point.getSignature().getName();
        String threadUUID = UUID.randomUUID().toString();
        String redisKey = class_name + "." + method_name;
        Object result = null;
        try {
            RedisLockUtil.lock(redisKey, threadUUID);
                log.info("lock aop rediskey ："+redisKey);
                result = point.proceed();// result的值就是被拦截方法的返回值  
        } finally {
            RedisLockUtil.unlock(redisKey, threadUUID);
            log.info("unlock aop rediskey ："+redisKey);
        }
        return result;
    }
}