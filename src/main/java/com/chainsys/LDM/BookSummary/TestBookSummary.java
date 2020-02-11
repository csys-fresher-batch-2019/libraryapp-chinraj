package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.util.Scanner;

import Logger.Logger;


public class TestBookSummary {
	
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		
	logger.info("\n 1.BookInfo\n 2.ParticularDAte");

		Scanner n = new Scanner(System.in);

		BookSummaryImpl BK = new BookSummaryImpl();
		BookSummary obj = new BookSummary();
		int n1 = n.nextInt();
		switch (n1) {

		case 1: {  
			System.out.println("Enter ISBN:");
			long fg = n.nextLong();
			obj.setISBN(fg);
			if (BK.checkBookStatus(fg)) {
				 logger.info("Enter Student Id:");
				obj.setstudentId(n.nextInt());

				 logger.info("Enter borrowedDate:");
				String date = n.next();
				obj.setBorrowedDate(LocalDate.parse(date));
				 logger.info("Enter dueDate:");
				String date1 = n.next();

				obj.setDueDate(LocalDate.parse(date1));
				 logger.info("Enter ReturnDate:");
				obj.setReturnDate(LocalDate.now());
				 logger.info("Enter Catogory:");
				obj.setCategory(n.next());

           logger.info("Enter status:");

				obj.setStatus(n.next());

				BK.addBookInfo(obj);

			} else {
				 logger.info("book is Not Available");
			}

		}
			break;
		case 2: {
			 logger.info("Enter borrowedDate");
			String date = n.next();
			LocalDate d = LocalDate.parse(date);
			BK.onParticularDate(d);
		}

			break;

		}
		n.close();
	}

}