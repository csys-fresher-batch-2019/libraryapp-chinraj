package com.chainsys.ldm.bookList;

import java.util.ArrayList;
import java.util.List;

public class TestBookListViewBooks {
	public static void main(String[] args) throws Exception {
		
		BookListImpl obj = new BookListImpl();
		System.out.println(" BookList  :");
		List<BookList> li = new ArrayList<BookList>();
	   li = obj.viewBooks();
	   for(Object object:li)
		   System.out.println(object);
	 
	}
}
