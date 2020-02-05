package com.chainsys.LDM.BookSummary;



import java.time.LocalDate;

public class BookSummary {

			 private int  studentId;
			  public long ISBN;
			  public LocalDate borrowedDate;
			  public LocalDate dueDate;
			  public LocalDate returnDate;
			  public LocalDate renewalDate;
			  public String category;
			  public int booksTaken;
			public String status;
			 
		public void setstudentId(int studentId) {
		
		if(studentId<0) {
			throw new IllegalArgumentException("Invalid id");
			
		}
	this.studentId = studentId;
		}
		
		


		@Override
		public String toString() {
			return "BookSummary [studentId=" + studentId + ", ISBN=" + ISBN + "]";
		}




		public int getstudentId() {
			return studentId;
		}
		}


		

