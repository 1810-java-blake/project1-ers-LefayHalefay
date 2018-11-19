package com.projectone.controllers;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projectone.model.Reimbursement;
import com.projectone.service.ReimbursementService;

public class DispatcherServlet extends HttpServlet {
	
	/***/
	private static final long serialVersionUID = 1L;

	private Logger log = Logger.getRootLogger();
	private EmployeeUserController empUsrCtr = new EmployeeUserController();
	private ReimbursementController reimbCtr = new ReimbursementController();
	
	private ReimbursementService reimbService = ReimbursementService.currentImplementation;


//	 public void init() throws ServletException {
//	        System.out.println("Initializing...");
//	 }
	
	 protected void service(HttpServletRequest reqt, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("I'm here baby!");
		
		resp.addHeader("Acess-Control-Allow-Origin", "http://localhost:8080");
		resp.addHeader("Access-Control-Allow-Origin", "http://localhost:3000");
		resp.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, PATCH, DELETE, HEAD");
		resp.addHeader("Access-Control-Allow-Headers","Origin, Methods, Credentials, X-Requested-With, Content-Type, Accept");
		resp.addHeader("Access-Control-Allow-Credentials", "true");
		resp.setContentType("application/json");
		
		String uri = reqt.getRequestURI();
		
		System.out.println(uri);
		System.out.println(uri.length());
		
		String context = "Reimbursement";
		
		uri = uri.substring(context.length(), uri.length());
		
		String [] uriArray = uri.split("/");
		
		System.out.println(Arrays.toString(uriArray));
		
        if (uriArray[1].startsWith("employee")) {
			empUsrCtr.process(reqt, resp);
		} else if (uriArray[1].startsWith("request")) {
			reimbCtr.process(reqt, resp);
		}else {
			reimbCtr.process(reqt, resp);
			resp.setStatus(404);
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest reqt, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Getting all requests...");
		
		List<Reimbursement> reimbRequest = reimbService.findRequestAllEmployees(); 
		
		ObjectMapper objMpr = new ObjectMapper();
		String json = objMpr.writeValueAsString(reimbRequest);
		resp.getWriter().write(json);
	}
	

}
