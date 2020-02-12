package com.chainsys.ldm.bookList;

import java.util.ArrayList;

public interface BookListDAO {
	
void addBooks(BookList books);

void removeBooks(BookList ISBN);
public java.util.List<BookList> viewBooks();
public ArrayList<BookList> list();
}