package com.projectone.model;

import java.sql.Timestamp;


public class Reimbursement {
	
	private int reimbId;

	private double reimbAmount;
	private String reimbDescription;
	private String reimbReciept;
	private int reimbAuthorId;
	private EmployeeUser employeeUser;
	private int reimbResolverId;
	private String reimbStatus;
	private int reimbStatusId;
	private String reimbType;
	private int reimbTypeId;
	private Timestamp reimbSubmitted;
	private Timestamp reimbResolved;
	
	public Reimbursement(int reimbId, int reimbResolverId, int reimbStatusId) {
		super();
		this.reimbId = reimbId;
		this.reimbResolverId = reimbResolverId;
		this.reimbStatusId = reimbStatusId;
	}
	
	public Reimbursement(int reimbId, double reimbAmount, String reimbDescription, String reimbReciept,
			int reimbAuthorId, int reimbTypeId, int reimbStatusId, Timestamp reimbSubmitted, Timestamp reimbResolved) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbReciept = reimbReciept;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbTypeId = reimbTypeId;
		this.reimbStatusId = reimbStatusId;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}

	public Reimbursement(int reimbId, double reimbAmount, String reimbDescription, String reimbReciept,
			EmployeeUser employeeUser, String reimbStatus, String reimbType, Timestamp reimbSubmitted,
			Timestamp reimbResolved) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbReciept = reimbReciept;
		this.employeeUser = employeeUser;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}
	
	public Reimbursement(int reimbId, double reimbAmount, Timestamp reimbSubmitted, Timestamp reimbResolved,
			String reimbReciept, int reimbAuthorId, int reimbResolverId,  String reimbStatus, 
			String reimbType, String reimbDescription) {
		super();
		this.reimbId = reimbId;
		this.reimbAmount = reimbAmount;
		this.reimbDescription = reimbDescription;
		this.reimbReciept = reimbReciept;
		this.reimbAuthorId = reimbAuthorId;
		this.reimbResolverId = reimbResolverId;
		this.reimbStatus = reimbStatus;
		this.reimbType = reimbType;
		this.reimbSubmitted = reimbSubmitted;
		this.reimbResolved = reimbResolved;
	}
	
	public Reimbursement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getReimbId() {
		return reimbId;
	}


	public void setReimbId(int reimbId) {
		this.reimbId = reimbId;
	}


	public double getReimbAmount() {
		return reimbAmount;
	}


	public void setReimbAmount(double reimbAmount) {
		this.reimbAmount = reimbAmount;
	}


	public String getReimbDescription() {
		return reimbDescription;
	}


	public void setReimbDescription(String reimbDescription) {
		this.reimbDescription = reimbDescription;
	}


	public String getReimbReciept() {
		return reimbReciept;
	}


	public void setReimbReciept(String reimbReciept) {
		this.reimbReciept = reimbReciept;
	}


	public int getReimbAuthorId() {
		return reimbAuthorId;
	}


	public void setReimbAuthorId(int reimbAuthorId) {
		this.reimbAuthorId = reimbAuthorId;
	}


	public int getReimbResolverId() {
		return reimbResolverId;
	}


	public void setReimbResolverId(int reimbResolverId) {
		this.reimbResolverId = reimbResolverId;
	}


	public String getReimbStatus() {
		return reimbStatus;
	}


	public void setReimbStatusId(String reimbStatus) {
		this.reimbStatus = reimbStatus;
	}


	public String getreimbType() {
		return reimbType;
	}


	public void setreimbType(String reimbType) {
		this.reimbType = reimbType;
	}


	public Timestamp getReimbSubmitted() {
		return reimbSubmitted;
	}


	public void setReimbSubmitted(Timestamp reimbSubmitted) {
		this.reimbSubmitted = reimbSubmitted;
	}


	public Timestamp getReimbResolved() {
		return reimbResolved;
	}


	public void setReimbResolved(Timestamp reimbResolved) {
		this.reimbResolved = reimbResolved;
	}
	
	public EmployeeUser getEmployeeUser() {
		return employeeUser;
	}

	public void setEmployeeUser(EmployeeUser employeeUser) {
		this.employeeUser = employeeUser;
	}
	
	public int getReimbTypeId() {
		return reimbTypeId;
	}

	public void setReimbTypeId(int reimbTypeId) {
		this.reimbTypeId = reimbTypeId;
	}
	public int getReimbStatusId() {
		return reimbStatusId;
	}

	public void setReimbStatusId(int reimbStatusId) {
		this.reimbStatusId = reimbStatusId;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (employeeUser == null) {
			if (other.employeeUser != null)
				return false;
		} else if (!employeeUser.equals(other.employeeUser))
			return false;
		if (Double.doubleToLongBits(reimbAmount) != Double.doubleToLongBits(other.reimbAmount))
			return false;
		if (reimbAuthorId != other.reimbAuthorId)
			return false;
		if (reimbDescription == null) {
			if (other.reimbDescription != null)
				return false;
		} else if (!reimbDescription.equals(other.reimbDescription))
			return false;
		if (reimbId != other.reimbId)
			return false;
		if (reimbReciept == null) {
			if (other.reimbReciept != null)
				return false;
		} else if (!reimbReciept.equals(other.reimbReciept))
			return false;
		if (reimbResolved == null) {
			if (other.reimbResolved != null)
				return false;
		} else if (!reimbResolved.equals(other.reimbResolved))
			return false;
		if (reimbResolverId != other.reimbResolverId)
			return false;
		if (reimbStatus == null) {
			if (other.reimbStatus != null)
				return false;
		} else if (!reimbStatus.equals(other.reimbStatus))
			return false;
		if (reimbSubmitted == null) {
			if (other.reimbSubmitted != null)
				return false;
		} else if (!reimbSubmitted.equals(other.reimbSubmitted))
			return false;
		if (reimbType != other.reimbType)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Reimbursement [reimbId=" + reimbId + ", reimbAmount=" + reimbAmount + ", reimbDescription="
				+ reimbDescription + ", reimbReciept=" + reimbReciept + ", reimbAuthorId=" + reimbAuthorId
				+ ", reimbResolverId=" + reimbResolverId + ", reimbStatusId=" + reimbStatus+ ", reimbType="
				+ reimbType + ", reimbSubmitted=" + reimbSubmitted + ", reimbResolved=" + reimbResolved
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}




	


}
