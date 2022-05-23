package com.vikko.demo.code.year2022;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import org.lionsoul.ip2region.DataBlock;
import org.lionsoul.ip2region.DbConfig;
import org.lionsoul.ip2region.DbSearcher;
import org.lionsoul.ip2region.Util;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author: vikko
 * @Date: 2022/4/12 16:50
 * @Description:
 */
public class RegionTest {

	/**
	 * 根据IP地址获取城市
	 * @param ip
	 * @return
	 */
	public static String getCityInfo(String ip) throws IOException {
		URL url = RegionTest.class.getResource("/ip2region.db");
		Resource resource = new ClassPathResource("ip2region.db");
		String filePath = RegionTest.class.getClassLoader().getResource("ip2region.db").getPath();

		File file = null;
		try {
			file = new File(filePath);
		} catch (Exception e) {
			System.out.println("文件不存在");
		}
		if (!file.exists()) {
			System.out.println("Error: Invalid ip2region.db file, filePath：" + file.getPath());
			return null;
		}
		//查询算法
		int algorithm = DbSearcher.BTREE_ALGORITHM; //B-tree
		//DbSearcher.BINARY_ALGORITHM //Binary
		//DbSearcher.MEMORY_ALGORITYM //Memory
		try {
			DbConfig config = new DbConfig();
			DbSearcher searcher = new DbSearcher(config, file.getPath());
			Method method;
			switch ( algorithm )
			{
				case DbSearcher.BTREE_ALGORITHM:
					method = searcher.getClass().getMethod("btreeSearch", String.class);
					break;
				case DbSearcher.BINARY_ALGORITHM:
					method = searcher.getClass().getMethod("binarySearch", String.class);
					break;
				case DbSearcher.MEMORY_ALGORITYM:
					method = searcher.getClass().getMethod("memorySearch", String.class);
					break;
				default:
					return null;
			}
			DataBlock dataBlock;
			if (!Util.isIpAddress(ip)) {
				System.out.println("Error: Invalid ip address");
				return null;
			}
			dataBlock  = (DataBlock) method.invoke(searcher, ip);
			return dataBlock.getRegion();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
//		System.out.println(getCityInfo("113.105.172.33"));
//		System.out.println(getCityInfo("192.168.31.111"));
//		System.out.println(getCityInfo("66.94.123.222"));
//		System.out.println(getCityInfo("101.229.46.28"));

		try {
			System.out.println(1 / 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
