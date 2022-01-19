package com.vikko.demo.code.quartz.domain.job;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vikko.demo.code.quartz.domain.dto.req.JobDetail;
import com.vikko.demo.code.quartz.domain.service.QuartzService;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/11/27 13:42
 * @Description:
 */
@Component
@AllArgsConstructor
public class JobManager {

	private final QuartzService quartzService;

	public <T extends AbstractJob> void jobAction(JobDetail jobDetail, Class<T> job) {

		if (Objects.nonNull(jobDetail) && Objects.nonNull(jobDetail.getJobAction())) {

			switch (jobDetail.getJobAction()) {
				case ADD:
					quartzService
							.addJob(job, jobDetail.getUniqueName(), jobDetail.getJobGroupName(),
									jobDetail.getCron(), JSONObject.toJavaObject(
											(JSON) JSONObject.toJSON(jobDetail), Map.class));
					break;
				case PAUSE:
					// TODO
					break;
				case DELETE:
					quartzService.deleteJob(jobDetail.getUniqueName(), jobDetail.getJobGroupName());
					break;
				case RESUME:
					// TODO
					break;
				case UPDATE:
					List<Map<String, Object>> jobs = quartzService.queryAllJob();
					Optional<Map<String, Object>> first = jobs.stream().filter(
							m -> jobDetail.getUniqueName().equals(m.get("jobName")) && jobDetail.getJobGroupName()
									.equals(m.get("jobGroupName"))).findFirst();
					if (first.isPresent()) {
						quartzService.updateJob(jobDetail.getUniqueName(), jobDetail.getJobGroupName(),
								jobDetail.getCron());
					} else {
						quartzService
								.addJob(job, jobDetail.getUniqueName(), jobDetail.getJobGroupName(),
										jobDetail.getCron(), JSONObject.toJavaObject(
												(JSON) JSONObject.toJSON(jobDetail), Map.class));
					}
					break;
				case JUST_RUN:
					// TODO
					break;
				default:
					break;
			}
		}

	}

}
