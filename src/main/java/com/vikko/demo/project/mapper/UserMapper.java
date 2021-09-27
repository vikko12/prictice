package com.vikko.demo.project.mapper;

import com.vikko.demo.project.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

	/**
	 * udp
	 * @param student
	 * @return
	 */
	int updateStudent(Student student);

	/**
	 * insert
	 * @param student
	 * @return
	 */
	int insert(Student student);

	/**
	 * getById
	 * @param id
	 * @return
	 */
	Student getById(@Param("id")Integer id);
}
