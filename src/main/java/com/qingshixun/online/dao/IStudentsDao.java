package com.qingshixun.online.dao;

import java.util.List;

import com.qingshixun.online.model.StudentModel;

public interface IStudentsDao {

	void save(StudentModel student);

	List<StudentModel> getStudents();

	List<StudentModel> getMaleStudents();

	List<StudentModel> getFemaleStudents();

	List<StudentModel> getJavaStudents();

	List<StudentModel> getWebStudents();

	List<StudentModel> getTestStudents();

	List<StudentModel> getBigdataStudents();
}
