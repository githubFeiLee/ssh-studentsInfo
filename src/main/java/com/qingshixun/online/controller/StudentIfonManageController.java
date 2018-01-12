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
	 * ��ѯ����ѧ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/list")
	public String studentList(Model model) {
		model.addAttribute("students", studentsService.getStudents());
		return "/student/list/list";
	}

	
	/**
	 * ��ת�����ҳ��
	 * @return
	 */
	@RequestMapping("/toadd")
	public String toSave() {
		return "/student/manage/add";
	}

	/**
	 * ����ѧ����Ϣ
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
	 * �����Ա��ѯ��Ϣ����
	 * @param model
	 * @return
	 */
	@RequestMapping("/male/list")
	public String getMaleStudents(Model model) {
		model.addAttribute("students", studentsService.getMaleStudents());
		return "/student/list/list";
	}

	/**
	 * �����Ա��ѯ��Ϣ��Ů
	 * @param model
	 * @return
	 */
	@RequestMapping("/female/list")
	public String getFemaleStudents(Model model) {
		model.addAttribute("students", studentsService.getFemaleStudents());
		return "/student/list/list";
	}

	/**
	 * ��ѯJava�����ѧ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/java/list")
	public String getJavaStudents(Model model) {
		model.addAttribute("students", studentsService.getJavaStudents());
		return "/student/list/list";
	}

	/**
	 * ��ѯwebǰ��ѧ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/web/list")
	public String getWebStudents(Model model) {
		model.addAttribute("students", studentsService.getWebStudents());
		return "/student/list/list";
	}

	/**
	 * ��ѯ���Է����ѧ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/test/list")
	public String getTestStudents(Model model) {
		model.addAttribute("students", studentsService.getTestStudents());
		return "/student/list/list";
	}

	/**
	 * ��ѯ�����ݷ���ѧ����Ϣ
	 * @param model
	 * @return
	 */
	@RequestMapping("/bigdata/list")
	public String getBigdataStudents(Model model) {
		model.addAttribute("students", studentsService.getBigdataStudents());
		return "/student/list/list";
	}

}
