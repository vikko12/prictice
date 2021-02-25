package com.vikko.demo.code.year2021.month2.limit;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SessionCallback;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2021/2/20 15:09
 * @Description:
 */
@Component
public class SimpleRateLimiter {
	@Autowired
	private RedisTemplate redisTemplate;


	@SuppressWarnings("unchecked")
	public boolean actionLimit(String userId, String actionKey, int period, int maxCount) {
		String key = String.format("limiter:%s:%s", userId, actionKey);
		long nowTs = System.currentTimeMillis();

		List<Object> result = (List<Object>) redisTemplate.execute(new SessionCallback<List<Object>>() {
			@Override
			public List<Object> execute(RedisOperations ops) throws DataAccessException {
				ops.multi();
				// 记录行为
				ops.opsForZSet().add(key, "" + nowTs, nowTs);
				// 移除窗口前的记录
				ops.opsForZSet().removeRangeByScore(key, 0, nowTs - period * 1000 * 60);
				// 获取窗口内行为数量
				ops.opsForZSet().zCard(key);
				// 设置过期时间等于窗口长度
				ops.expire(key, period, TimeUnit.MINUTES);
				return ops.exec();
			}
		});
		// 获取第三步返回的结果
		Long count = (Long) result.get(2);
		return count <= maxCount;
	}

}


