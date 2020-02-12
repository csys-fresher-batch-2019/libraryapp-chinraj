package com.chainsys.ldm.bookList;

import java.time.LocalDate;
import java.util.Scanner;

import com.chainsys.ldm.bookList.BookList;
import com.chainsys.ldm.bookList.BookListImpl;

public class TestBooListAddBooks {

	public static void main(String[] args) throws Exception {
		
		Scanner s = new Scanner(System.in);
		BookList List1 = new BookList();
		BookListImpl Book1 = new BookListImpl();
		System.out.println("Enter ISBN :");
		List1.setISBN(s.nextLong());
		System.out.println("Enter BookName :");
		List1.setBookName(s.next());
		System.out.println("Enter No of pages :");
		List1.setPages(s.nextInt());
		System.out.println("Enter Authorname :");
		List1.setAuthorName(s.next());
		System.out.println("Enter Publications :");
		List1.setPublication(s.next());
		System.out.println("Enter releasedDate:");
		String date1 = s.next();
		List1.setReleasedDate(LocalDate.parse(date1));
		System.out.println("Enter price :");
		List1.setPrice(s.nextInt());
	
		System.out.println("Enter rackNo :");
		List1.setRackNo(s.nextInt());

		Book1.addBooks(List1);
		s.close();

	}

}
