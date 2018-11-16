package com.projectone.service;

import java.util.List;

import javax.servlet.http.HttpSession;
import com.projectone.dao.EmployeeUserDao;
import com.projectone.dto.Credentials;
import com.projectone.model.EmployeeUser;

public class EmployeeUserServiceImpl implements EmployeeUserService {
	
	private EmployeeUserDao empDao = EmployeeUserDao.currentImplementation;

	@Override
	public List<EmployeeUser> findById(int id) {
		
		return empDao.findById(id);
	}

	@Override
	public List<EmployeeUser> findAll() {
		
		return empDao.findAll();
	}

	@Override
	public boolean loginUser(Credentials cred, HttpSession session) {
		
		EmployeeUser eUsr = empDao.findByUsernameAndPassword(cred.getUsername(), cred.getPassword());
		
		if(eUsr != null)
		{
			session.setAttribute("role", eUsr.getErsEmployeeRole().getRoleName());
			
			return true;
		}
		
		
		return false;
	}

}
