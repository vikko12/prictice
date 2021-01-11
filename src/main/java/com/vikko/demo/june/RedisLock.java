//package com.vikko.demo.june;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.TimeUnit;
//import org.springframework.data.redis.connection.RedisStringCommands.SetOption;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.script.DefaultRedisScript;
//import org.springframework.data.redis.core.types.Expiration;
///**
// * @author vikko
// * @date 2020/6/5 15:48
// */
//public class MutexLocker implements AutoCloseable {
//    private static final long EXPIRE = 86400000L;
//    private static final String LOCK_SUCCESS = "OK";
//    private static final String SET_IF_NOT_EXIST = "NX";
//    private static final String SET_WITH_EXPIRE_TIME = "PX";
//    private RedisTemplate redisTemplate;
//    private String key;
//    private ThreadLocal<String> lockFlag = new ThreadLocal();
//    public static final DefaultRedisScript<Long> releaseScript = new DefaultRedisScript();
//
//    public MutexLocker() {
//    }
//
//    public boolean acquire() {
//        return (Boolean)this.redisTemplate.execute((connection) -> {
//            String uuid = UUID.randomUUID().toString();
//            this.lockFlag.set(uuid);
//            byte[] keyBytes = this.redisTemplate.getKeySerializer().serialize(this.key);
//            byte[] valueBytes = this.redisTemplate.getValueSerializer().serialize(uuid);
//            Expiration expiration = Expiration.from(86400000L, TimeUnit.SECONDS);
//            return connection.set(keyBytes, valueBytes, expiration, SetOption.SET_IF_ABSENT);
//        });
//    }
//
//    public boolean release() {
//        List<String> keys = new ArrayList();
//        keys.add(this.key);
//        String args = (String)this.lockFlag.get();
//        this.lockFlag.remove();
//        Long result = (Long)this.redisTemplate.execute(releaseScript, keys, new Object[]{args});
//        return result != null && result > 0L;
//    }
//
//    public void close() {
//        this.release();
//    }
//
//    static {
//        releaseScript.setResultType(Long.class);
//        StringBuilder sb = new StringBuilder();
//        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
//        sb.append("then ");
//        sb.append("    return redis.call(\"del\",KEYS[1]) ");
//        sb.append("else ");
//        sb.append("    return 0 ");
//        sb.append("end ");
//        releaseScript.setScriptText(sb.toString());
//    }
//
//    public static final class MutexLockerBuilder {
//        private RedisTemplate redisTemplate;
//        private String key;
//
//        private MutexLockerBuilder() {
//        }
//
//        public static MutexLocker.MutexLockerBuilder aMutexLocker() {
//            return new MutexLocker.MutexLockerBuilder();
//        }
//
//        public MutexLocker.MutexLockerBuilder withRedisTemplate(RedisTemplate stringRedisTemplate) {
//            this.redisTemplate = stringRedisTemplate;
//            return this;
//        }
//
//        public MutexLocker.MutexLockerBuilder withKey(String key) {
//            this.key = key;
//            return this;
//        }
//
//        public MutexLocker build() {
//            MutexLocker mutexLocker = new MutexLocker();
//            mutexLocker.key = this.key;
//            mutexLocker.redisTemplate = this.redisTemplate;
//            return mutexLocker;
//        }
//    }
//}
