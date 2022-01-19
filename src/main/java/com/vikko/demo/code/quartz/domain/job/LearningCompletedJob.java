package com.vikko.demo.code.quartz.domain.job;

import com.vikko.demo.code.quartz.domain.dto.req.BaseLearningCompleted;
import com.vikko.demo.code.quartz.domain.processor.impl.LearningCompletedProcessor;
import lombok.extern.log4j.Log4j2;

/**
 * @Author: Edward
 * @Date: 2020/11/25 16:19
 * @Description:
 */
@Log4j2
public class LearningCompletedJob extends AbstractJob<BaseLearningCompleted, LearningCompletedProcessor> {


}
