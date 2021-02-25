package com.vikko.demo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.vikko.demo.code.year2021.month1.copy.test.TestService;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: vikko
 * @Date: 2021/1/30 15:23
 * @Description:
 */


@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
public class MeiTuanTest {

	String appSecret = "4e0d1be81540c4d1f0868d329b3229467f071f6c";

	@Autowired
	TestService testService;

	@Test
	public void test() {

		IntStream.rangeClosed(1, 10).boxed().forEach(data -> {
//			Map<String, Object> requestParam = new HashMap<>();
//			requestParam.put("app_key", "1000055");
//			requestParam.put("deviceId", UUID.randomUUID().toString().replace("-",""));
//			requestParam.put("longitude", "121.472644");
//			requestParam.put("latitude", "31.231706");
//			requestParam.put("timestamp", "2021-01-30 17:00:10");
//			requestParam.put("format", "json");
//			requestParam.put("v", "1");
//			requestParam.put("sign_method", "MD5");
//			requestParam.put("page", String.valueOf(data));
//			requestParam.put("limit", String.valueOf(10));
//			requestParam.put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");
//			requestParam.put("sign",testService.generateSign(requestParam, appSecret, "MD5"));
			Map<String, Object> requestParam = new HashMap<>();
			requestParam.put("app_key", "1000055");
			requestParam.put("deviceId", UUID.randomUUID().toString().replace("-", ""));
			requestParam.put("city", "杭州");
			requestParam.put("timestamp", "2021-02-20 18:00:10");
			requestParam.put("format", "json");
			requestParam.put("v", "1");
			requestParam.put("sign_method", "MD5");
			requestParam.put("page", String.valueOf(data));
			requestParam.put("limit", String.valueOf(10));
			requestParam.put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");
			requestParam.put("sign", testService.generateSign(requestParam, appSecret, "MD5"));
			HttpResponse<String> response = null;
			try {
				response = Unirest
						.get("https://openapi.dianping.com/router/poi/querypoi")
						.queryString(requestParam)
						.asString();
			} catch (UnirestException e) {
				e.printStackTrace();
			}
//			System.out.println(requestParam.toString());
			System.out.println(response.getBody());
		});


	}


	@Test
	public void category() {
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("app_key", "1000055");
		requestParam.put("deviceId", UUID.randomUUID().toString().replace("-", ""));
		requestParam.put("city_name", "上海");
		requestParam.put("timestamp", "2021-01-30 18:00:10");
		requestParam.put("format", "json");
		requestParam.put("v", "1");
		requestParam.put("sign_method", "MD5");
		requestParam.put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");
		requestParam.put("sign", testService.generateSign(requestParam, appSecret, "MD5"));
		HttpResponse<String> response = null;
		try {
			response = Unirest
					.get("https://openapi.dianping.com/router/poi/queryOpenCategoryName")
					.queryString(requestParam)
					.asString();
		} catch (UnirestException e) {
			e.printStackTrace();
		}
//			System.out.println(requestParam.toString());
		System.out.println(response.getBody());


	}

	public Map<String,Object> getBaseMap(){
		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("app_key", "1000055");
		requestParam.put("deviceId", UUID.randomUUID().toString().replace("-", ""));

		requestParam.put("timestamp", "2021-01-30 18:00:10");
		requestParam.put("format", "json");
		requestParam.put("v", "1");
		requestParam.put("sign_method", "MD5");
		requestParam.put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");

		return requestParam;
	}
}
