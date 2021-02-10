package com.vy.microservice.topic.test;

import com.google.common.collect.Lists;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.lang3.StringUtils;

/**
 * @author: vikko
 * @Date: 2021/1/30 17:00
 * @Description:
 */
public class App {

	public static String generateSign(Map<String, Object> params, String appSecret,
			String signMethod) {
		// 第一步：参数排序
		List<String> keys = Lists.newArrayList();
		for (Map.Entry<String, Object> entry : params.entrySet()) {
			if (StringUtils.isNotEmpty(entry.getValue().toString())) {
				keys.add(entry.getKey());
			}
		}
		Collections.sort(keys);
		// 第二步：把所有参数名和参数值串在一起
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotEmpty(appSecret)) {
			sb.append(appSecret);
		}
		for (String key : keys) {
			sb.append(key).append(params.get(key).toString().trim());
		}
		if (StringUtils.isNotEmpty(appSecret)) {
			sb.append(appSecret);
		}
		String encryptionKey = sb.toString().trim();
		// 第三步：加签
		if (signMethod.equals("MD5")) {
			try {
				String sign = genMd5(encryptionKey);
				return sign;
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		} else {
			//开发者暂不需支持，支持MD5即可
			return "";
		}
	}

	public static String genMd5(String info)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		byte[] infoBytes = info.getBytes();
		md5.update(infoBytes);
		byte[] sign = md5.digest();
		return byteArrayToHex(sign);
	}

	public static String byteArrayToHex(byte[] bytes) {
		StringBuilder sign = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			String hex = Integer.toHexString(bytes[i] & 0xFF);
			if (hex.length() == 1) {
				sign.append("0");
			}
			sign.append(hex.toLowerCase());
		}
		return sign.toString();
	}


	public static void main(String[] args) {
		String appSecret = "4e0d1be81540c4d1f0868d329b3229467f071f6c";

		Map<String, Object> requestParam = new HashMap<>();
		requestParam.put("app_key", "1000055");
//		requestParam.put("deviceId", UUID.randomUUID().toString().replace("-",""));
		requestParam.put("deviceId", "deviceId");
		requestParam.put("longitude", "121.472644");
		requestParam.put("latitude", "31.231706");
		requestParam.put("timestamp", "2021-01-30 17:00:10");
		requestParam.put("format", "json");
		requestParam.put("v", "1");
		requestParam.put("sign_method", "MD5");
		requestParam.put("session", "c1fc1773a27d47e988725bc6df150626dbda0b4d");
		requestParam.put("page", String.valueOf(20));
		requestParam.put("limit", String.valueOf(10));

		System.out.println(generateSign(requestParam, appSecret, "MD5"));
	}
}
