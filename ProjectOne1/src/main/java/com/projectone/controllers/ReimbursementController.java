package com.projectone.controllers;
import com.projectone.util.ResponseMapper;

import java.util.List;
import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.model.Reimbursement;
import com.projectone.service.ReimbursementService;

public class ReimbursementController {
	
	private Logger log = Logger.getRootLogger();
	private ReimbursementService reimbService = ReimbursementService.currentImplementation;
	private ObjectMapper objMap = new ObjectMapper();

	public void process(HttpServletRequest reqt, HttpServletResponse resp) throws IOException {
		
		String reqtMethod = reqt.getMethod();
		log.trace("Request Made to the Reimbursement Controller: " + reqt.getMethod());
		
		switch(reqtMethod) {
			case "GET":
				processGet(reqt, resp);
				break;
			case "POST":
				processPost(reqt, resp);
				break;
			case "PATCH":
				processPatch(reqt, resp);
				break;	
			case "OPTIONS":
				return;
			default:
				resp.setStatus(404);
				break;
			}	
		}

	private void processGet(HttpServletRequest reqt, HttpServletResponse resp) throws IOException {
		
		System.out.println("At least you are here!");
		
		String uri = reqt.getRequestURI();
		String context = "Reimbursement";
		uri = uri.substring(context.length(), uri.length());
		String [] uriArray = uri.split("/");
		System.out.println(Arrays.toString(uriArray));
		
		if(uriArray[2].startsWith("allEmployees")) {
			//String role = (String) reqt.getSession().getAttribute("role");	
			List<Reimbursement> reimbRequest = reimbService.findRequestAllEmployees();
			ResponseMapper.convertAndAttach(reimbRequest, resp);
			return;
			
		} else if(uriArray[2].startsWith("employee")){
			try {
				int id = Integer.parseInt(uriArray[3]);
				System.out.print("retreiving Employee with id: " + id);
				List<Reimbursement> reimb = reimbService.findAllRequestsForEmployee(id);
				ResponseMapper.convertAndAttach(reimb, resp);
				return;
			} 
			catch(NumberFormatException e) {
				resp.setStatus(400);
			};	
		}
	}

	private void processPost(HttpServletRequest reqt, HttpServletResponse resp) throws IOException {
		
		System.out.print("I am here from Russ!");
		
		String uri = reqt.getRequestURI();
		String context = "Reimbursement";
		uri = uri.substring(context.length(), uri.length());
		String [] uriArray = uri.split("/");
		
		System.out.println(Arrays.toString(uriArray));
		
		if(uriArray[2].startsWith("updateRequest")) {
			
			Reimbursement reimbRequest = objMap.readValue(reqt.getReader(), Reimbursement.class);
			reimbService.addRequestByEmployee(reimbRequest);
			
			resp.getWriter().write(" " + reimbRequest.getReimbId());
			resp.setStatus(201);
			return;
			
		}
	}
	
	private void processPatch(HttpServletRequest reqt, HttpServletResponse resp ) throws JsonParseException, JsonMappingException, IOException {
		String uri = reqt.getRequestURI();
		String context = "Reimbursement";
		uri = uri.substring(context.length(), uri.length());
		String [] uriArray = uri.split("/");
		
		System.out.println(Arrays.toString(uriArray));
		
		if(uriArray[2].startsWith("updateRequest")) {
		
			Reimbursement reimbRequest = objMap.readValue(reqt.getReader(), Reimbursement.class);
			reimbService.updateRequestByMgr(reimbRequest);
			
			resp.getWriter().write(" " + reimbRequest.getReimbId());
			
			resp.setStatus(201);
			return;
		}
	}	
}
	

