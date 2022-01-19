package com.vikko.demo.code.quartz.domain.dto.req;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @Author: Edward
 * @Date: 2020/11/25 16:32
 * @Description:
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseLearningCompleted extends JobDetail {

	private Long robotId;

	private String robotName;

	private String title;

	private String content;

	private Long corpusId;

	private String pushToken;

	private String platform;

	private Long userId;


	@Override
	public String getUniqueName() {
		return compositeJobName(super.getJobName(), userId.toString(), robotId.toString(), corpusId.toString(),
				platform);	}
}
