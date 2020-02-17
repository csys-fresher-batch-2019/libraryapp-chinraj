package com.chainsys.ldm.bookList;
import java.util.ArrayList;
public interface BookListDAO {
int addBooks(BookList books);
int removeBooks(BookList isbn);
public java.util.List<BookList> viewBooks();
public ArrayList<BookList> list();
}