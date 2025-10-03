package com.kodewala.finder.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kodewala.finder.entity.Department;

@Repository
public interface DeptRepository extends CrudRepository<Department, Long> {

	public Optional<Department> findByName(String name); // select * from dept where name="?";

//	public Optional<Department> findByStatus(String status); // select * from dept where status="?";

}
