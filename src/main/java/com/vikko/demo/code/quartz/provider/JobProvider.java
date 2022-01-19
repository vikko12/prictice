package com.vikko.demo.code.quartz.provider;


import com.vikko.demo.code.quartz.domain.dto.req.BaseLearningCompleted;
import com.vikko.demo.code.quartz.domain.dto.req.RobotPip;
import com.vikko.demo.code.quartz.domain.dto.req.SleepCompletedDetail;
import com.vikko.demo.code.quartz.domain.job.JobManager;
import com.vikko.demo.code.quartz.domain.job.LearningCompletedJob;
import com.vikko.demo.code.quartz.domain.job.RobotPipJob;
import com.vikko.demo.code.quartz.domain.job.SleepCompletedJob;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Edward
 * @Date: 2020/11/25 17:04
 * @Description:
 */
@RestController
@AllArgsConstructor
@RequestMapping("/provider/job")
public class JobProvider {

	private final JobManager jobManager;

	@PostMapping("/learned/notify")
	public void learnedNotify(@RequestBody BaseLearningCompleted jobDetail) {
		jobManager.jobAction(jobDetail, LearningCompletedJob.class);
	}

	@PostMapping("/robot/pip/notify")
	public void breakNotify(@RequestBody RobotPip robotPip){
		jobManager.jobAction(robotPip, RobotPipJob.class);
	}

	/**
	 * 睡觉结束通知
	 * @param sleepCompletedDetail
	 */
	@PostMapping("/robot/sleep/notify")
	public void sleepNotify(@RequestBody SleepCompletedDetail sleepCompletedDetail){
		jobManager.jobAction(sleepCompletedDetail, SleepCompletedJob.class);
	}

}
