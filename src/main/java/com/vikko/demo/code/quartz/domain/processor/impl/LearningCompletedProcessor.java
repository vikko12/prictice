package com.vikko.demo.code.quartz.domain.processor.impl;

import com.vikko.demo.code.quartz.domain.dto.req.BaseLearningCompleted;
import com.vikko.demo.code.quartz.domain.processor.JobDetailProcessor;
import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/11/25 17:19
 * @Description:
 */
@Log4j2
@AllArgsConstructor
@Component("LearningCompletedProcessorImpl")
public class LearningCompletedProcessor implements JobDetailProcessor<BaseLearningCompleted> {


	@Override
	public void process(BaseLearningCompleted baseLearningCompleted) {
		log.info("学习完成定时器开始执行:");
		// 更改机器人 的corpusId学习状态
		log.info("修改机器人学习状态");
		log.info("开始发送push通知");

		log.info("push通知发送结束");
	}
}
