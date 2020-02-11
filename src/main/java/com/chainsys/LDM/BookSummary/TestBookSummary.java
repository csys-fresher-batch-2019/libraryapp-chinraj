package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.util.Scanner;

public class TestBookSummary {
	 static Scanner n = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		

		System.out.println("\n 1.BookInfo\n 2.ParticularDAte");
		
			
		BookSummaryImpl BK = new BookSummaryImpl();
		BookSummary obj = new BookSummary();
	

		int n1 = n.nextInt();
		switch (n1) {

		case 1: {
			System.out.println("Enter ISBN:");
			long fg = n.nextLong();
			obj.setISBN(fg);
			if(BK.checkBookStatus(fg)) {
			System.out.println("Enter Student Id:");
			obj.setstudentId(n.nextInt());
		
			System.out.println("Enter borrowedDate:");
			String date = n.next();
			obj.setBorrowedDate(LocalDate.parse(date));
			System.out.println("Enter dueDate:");
			String date1 = n.next();

			obj.setDueDate(LocalDate.parse(date1));
			System.out.println("Enter ReturnDate:");
			obj.setReturnDate(LocalDate.now());
			System.out.println("Enter Catogory:");
			obj.setCategory(n.next());
			
			System.out.println("Enter status:");
			
			obj.setStatus(n.next());
	
			BK.addBookInfo(obj);
			}
			else
			{
				System.out.println("book is Not Available");
			}
		}
			break;
		case 2: {
			System.out.println("Enter borrowedDate");
			String date = n.next();
			LocalDate d = LocalDate.parse(date);
			BK.onParticularDate(d);
		}
		
		break;
		
	
		}
			
		}
	
}