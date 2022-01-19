package com.vikko.demo.code.quartz.domain.processor.impl;

import com.vikko.demo.code.quartz.domain.dto.req.SleepCompletedDetail;
import com.vikko.demo.code.quartz.domain.processor.JobDetailProcessor;
import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

/**
 * @author: vikko
 * @Date: 2020/12/28 16:31
 * @Description:
 */

@Log4j2
@AllArgsConstructor
@Component("sleepCompletedProcessor")
public class SleepCompletedProcessor implements JobDetailProcessor<SleepCompletedDetail> {

//	private final PushFeign pushFeign;
//	private final RobotFeign robotFeign;

	@Override
	public void process(SleepCompletedDetail detail) {

		log.info("睡觉完成定时器开始执行:");

		log.info("开始发送push通知");
//		pushFeign.push(SinglePushReq.builder()
//				.userId(detail.getUserId())
//				.token(detail.getPushToken())
//				.platform(detail.getPlatform())
//				.message(Message.builder()
//						.alert(Alert.builder()
//								.title(detail.getTitle())
//								.build())
//						.build())
//				.build());
//		log.info("push通知发送结束");
//
//		SleepType sleepType = SleepType.getByCode(detail.getSleepTypeCode());
//		robotFeign.sleepCompleted(
//				SleepCompletedReq.builder().robotId(detail.getRobotId()).sleepType(sleepType).build());
	}
}
