package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.util.Scanner;

public class TestBookSummary {
	public static void main(String[] args) throws Exception {
		// System.out.println("hello");

		System.out.println("\n 1.BookInfo\n 2.ParticularDAte\n 3.Renewal");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BookSummaryImpl BK = new BookSummaryImpl();
		BookSummary obj = new BookSummary();
		switch (n) {
		case 1: {
			System.out.println("Enter ISBN:");
			long fg = sc.nextLong();
			obj.ISBN = fg;
			if(BK.checkBookStatus(fg)) {
			System.out.println("Enter Student Id:");
			obj.setstudentId(sc.nextInt());
		
			System.out.println("Enter borrowedDate:");
			String date = sc.next();
			// SimpleDateFormat sd = new SimpleLocalDateFormat("dd-MM-yyyy");
			obj.borrowedDate = LocalDate.parse(date);
			System.out.println("Enter dueDate:");
			String date1 = sc.next();

			obj.dueDate = LocalDate.parse(date1);
			System.out.println("Enter ReturnDate:");
			obj.returnDate = LocalDate.now();
			System.out.println("Enter Catogory:");
			obj.category = sc.next();
			System.out.println("Enter booksTaken:");
			obj.booksTaken = sc.nextInt();
			System.out.println("Enter status:");
			obj.status = sc.next();
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
			String date = sc.next();
			LocalDate d = LocalDate.parse(date);
			BK.onParticularDate(d);

		}

		break;
		
		case 3 : {
			System.out.println("Enter renewalDate:");
			String date1 = sc.next();
			System.out.println("Enter dueDate:");
			String date2 = sc.next();
            System.out.println("Enter ISBN");
            obj.ISBN = sc.nextLong();
			obj.renewalDate = LocalDate.parse(date1);
			obj.dueDate = LocalDate.parse(date2);
			
			
			BK.renewal(obj);
		}
	
}}}