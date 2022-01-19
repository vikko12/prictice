package com.vikko.demo.code.quartz.domain.dto.req;

import com.vikko.demo.code.quartz.domain.dto.enumeration.JobAction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2020/11/25 15:24
 * @Description:
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class JobDetail {

	protected String jobName;

	protected String jobGroupName;

	protected String cron;

	protected JobAction jobAction;

	protected String compositeJobName(String... args) {
		return String.join("-",args);
	}

	/**
	 * 获取单个用户任务唯一标识
	 * @return
	 */
	public abstract String getUniqueName();

}
