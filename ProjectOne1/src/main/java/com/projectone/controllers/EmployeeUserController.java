package com.projectone.controllers;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.dto.Credentials;
import com.projectone.model.EmployeeUser;
import com.projectone.service.EmployeeUserService;
import com.projectone.util.ResponseMapper;

public class EmployeeUserController {
	private Logger log = Logger.getRootLogger();
	private ObjectMapper objMap = new ObjectMapper();
	private EmployeeUserService empUserService = EmployeeUserService.currentImplementation;

	public void process(HttpServletRequest reqt, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {

		String method = reqt.getMethod();
		switch (method) {
		case "GET":
			processGet(reqt, resp);
			break;
		case "POST":
			processPost(reqt, resp);
			break;
		case "OPTIONS":
			return;
		default:
			resp.setStatus(404);
			break;
		}
	}

	private void processPost(HttpServletRequest reqt, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		
		String uri = reqt.getRequestURI();
		String context = "Reimbursement";
		uri = uri.substring(context.length(), uri.length());
		String [] uriArray = uri.split("/");
		System.out.println(Arrays.toString(uriArray));
		
		if(uriArray[2].startsWith("newUser")) {
			System.out.println("Creating New User...");
			
		} else if(uriArray[2].startsWith("userLogin")){
			
			System.out.println("Attempting To Log In...");
			Credentials cred = objMap.readValue(reqt.getReader(), Credentials.class);
			
			if(!empUserService.loginUser(cred, reqt.getSession())) {
				resp.setStatus(403);
			}
			
		} else {
			resp.setStatus(404);
		}

	}

	private void processGet(HttpServletRequest reqt, HttpServletResponse resp) throws JsonParseException, JsonMappingException, IOException {
		
		String uri = reqt.getRequestURI();
		String context = "Reimbursement";
		uri = uri.substring(context.length(), uri.length());
		String [] uriArray = uri.split("/");
		System.out.println(Arrays.toString(uriArray));
		
		if(uriArray[2].startsWith("employees")) {
			System.out.println("findingAllUsers...");
			List<EmployeeUser> empUsers = empUserService.findAll();
			ResponseMapper.convertAndAttach(empUsers, resp);
			return;
			
		} else if(uriArray[2].startsWith("theEmployee")){
			try {
				int empId = Integer.parseInt(uriArray[3]);
				System.out.println(empId);
				List<EmployeeUser> user = empUserService.findById(empId);
				ResponseMapper.convertAndAttach(user, resp);
				return;
				
			} catch(NumberFormatException e) {
				resp.setStatus(400);
				return;
			}		
		} else {
			resp.setStatus(404);
		}
	}

}
