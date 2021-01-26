package com.vikko.demo.suanfa.year2021.month1.java8;

import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: vikko
 * @Date: 2021/1/19 17:15
 * @Description:
 */
public class NepHandle {

	public static void main(String[] args) {


		ExtraInfo extraInfo = new ExtraInfo("在你心里");
		TeacherInfo teacherInfo = new TeacherInfo("高级教师", extraInfo);
		StudentInfo studentInfo = new StudentInfo(1, teacherInfo);

		User user = new User("name",new StudentInfo());


		String result = Optional.ofNullable(user)
				.map(User::getStudentInfo)
				.map(StudentInfo::getTeacherInfo)
				.map(TeacherInfo::getExtraInfo)
				.map(ExtraInfo::getAddress)
				.orElse("啥也没有");
		System.out.println(result);

	}

	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	static class User{
		private String name;
		private StudentInfo studentInfo;
	}

	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	static class StudentInfo{
		private Integer classId;

		private TeacherInfo teacherInfo;
	}

	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	static class TeacherInfo{
		private String title;
		private ExtraInfo extraInfo;
	}

	@AllArgsConstructor
	@Data
	@NoArgsConstructor
	static class ExtraInfo{
		private String address;
	}
}
