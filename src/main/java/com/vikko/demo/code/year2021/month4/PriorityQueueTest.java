package com.vikko.demo.code.year2021.month4;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.stream.IntStream;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

/**
 * @author: vikko
 * @Date: 2021/4/14 18:58
 * @Description:
 */
public class PriorityQueueTest {

	public static void main(String[] args) {
		List<User> userList = Lists.newArrayList();
		IntStream.rangeClosed(1, 100).boxed().forEach(i->{
			userList.add(User.builder()
					.id(i)
					.age(new Random().nextInt(60))
					.build());
		});
		Collections.shuffle(userList);


		PriorityQueue<User> userQueue = new PriorityQueue<>(10, Comparator.comparingInt(User::getId).reversed());

		userList.forEach(userQueue::add);
		User user = userQueue.poll();
		while (Objects.nonNull(user)){
			System.out.println(user);
			user = userQueue.poll();
		}
//		System.out.println(userQueue.peek());
		System.out.println(userQueue.size());
	}

//	private List<User> topN(int size, )

	@Data
	@Builder
	@NoArgsConstructor
	static class User{
		private Integer id;
		private Integer age;

		public User(Integer id, Integer age) {
			this.id = id;
			this.age = age;
		}
	}


}
