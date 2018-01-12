package com.qingshixun.online.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qingshixun.online.model.StudentModel;
import com.qingshixun.online.service.IStudentsService;

@Controller
@RequestMapping("/student")
public class StudentIfonManageController {

	@Autowired
	private IStudentsService studentsService;

	/**
	 * 查询所有学生信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String studentList(Model model) {
		model.addAttribute("students", studentsService.getStudents());
		return "/student/list/list";
	}

	
	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toSave() {
		return "/student/manage/add";
	}

	/**
	 * 保存学生信息
	 * @param student
	 * @return
	 */
	@RequestMapping("/save")
	@ResponseBody
	public String save(@ModelAttribute StudentModel student) {
		studentsService.save(student);
		return "success";
	}

	/**
	 * 根据性别查询信息：男
	 * @param model
	 * @return
	 */
	@RequestMapping("/male/list")
	public String getMaleStudents(Model model) {
		model.addAttribute("students", studentsService.getMaleStudents());
		return "/student/list/list";
	}

	/**
	 * 根据性别查询信息：女
	 * @param model
	 * @return
	 */
	@RequestMapping("/female/list")
	public String getFemaleStudents(Model model) {
		model.addAttribute("students", studentsService.getFemaleStudents());
		return "/student/list/list";
	}

	/**
	 * 查询Java方向的学生信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/java/list")
	public String getJavaStudents(Model model) {
		model.addAttribute("students", studentsService.getJavaStudents());
		return "/student/list/list";
	}

	/**
	 * 查询web前端学生信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/web/list")
	public String getWebStudents(Model model) {
		model.addAttribute("students", studentsService.getWebStudents());
		return "/student/list/list";
	}

	/**
	 * 查询测试方向的学生信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/test/list")
	public String getTestStudents(Model model) {
		model.addAttribute("students", studentsService.getTestStudents());
		return "/student/list/list";
	}

	/**
	 * 查询大数据方向学生信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/bigdata/list")
	public String getBigdataStudents(Model model) {
		model.addAttribute("students", studentsService.getBigdataStudents());
		return "/student/list/list";
	}

}
