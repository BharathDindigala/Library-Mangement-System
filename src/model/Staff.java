package model;

import java.sql.Date;

public class Staff {
	private int staffId;
	private String fullName;
	private String designation;
	private long mobile;
	private String email;
	private String branch;
	private Date joinDate;

	// Constructor with parameters
	public Staff(int staffId, String fullName, String designation, long mobile, String email, String branch,
			Date joinDate) {
		super();
		this.staffId = staffId;
		this.fullName = fullName;
		this.designation = designation;
		this.mobile = mobile;
		this.email = email;
		this.branch = branch;
		this.joinDate = joinDate;
	}

	// Default constructor
	public Staff() {
		super();
	}

	// Getters and setters for each field
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
}
