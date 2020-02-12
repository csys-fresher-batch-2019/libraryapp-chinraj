package com.chainsys.ldm.fines;

public class FinesInfo {

	private int studentId;
	private long iSBN;
	private int finePerDay;
	private int noOfExtraDays;
	private int fines;

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public long getISBN() {
		return iSBN;
	}

	public void setISBN(long iSBN) {
		this.iSBN = iSBN;
	}

	public int getFinePerDay() {
		return finePerDay;
	}

	public void setFinePerDay(int finePerDay) {
		this.finePerDay = finePerDay;
	}

	public int getNoOfExtraDays() {
		return noOfExtraDays;
	}

	public void setNoOfExtraDays(int noOfExtraDays) {
		this.noOfExtraDays = noOfExtraDays;
	}

	public int getFines() {
		return fines;
	}

	public void setFines(int fines) {
		this.fines = fines;
	}

}
