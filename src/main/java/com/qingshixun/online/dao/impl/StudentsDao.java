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
	 * ������Ϣ
	 */
	@Override
	public void save(StudentModel student) {
		sessionFactory.getCurrentSession().save(student);
		
	}
	
	/**
	 * ��ѯ����ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getStudents() {
		List<StudentModel> students=sessionFactory.getCurrentSession().createQuery("FROM StudentModel").list();
		return students;
	}
	
	/**
	 * ��ѯ����������Ϣ
	 */
	@Override
	public List<StudentModel> getMaleStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE sex=:value ");
		 query.setString("value","��");
		return 	query.list();
	}
	
	/**
	 * ��ѯ����Ů����Ϣ
	 */
	@Override
	public List<StudentModel> getFemaleStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE sex=:value ");
		 query.setString("value","Ů");
		return query.list();
	}
	
	/**
	 * ��ѯJava����ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getJavaStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","Java����");
		return query.list();
	}
	
	/**
	 * ��ѯwebǰ��ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getWebStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","webǰ��");
		return query.list();
	}
	
	/**
	 *���Է���ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getTestStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","�������");
		return query.list();
	}
	
	/**
	 *��ѯ�����ݷ����ѧ����Ϣ
	 */
	@Override
	public List<StudentModel> getBigdataStudents() {
		 Query query=sessionFactory.getCurrentSession().createQuery("FROM StudentModel WHERE direction=:value ");
		 query.setString("value","������");
		return query.list();
	}

}
