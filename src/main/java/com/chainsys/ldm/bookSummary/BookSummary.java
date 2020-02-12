package com.chainsys.ldm.bookSummary;
import java.time.LocalDate;

public class BookSummary {

			 public int getStudentId() {
		return studentId;
	}
	public long getISBN() {
		return isbn;
	}

	public void setISBN(long iSBN) {
		this.isbn = iSBN;
	}


	public LocalDate getBorrowedDate() {
		return borrowedDate;
	}

	public void setBorrowedDate(LocalDate borrowedDate) {
		this.borrowedDate = borrowedDate;
	}




	public LocalDate getDueDate() {
		return dueDate;
	}




	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}




	public LocalDate getReturnDate() {
		return returnDate;
	}




	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}




	public int getRenewalCount() {
		return renewalCount;
	}




	public void setRenewalCount(int renewalCount) {
		this.renewalCount = renewalCount;
	}




	public String getCategory() {
		return category;
	}




	public void setCategory(String category) {
		this.category = category;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}




			private int  studentId;
			  private long isbn;
			  private LocalDate borrowedDate;
			  private LocalDate dueDate;
			  private LocalDate returnDate;
			  private int renewalCount;
			  private String category;
			private String status;
			 
		public void setstudentId(int studentId) {
		
		if(studentId<0) {
			throw new IllegalArgumentException("Invalid id");
			
		}
	this.studentId = studentId;
		}
		
		@Override
		public String toString() {
			return "BookSummary [studentId=" + studentId + ", ISBN=" + isbn + "]";
		}


		}


		

