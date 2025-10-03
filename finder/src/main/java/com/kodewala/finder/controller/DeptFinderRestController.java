package com.kodewala.finder.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kodewala.finder.bean.DeptRequest;

@RestController
public class DeptFinderRestController {

	@PostMapping("/findDeptRest")
	public String findDept(@RequestBody DeptRequest deptRequest) {
		String id = deptRequest.getDeptId();
		System.out.println(" Request received for the dept id : " + id);
		return " Request received for the dept id : " + id;
	}

}
