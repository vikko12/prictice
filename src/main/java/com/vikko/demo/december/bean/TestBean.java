package com.vikko.demo.december.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2020/12/2 18:00
 * @Description:
 */
@Component
public class TestBean implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("============前置方法testBean=========" + beanName);
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("============后置方法testBean=========" + beanName );
		return bean;
	}
}
