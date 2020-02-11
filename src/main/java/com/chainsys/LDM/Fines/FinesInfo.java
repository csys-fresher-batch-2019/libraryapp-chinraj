package com.chainsys.LDM.Fines;

public class FinesInfo {

	private int studentId;
	private long ISBN;
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
		return ISBN;
	}

	public void setISBN(long iSBN) {
		ISBN = iSBN;
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
