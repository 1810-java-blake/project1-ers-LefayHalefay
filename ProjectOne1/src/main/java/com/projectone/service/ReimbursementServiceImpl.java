package com.projectone.service;

import java.util.List;

import com.projectone.dao.ReimbursementDao;
import com.projectone.model.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {

	private ReimbursementDao rd = ReimbursementDao.currentImplementation;
	
	@Override
	public List<Reimbursement> findRequestAllEmployees() {
		return rd.findRequestAllEmployees();
	}

	@Override
	public List<Reimbursement> findAllRequestsForEmployee(int reimbAuthorId) {
		
		return rd.findAllRequestsForEmployee(reimbAuthorId);
	}

	@Override
	public Reimbursement cancelRequestByEmployee(int employeeId, int requestId) {
		
		return rd.cancelRequestByEmployee(employeeId, requestId);
	}

	
	@Override
	public int addRequestByEmployee(Reimbursement newReimbursement) {
		
		return rd.addRequestByEmployee(newReimbursement);
	}

	@Override
	public Reimbursement updateRequestByMgr(Reimbursement reimbUpdate) {
		return rd.updateRequestByMgr(reimbUpdate);
	}

}
