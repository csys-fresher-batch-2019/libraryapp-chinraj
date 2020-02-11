package com.chainsys.LDM.BookList;

import java.util.Scanner;

public class TestBookListRemoveBooks {
	
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		
		BookList Book3 = new BookList();
		BookListImpl obj = new BookListImpl();
		System.out.println(" ISBN to be removed :");
	Book3.setISBN(s.nextLong());
	obj.removeBooks(Book3);
	s.close();
}
}
