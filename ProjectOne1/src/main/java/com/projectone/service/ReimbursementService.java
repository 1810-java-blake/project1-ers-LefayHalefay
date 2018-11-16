package com.projectone.service;

import java.util.List;

import com.projectone.model.Reimbursement;

public interface ReimbursementService {
	
	ReimbursementService currentImplementation = new ReimbursementServiceImpl();
	
	List<Reimbursement> findRequestAllEmployees(); //Reimbursement/request/allEmployees
	
	List<Reimbursement> findAllRequestsForEmployee(int reimbAuthorId); //Reimbursement/request/employee
	
	Reimbursement cancelRequestByEmployee(int employeeId, int requestId); //Reimbursement/request/cancelRequest
	
	Reimbursement updateRequestByMgr(Reimbursement reimbRequest); //Reimbursement/request/updateRequest
	
	int addRequestByEmployee(Reimbursement newReimbursement); //Reimbursement/request/addRequest.
	

}
