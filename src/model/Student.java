package model;

public class Student {
	private int rollno;
	private String fullName;
	private String address;
	private long mobile;
	private String email;
	private String branch;
	private String academicYear;

	public Student(int rollno, String fullName, String address, long mobile, String email, String branch,
			String academiYear) {
		super();
		this.rollno = rollno;
		this.fullName = fullName;
		this.address = address;
		this.mobile = mobile;
		this.email = email;
		this.branch = branch;
		this.academicYear = academicYear;
	}

	public Student() {
		super();
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getAcademicYear() {
		return academicYear;
	}

	public void setAcademicYear(String academicYear) {
		this.academicYear = academicYear;
	}

}
