package com.vikko.demo.code.year2021.month10.inject;

import com.sun.org.apache.xml.internal.security.Init;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2021/10/20 16:03
 * @Description:
 */
public class ChildMode implements InitializingBean {

	private InjectService injectService;

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("[[[[[[[[[[[[[[[[[[[[[[[[[[[init]]]]]]]]]]]]]]]][");
		this.injectService = SpringContextUtil.getBeanByClass(InjectService.class);
	}


	public void process(){
//		injectService.print();
		System.out.println("finish this");
		System.out.println(this.toString());
	}
}
