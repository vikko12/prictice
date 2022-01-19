package com.vikko.demo.code.quartz.domain.dto.enumeration;

/**
 * @Author: Edward
 * @Date: 2020/11/25 20:01
 * @Description:
 */
public enum JobType {

	learn_book(1, "学习书籍", "%s学习完成啦，快来看看吧~", "learn-book", "learn"),
	learn_audio(2, "学习歌曲", "%s学习完成啦，快来看看吧~", "learn-audio", "learn"),
	learn_video(3, "学习视频", "%s学习完成啦, 快来看看吧~", "learn-video", "learn"),
	learn_cons(4,"学习星座技能", "%s学习完星座课程啦，快来考考它~", "learn-cons", "learn"),
	robot_pip(5, "蛋孵化成功", "你的蛋成功孵化啦！", "robot-pip", "robot"),
	completed_sleep(6,"睡觉结束","宠物睡觉结束啦", "completed-sleep", "robot")
	;

	int value;

	String name;

	String content;

	String jobName;

	String jobGroupName;

	JobType(int value, String name, String content, String jobName,
			String jobGroupName) {
		this.value = value;
		this.name = name;
		this.content = content;
		this.jobName = jobName;
		this.jobGroupName = jobGroupName;
	}

	public int getValue() {
		return value;
	}

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getJobName() {
		return jobName;
	}

	public String getJobGroupName() {
		return jobGroupName;
	}
}
