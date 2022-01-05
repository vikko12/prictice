package com.vikko.demo.project.mapper;

import com.vikko.demo.project.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
	@Select("select count(1) from student")
	int userCount(@Param("id")Long id);


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
	/**
	 * getById
	 * @param age
	 * @return
	 */
	Student getByAge(@Param("age")Integer age);


}
