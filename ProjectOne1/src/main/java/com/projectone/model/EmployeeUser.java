package com.projectone.model;

public class EmployeeUser {
	
	

	private int ersUsersId;
	private String ersUserName;
	private String ersPassword;
	private String ersUserFirstName;
	private String ersUserLastName;
	private String ersUserEmail;
	private EmployeeUserRole ersEmployeeRole;
	
	public EmployeeUser() {
		super();
	}
	
	public EmployeeUser(int ersUsersId, String ersUserName, String ersUserFirstName, String ersUserLastName,
			EmployeeUserRole ersEmployeeRole) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUserFirstName = ersUserFirstName;
		this.ersUserLastName = ersUserLastName;
		this.ersEmployeeRole = ersEmployeeRole;
		this.ersUserName = ersUserName;
	}
	
	public EmployeeUser(int ersUsersId, String ersUserName, String ersPassword, String ersUserFirstName,
			String ersUserLastName, String ersUserEmail, EmployeeUserRole ersEmployeeRole) {
		super();
		this.ersUsersId = ersUsersId;
		this.ersUserName = ersUserName;
		this.ersPassword = ersPassword;
		this.ersUserFirstName = ersUserFirstName;
		this.ersUserLastName = ersUserLastName;
		this.ersUserEmail = ersUserEmail;
		this.ersEmployeeRole = ersEmployeeRole;
	}

	public int getErsUsersId() {
		return ersUsersId;
	}

	public void setErsUsersId(int ersUsersId) {
		this.ersUsersId = ersUsersId;
	}

	public String getErsUserName() {
		return ersUserName;
	}

	public void setErsUserName(String ersUserName) {
		this.ersUserName = ersUserName;
	}

	public String getErsPassword() {
		return ersPassword;
	}

	public void setErsPassword(String ersPassword) {
		this.ersPassword = ersPassword;
	}

	public String getErsUserFirstName() {
		return ersUserFirstName;
	}

	public void setErsUserFirstName(String ersUserFirstName) {
		this.ersUserFirstName = ersUserFirstName;
	}

	public String getErsUserLastName() {
		return ersUserLastName;
	}

	public void setErsUserLastName(String ersUserLastName) {
		this.ersUserLastName = ersUserLastName;
	}

	public String getErsUserEmail() {
		return ersUserEmail;
	}

	public void setErsUserEmail(String ersUserEmail) {
		this.ersUserEmail = ersUserEmail;
	}

	public EmployeeUserRole getErsEmployeeRole() {
		return ersEmployeeRole;
	}

	public void setErsEmployeeRole(EmployeeUserRole ersEmployeeRole) {
		this.ersEmployeeRole = ersEmployeeRole;
	}

	@Override
	public String toString() {
		return "EmployeeUser [ersUsersId=" + ersUsersId + ", ersUserName=" + ersUserName + ", ersPassword="
				+ ersPassword + ", ersUserFirstName=" + ersUserFirstName + ", ersUserLastName=" + ersUserLastName
				+ ", ersUserEmail=" + ersUserEmail + ", ersEmployeeRole=" + ersEmployeeRole + ", getErsUsersId()="
				+ getErsUsersId() + ", getErsUserName()=" + getErsUserName() + ", getErsPassword()=" + getErsPassword()
				+ ", getErsUserFirstName()=" + getErsUserFirstName() + ", getErsUserLastName()=" + getErsUserLastName()
				+ ", getErsUserEmail()=" + getErsUserEmail() + ", getErsEmployeeRole()=" + getErsEmployeeRole()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ersEmployeeRole == null) ? 0 : ersEmployeeRole.hashCode());
		result = prime * result + ((ersPassword == null) ? 0 : ersPassword.hashCode());
		result = prime * result + ((ersUserEmail == null) ? 0 : ersUserEmail.hashCode());
		result = prime * result + ((ersUserFirstName == null) ? 0 : ersUserFirstName.hashCode());
		result = prime * result + ((ersUserLastName == null) ? 0 : ersUserLastName.hashCode());
		result = prime * result + ((ersUserName == null) ? 0 : ersUserName.hashCode());
		result = prime * result + ersUsersId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeUser other = (EmployeeUser) obj;
		if (ersEmployeeRole == null) {
			if (other.ersEmployeeRole != null)
				return false;
		} else if (!ersEmployeeRole.equals(other.ersEmployeeRole))
			return false;
		if (ersPassword == null) {
			if (other.ersPassword != null)
				return false;
		} else if (!ersPassword.equals(other.ersPassword))
			return false;
		if (ersUserEmail == null) {
			if (other.ersUserEmail != null)
				return false;
		} else if (!ersUserEmail.equals(other.ersUserEmail))
			return false;
		if (ersUserFirstName == null) {
			if (other.ersUserFirstName != null)
				return false;
		} else if (!ersUserFirstName.equals(other.ersUserFirstName))
			return false;
		if (ersUserLastName == null) {
			if (other.ersUserLastName != null)
				return false;
		} else if (!ersUserLastName.equals(other.ersUserLastName))
			return false;
		if (ersUserName == null) {
			if (other.ersUserName != null)
				return false;
		} else if (!ersUserName.equals(other.ersUserName))
			return false;
		if (ersUsersId != other.ersUsersId)
			return false;
		return true;
	}
}
