package com.chainsys.LDM.BookList;

import java.util.ArrayList;
import java.util.List;

public class TestBookListViewBooks {
	public static void main(String[] args) throws Exception {
		//BookList Book3 = new BookList();
		BookListImpl obj = new BookListImpl();
		System.out.println(" BookList  :");
		List<BookList> li = new ArrayList<BookList>();
	   li = obj.viewBooks();
	   System.out.println(li);
	   //System.out.println("hello");
	}
}
