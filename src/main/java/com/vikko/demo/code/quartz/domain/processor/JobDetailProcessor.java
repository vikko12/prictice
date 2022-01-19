package com.vikko.demo.code.quartz.domain.processor;


import com.vikko.demo.code.quartz.domain.dto.req.JobDetail;

/**
 * @Author: Edward
 * @Date: 2020/11/25 16:20
 * @Description:
 */

public interface JobDetailProcessor<T extends JobDetail> {

	/**
	 * 定时任务结束
	 * @param t
	 */
	void process(T t);

}
