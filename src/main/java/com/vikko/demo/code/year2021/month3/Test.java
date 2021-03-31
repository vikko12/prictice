package com.vikko.demo.code.year2021.month3;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: vikko
 * @Date: 2021/3/17 17:38
 * @Description:
 */
public class Test {

	public static void main(String[] args) {
//		List<TaskInfo> list = Lists.newArrayList(new TaskInfo());
//		List<TaskInfo> subResult = list.stream().filter(data -> data.getTaskStatus() == 7).collect(Collectors.toList());
		String s = "test";
		s.trim();
		char[] chars = s.toCharArray();

	}

}
@Data
@AllArgsConstructor
@NoArgsConstructor
class TaskInfo{
	private Integer taskStatus;
}
