package com.chainsys.ldm.bookList;

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
				
				
				String bookName = row[1];
				int pages = Integer.parseInt(row[2]);
				String authorName = row[3];
				String publication = row[4];
			
				LocalDate releasedDate = LocalDate.parse(row[5]); 
				
				int price = Integer.parseInt(row[6]);
				String bookStatus= row[7];
				int rackNo =Integer.parseInt(row[8]);
			  
			
				
			
				BookList books = new BookList();
				books.setISBN(ISBN);
				books.setBookName(bookName);
				books.setPages(pages);
				books.setAuthorName(authorName);
				books.setPublication(publication);
				books.setReleasedDate(releasedDate);
				books.setPrice(price);
			    books.setBookStatus(bookStatus);
			    books.setRackNo(rackNo);	
			    BookListImpl method = new BookListImpl();
				method.addBooks(books);
				
			}
			
			
		}

	}


