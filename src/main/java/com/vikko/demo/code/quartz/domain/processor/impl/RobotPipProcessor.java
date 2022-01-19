package com.vikko.demo.code.quartz.domain.processor.impl;

import com.vikko.demo.code.quartz.domain.dto.req.RobotPip;
import com.vikko.demo.code.quartz.domain.processor.JobDetailProcessor;
import javafx.scene.control.Alert;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @Author: Edward
 * @Date: 2020/11/27 11:32
 * @Description:
 */
@Component
@AllArgsConstructor
public class RobotPipProcessor implements
		JobDetailProcessor<RobotPip> {

//	private final RobotFeign robotFeign;
//
//	private final PushFeign pushFeign;

	@Override
	public void process(RobotPip robotPip) {
		// 更改robot阶段
//		robotFeign.updRobotStage(robotPip.getRobotId(), RobotStage.WAITING_OUT);
//		// 发送push通知给用户
//		pushFeign.push(SinglePushReq.builder()
//				.platform(robotPip.getPlatform())
//				.token(robotPip.getPushToken())
//				.message(Message.builder()
//						.alert(Alert.builder()
//								.title(robotPip.getPushTitle())
//								.build())
//						.build())
//				.userId(robotPip.getUserId())
//				.build());
	}

}
