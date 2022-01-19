package com.vikko.demo.code.year2021.month10.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: vikko
 * @Date: 2021/11/21 15:03
 * @Description:
 */
public class OOMTest {

	private void dontStop() {
		while(true) {
			System.out.println(System.currentTimeMillis());
		}
	}

	public void stackLeakByThread() {
		while(true) {
			Thread thread=new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String [] args) throws Throwable{
		OOMTest oom=new OOMTest();
		oom.stackLeakByThread();
	}


	@Data
	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	static class User{
		private Integer age;
		private String name;
		private Long birth;
		private Long address;

		public User(Long birth) {
			this.birth = birth;
		}
	}

}
