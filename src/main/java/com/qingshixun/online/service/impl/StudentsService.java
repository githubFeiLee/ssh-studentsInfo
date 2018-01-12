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
	 * ����ѧ����Ϣ
	 */
	@Override
	public void save(StudentModel student) {
		studentsDao.save(student);
		
	}

	/**
	 * ��ѯ����ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getStudents() {
		
		return studentsDao.getStudents();
	}
	
	
	/**
	 * ��ѯ��������
	 */
	@Override
	public List<StudentModel> getMaleStudents() {
		return studentsDao.getMaleStudents();
	}

	/**
	 * ��ѯ����Ů��
	 */
	@Override
	public List<StudentModel> getFemaleStudents() {
		return studentsDao.getFemaleStudents();
	}

	/**
	 * ��ѯJava����ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getJavaStudents() {
		return studentsDao.getJavaStudents();
	}

	/**
	 * ��ѯwebǰ��ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getWebStudents() {
		return studentsDao.getWebStudents();
	}

	/**
	 * ��ѯ���Է���ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getTestStudents() {
		return studentsDao.getTestStudents();
	}
	/**
	 * ��ѯ������ѧ����Ϣ
	 */

	@Override
	public List<StudentModel> getBigdataStudents() {
		return studentsDao.getBigdataStudents();
	}


}
