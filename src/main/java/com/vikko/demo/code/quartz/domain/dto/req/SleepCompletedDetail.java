package com.vikko.demo.code.quartz.domain.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author: vikko
 * @Date: 2020/12/28 16:27
 * @Description:
 */

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SleepCompletedDetail extends JobDetail {

	private Long robotId;

	private String robotName;

	private String title;

	private String content;

	private String pushToken;

	private String platform;

	private Long userId;

	private Integer type;

	private Long sleepRecordId;

	private Integer sleepTypeCode;


	@Override
	public String getUniqueName() {
		return compositeJobName(jobName, userId.toString(), sleepTypeCode.toString());
	}
}
