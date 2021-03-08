package com.vikko.demo.project;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author: vikko
 * @Date: 2021/2/25 16:31
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper {

	/**
	 * count
	 * @return
	 */
	int userCount();
}
