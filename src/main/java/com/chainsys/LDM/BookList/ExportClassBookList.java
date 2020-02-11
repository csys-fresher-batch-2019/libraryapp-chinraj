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
			String Line = aa.getAuthorName() + "," + aa.getISBN() + "," + aa.getBookName() + "," + aa.getPages() + "," + aa.getPrice() + ","
					+ aa.getBookStatus() + "," + aa.getRackNo() + "," + aa.getPublication() + "," + aa.getReleasedDate();
			Filess = Filess + Line + "\n";
		}

		Path path = Paths.get("D:\\Vignesh.txt");
		Files.write(path, Filess.getBytes(), StandardOpenOption.APPEND);
	}

}
