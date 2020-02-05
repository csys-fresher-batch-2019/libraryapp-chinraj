package com.chainsys.LDM.BookList;

import java.util.ArrayList;

public class TestBookListViewBooks {
	public static void main(String[] args) throws Exception {
		BookList Book3 = new BookList();
		BookListImpl obj = new BookListImpl();
		System.out.println(" BookList  :");
		ArrayList<String> in = new ArrayList<String>();
	   in = obj.viewBooks();
	   //System.out.println(in);
	   //System.out.println("hello");
	}
}
