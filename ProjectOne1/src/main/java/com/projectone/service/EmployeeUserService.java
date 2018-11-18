package com.projectone.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.projectone.dto.Credentials;
import com.projectone.model.EmployeeUser;

public interface EmployeeUserService {
	
	EmployeeUserService currentImplementation = new EmployeeUserServiceImpl();
	
	List<EmployeeUser> findById(int id);
	
	List<EmployeeUser> findByUsername(String username);

	List<EmployeeUser> findAll();

	boolean loginUser(Credentials cred, HttpSession httpSession);

}
