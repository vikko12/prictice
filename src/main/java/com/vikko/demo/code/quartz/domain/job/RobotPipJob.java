package com.vikko.demo.code.quartz.domain.job;

import com.vikko.demo.code.quartz.domain.dto.req.RobotPip;
import com.vikko.demo.code.quartz.domain.processor.impl.RobotPipProcessor;
import lombok.extern.log4j.Log4j2;

/**
 * @Author: Edward
 * @Date: 2020/11/27 11:06
 * @Description:
 */
@Log4j2
public class RobotPipJob extends AbstractJob<RobotPip, RobotPipProcessor> {

}
