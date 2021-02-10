package com.vikko.demo.code.year2021.month2.schedule;

import java.util.Map;

/**
 * @author: vikko
 * @Date: 2021/1/30 16:43
 * @Description:
 */
public interface TestService {

	String generateSign(Map<String, Object> params, String appSecret,
			String signMethod);

}
