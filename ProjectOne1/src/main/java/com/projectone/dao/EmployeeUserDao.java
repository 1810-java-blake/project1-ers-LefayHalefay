package com.projectone.dao;

import java.util.List;

import com.projectone.model.EmployeeUser;

public interface EmployeeUserDao {
	
	EmployeeUserDao currentImplementation = new EmployeeUserDaoJDBC();
	
	List<EmployeeUser> findById(int id);
	
	List<EmployeeUser> findByUsername(String username);

	List<EmployeeUser> findAll();

	EmployeeUser findByUsernameAndPassword(String username, String password);

}
