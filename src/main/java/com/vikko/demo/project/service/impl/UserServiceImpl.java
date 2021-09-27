package com.vikko.demo.project.service.impl;

import com.vikko.demo.code.toolkit.BaseException;
import com.vikko.demo.project.entity.Student;
import com.vikko.demo.project.mapper.UserMapper;
import com.vikko.demo.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:30
 * @Description:
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;
	private final TransactionTemplate transactionTemplate;
	private final RetryTemplate retryTemplate;
	private static int count = 0;

	@Override
//	@Transactional(rollbackFor = Exception.class)
	public Integer test(){
		Student before = userMapper.getById(1);
		System.out.println(before.toString());
		Student student = Student.builder()
				.id(3)
				.age(33)
				.build();
		userMapper.insert(student);

		Student after = userMapper.getById(3);
		System.out.println(after.toString());
		return after.getId();

	}

	@Override
	public void transactionTest(){
		transactionTemplate.execute(status->{
			try {
				Student first = Student.builder()
						.id(100)
						.age(100)
						.build();
				userMapper.insert(first);
				System.out.println(1 / 0);
				Student second = Student.builder()
						.id(101)
						.age(101)
						.build();
				userMapper.insert(second);
			} catch (Exception e) {
//				status.setRollbackOnly();
				e.printStackTrace();
			}
			return null;
		});

	}

	@Override
	public void testRetry() {
		count = 0;
		retryTemplate.execute(
				context -> {
					count++;
					throw new BaseException("401","自定义异常");
				});
	}

}
