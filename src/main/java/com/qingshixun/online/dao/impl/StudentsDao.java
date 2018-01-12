package com.qingshixun.online.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qingshixun.online.dao.IStudentsDao;
import com.qingshixun.online.model.StudentModel;

@Repository("studentsDao")
@SuppressWarnings("unchecked")
public class StudentsDao implements IStudentsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	/**
	 * 保存信息
	 */
	@Override
	public void save(StudentModel student) {
		sessionFactory.getCurrentSession().save(student);
		
	}
	
	/**
	 * 查询所有学生信息
	 */
	@Override
	public List<StudentModel> getStudents() {
		List<StudentModel> students=sessionFactory.getCurrentSession().createQuery("FROM StudentModel").list();
		return students;
	}
	
	/**
	 * 查询所有男生信息
	 */
	@Override
	public List<StudentModel> getMaleStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE sex=:value ");
		 query.setString("value","男");
		return 	query.list();
	}
	
	/**
	 * 查询所有女生信息
	 */
	@Override
	public List<StudentModel> getFemaleStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE sex=:value ");
		 query.setString("value","女");
		return query.list();
	}
	
	/**
	 * 查询Java方向学生信息
	 */
	@Override
	public List<StudentModel> getJavaStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","Java开发");
		return query.list();
	}
	
	/**
	 * 查询web前端学生信息
	 */
	@Override
	public List<StudentModel> getWebStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","web前端");
		return query.list();
	}
	
	/**
	 *测试方向学生信息
	 */
	@Override
	public List<StudentModel> getTestStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","软件测试");
		return query.list();
	}
	
	/**
	 *查询大数据方向的学生信息
	 */
	@Override
	public List<StudentModel> getBigdataStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","大数据");
		return query.list();
	}

}
