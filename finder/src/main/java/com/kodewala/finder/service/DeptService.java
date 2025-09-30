package com.kodewala.finder.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodewala.finder.bean.DeptInfo;
import com.kodewala.finder.entity.Department;
import com.kodewala.finder.repository.DeptRepository;

@Service
public class DeptService {

	@Autowired
	private DeptRepository deptRepository;

	public DeptInfo findDept(long id) {
		System.out.println("DeptService.findDept()... finding the dept info by id : " + id);
		Optional<Department> result = deptRepository.findById(id);

		Department dept = result.get();

		DeptInfo deptInfo = new DeptInfo();
		deptInfo.setName(dept.getName());
		deptInfo.setId(dept.getId());

		System.out.println("DeptService.findDept() " + deptRepository.findByName("HR").get().getId());
		return deptInfo;
	}
}
