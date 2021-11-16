package com.jhj.biz.emp;

public class EmpVO {
	
	private int eno;
	private String ename;
	private String job;
	private String hiredate;
	private int sale;
	private int commission;
	private int deptno;

	public EmpVO() {
		// TODO Auto-generated constructor stub
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getHiredate() {
		return hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSale() {
		return sale;
	}

	public void setSale(int sale) {
		this.sale = sale;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return "EmpVO [eno=" + eno + ", ename=" + ename + ", job=" + job + ", hiredate=" + hiredate + ", sale=" + sale
				+ ", commission=" + commission + ", deptno=" + deptno + "]";
	}

}
