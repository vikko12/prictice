package com.vikko.demo.code.year2021.month10.factoryBean;

/**
 * @author: vikko
 * @Date: 2021/10/22 16:56
 * @Description:
 */
public interface Task {

	
	void execute();
	
	void setCron(String cron);
	
	String getCron();
}
