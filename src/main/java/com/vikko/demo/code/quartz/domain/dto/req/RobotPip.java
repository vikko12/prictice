package com.vikko.demo.code.quartz.domain.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2020/11/27 10:34
 * @Description:
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RobotPip extends JobDetail {

	private Long robotId;

	private String pushToken;

	private String pushTitle;

	private String platform;

	private Long userId;


	@Override
	public String getUniqueName() {
		return compositeJobName(jobName, userId.toString(), robotId.toString(), platform);
	}
}
