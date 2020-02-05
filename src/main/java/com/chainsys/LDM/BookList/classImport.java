package com.chainsys.LDM.BookList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

public class classImport {
		public static void main(String[] args) throws Exception {
			Path path = Paths.get("D:\\Booklist.txt");
			List<String> l1 = Files.readAllLines(path);
			for(String line : l1) {
				String[] row = line.split(",");
				long ISBN = Long.parseLong(row[0]);
				int bookId = Integer.parseInt(row[1]);
				
				String bookName = row[2];
				int pages = Integer.parseInt(row[3]);
				String authorName = row[4];
				String publication = row[5];
			
				LocalDate releasedDate = LocalDate.parse(row[6]); 
				
				int price = Integer.parseInt(row[7]);
				String bookStatus= row[8];
				int rackNo =Integer.parseInt(row[9]);
			    int stock = Integer.parseInt(row[10]);
			
				
			
				BookList books = new BookList();
				books.ISBN = ISBN;
				books.bookId = bookId;
				books.bookName = bookName;
				books.pages = pages;
				books.authorName= authorName;
				books.publication= publication;
				books.releasedDate=releasedDate;
				books.price = price;
			    books.bookStatus=bookStatus;
			    books.rackNo = rackNo;	
			    books.stock=stock;
				BookListImpl method = new BookListImpl();
				method.addBooks(books);
				
			}
			
			
		}

	}


