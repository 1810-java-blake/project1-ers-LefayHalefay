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
			session.setAttribute("userId", eUsr.getErsUsersId());
			System.out.println("Bro, this is your session Role!");
			System.out.println(session.getAttribute("role"));
			System.out.println(session.getAttribute("userId"));
			
			return true;
		}
			
		return false;
	}

	@Override
	public List<EmployeeUser> findByUsername(String username) {
		
		System.out.print("Let me know you are here!");
		return empDao.findByUsername(username);
	}

}
