package com.vikko.demo.project;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Integer count(){
		return userMapper.userCount();
	}

}
