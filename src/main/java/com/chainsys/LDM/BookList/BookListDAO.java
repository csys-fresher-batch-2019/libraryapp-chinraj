package com.chainsys.LDM.BookList;

import java.util.ArrayList;

public interface BookListDAO {
	
void addBooks(BookList books)throws Exception;

void removeBooks(BookList ISBN) throws Exception;
public java.util.List<BookList> viewBooks() throws Exception;
public ArrayList<BookList> List() throws Exception ;
}