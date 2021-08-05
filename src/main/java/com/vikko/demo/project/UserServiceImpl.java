package com.vikko.demo.project;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:30
 * @Description:
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserMapper userMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer test(){
		Student before = userMapper.getById(1);
		System.out.println(before.toString());
		Student student = Student.builder()
				.id(1)
				.age(55)
				.build();
		userMapper.updateStudent(student);

		Student after = userMapper.getById(1);
		System.out.println(after.toString());
		return after.getId();

	}

}
