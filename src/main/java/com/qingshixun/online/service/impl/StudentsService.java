package com.qingshixun.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qingshixun.online.dao.IStudentsDao;
import com.qingshixun.online.model.StudentModel;
import com.qingshixun.online.service.IStudentsService;

@Repository("studentService")
@Transactional
public class StudentsService implements IStudentsService {

	@Autowired
	private IStudentsDao studentsDao;
	/**
	 * 保存学生信息
	 */
	@Override
	public void save(StudentModel student) {
		studentsDao.save(student);
		
	}

	/**
	 * 查询所有学生信息
	 */
	@Override
	public List<StudentModel> getStudents() {
		
		return studentsDao.getStudents();
	}
	
	
	/**
	 * 查询所有男生
	 */
	@Override
	public List<StudentModel> getMaleStudents() {
		return studentsDao.getMaleStudents();
	}

	/**
	 * 查询所有女生
	 */
	@Override
	public List<StudentModel> getFemaleStudents() {
		return studentsDao.getFemaleStudents();
	}

	/**
	 * 查询Java方向学生信息
	 */
	@Override
	public List<StudentModel> getJavaStudents() {
		return studentsDao.getJavaStudents();
	}

	/**
	 * 查询web前端学生信息
	 */
	@Override
	public List<StudentModel> getWebStudents() {
		return studentsDao.getWebStudents();
	}

	/**
	 * 查询测试方向学生信息
	 */
	@Override
	public List<StudentModel> getTestStudents() {
		return studentsDao.getTestStudents();
	}
	/**
	 * 查询大数据学生信息
	 */

	@Override
	public List<StudentModel> getBigdataStudents() {
		return studentsDao.getBigdataStudents();
	}


}
