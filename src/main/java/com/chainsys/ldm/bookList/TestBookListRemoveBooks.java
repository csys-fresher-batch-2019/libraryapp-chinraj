package com.chainsys.ldm.bookList;

import java.util.Scanner;

public class TestBookListRemoveBooks {

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		BookList b = new BookList();
		BookListImpl obj = new BookListImpl();
		System.out.println(" ISBN to be removed :");
		b.setISBN(s.nextLong());
	   obj.removeBooks(b);
		s.close();
	}
}
