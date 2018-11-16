package com.projectone.dao;

import java.util.List;
import com.projectone.model.Reimbursement;

public interface ReimbursementDao {
	ReimbursementDao currentImplementation = new ReimbursementDaoJDBC();
	
	/*(1) Query/Method to VIEW(Select) Reimbursement by Employee ID.
	 *   	- Status: Pending, Approved, Denied
	 *(2) Query/Method to ADD(Insert) Reimbursement by Employee ID.
	 *   	- Status: Pending
	 *(3) Query/Method to CANCEL(DELETE) While on PENDING Status.
	 *
	 *(4) Query/Method VIEW(Select) Reimbursement for Employees. 
	 * 
	 *(5) Query/Method Take Action(UPDATE) by Manager Approve/Deny.
	 */
	
	//Reimbursement findRequestByEmployeeId(int id);
	
	Reimbursement cancelRequestByEmployee(int employeeId, int requestId);
	
	Reimbursement updateRequestByMgr(Reimbursement updateReimb);
	int addRequestByEmployee(Reimbursement newReimbursement);

	List<Reimbursement> findRequestAllEmployees();
	
	List<Reimbursement> findAllRequestsForEmployee(int reimbAuthorId);
	
	
}