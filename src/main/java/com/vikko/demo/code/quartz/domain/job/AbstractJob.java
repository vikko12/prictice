package com.vikko.demo.code.quartz.domain.job;

import com.alibaba.fastjson.JSONObject;
import com.vikko.demo.code.quartz.domain.dto.req.JobDetail;
import com.vikko.demo.code.quartz.domain.processor.JobDetailProcessor;
import com.vikko.demo.code.quartz.domain.service.DateUtils;
import com.vikko.demo.code.year2021.month10.inject.SpringContextUtil;
import java.lang.reflect.ParameterizedType;
import lombok.extern.log4j.Log4j2;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @Author: Edward
 * @Date: 2020/11/25 14:10
 * @Description:
 */
@Log4j2
public abstract class AbstractJob<T extends JobDetail, P extends JobDetailProcessor<T>> extends QuartzJobBean {

	private Class<T> jobDetailClass;

	private Class<P> processorClass;

	@SuppressWarnings("unchecked")
	public AbstractJob() {
		jobDetailClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		processorClass = (Class<P>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}

	@Override
	@SuppressWarnings("unchecked")
	protected void executeInternal(JobExecutionContext jobExecutionContext)
			throws JobExecutionException {
		JobDataMap jobDataMap = jobExecutionContext.getJobDetail().getJobDataMap();
		JobDetailProcessor processor = SpringContextUtil
				.getBeanByClass(processorClass);
		T t = JSONObject.parseObject(JSONObject.toJSONString(jobDataMap), jobDetailClass);
		log.info("开始执行:[{}-{}]任务,当前时间:[{}]", t.getJobGroupName(), t.getUniqueName(), DateUtils.getCurrentTime());
		log.info("执行参数:[{}]", JSONObject.toJSONString(jobDataMap));
		processor.process(t);
	}

}
