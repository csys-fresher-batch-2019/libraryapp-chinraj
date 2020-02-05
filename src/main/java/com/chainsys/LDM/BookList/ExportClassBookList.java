package com.chainsys.LDM.BookList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class ExportClassBookList {
	public static void main(String[] args) throws Exception {
		BookListImpl imp = new BookListImpl();
		ArrayList<BookList> e = imp.List();
		String Filess = "";
		for (BookList aa : e) {
			String Line = aa.authorName + "," + aa.ISBN + "," + aa.bookName + "," + aa.pages + "," + aa.price + ","
					+ aa.bookStatus + "," + aa.rackNo + "," + aa.bookId + "," + aa.publication + "," + aa.releasedDate;

			Filess = Filess + Line + "\n";
		}

		Path path = Paths.get("D:\\Vignesh.txt");

		Files.write(path, Filess.getBytes(), StandardOpenOption.APPEND);
	}

}
