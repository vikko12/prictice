package com.vikko.demo.december.bloomFilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.Charsets;

/**
 * @author: vikko
 * @Date: 2020/12/15 16:31
 * @Description:
 */
public class BloomFilterDemo {
	public static void main(String[] args) {
		int total = 1000000;
		BloomFilter<CharSequence> bf =
				BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), total,0.000005);
		// 初始化 1000000 条数据到过滤器中
		for (int i = 0; i < total; i++) {
			bf.put("" + i);
		}
		// 判断值是否存在过滤器中
		int count = 0;
		for (int i = 0; i < total + 10000; i++) {
			if (bf.mightContain("" + i)) {
				count++;
			}
		}
		System.out.println("已匹配数量 " + count);
	}
}
