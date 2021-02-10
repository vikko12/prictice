package com.vikko.demo.code.year2021.month2;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import lombok.Data;

/**
 * @author: vikko
 * @Date: 2021/2/2 21:52
 * @Description:
 */
public class TomapTest {

	public static void main(String[] args) {
		Student s1 = new Student("111", 1);
		Student s2 = new Student("13121", 2);
		Student s3 = new Student("178911", null);
		Student s4 = new Student("178rwr1", 3);

		Map<String, Integer> collect = Lists.newArrayList(s1, s2, s3, s4).stream()
				.collect(Collectors.toMap(Student::getName, Student::getRoom));
		System.out.println(collect);

	}




}

@Data
class Student{
	private String name;
	private Integer room;

	public Student(String name, Integer room) {
		this.name = name;
		this.room = room;
	}
}
