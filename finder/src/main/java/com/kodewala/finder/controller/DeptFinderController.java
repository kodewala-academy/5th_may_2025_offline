package com.kodewala.finder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodewala.finder.bean.DeptInfo;
import com.kodewala.finder.service.DeptService;

@Controller
public class DeptFinderController {

	@Autowired
	private DeptService deptService;

	@GetMapping("/findDept")
	public String findDept(@RequestParam("id") String id, Model model) {

		System.out.println("DeptFinderController.findDept() and id is " + id);
		DeptInfo info = deptService.findDept(Long.parseLong(id));
		System.out.println("DeptFinderController.findDept() " + info.getId() + " and " + info.getName());
		model.addAttribute("deptInfo", info);
		return "displayDept";
	}
}
