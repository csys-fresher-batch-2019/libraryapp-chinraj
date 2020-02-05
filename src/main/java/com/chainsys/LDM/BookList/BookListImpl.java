package com.chainsys.LDM.BookList;

import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookListImpl implements BookListDAO {

	public void addBooks(BookList books) throws Exception {
		String sqlinsert = "insert into booklist(ISBN,book_id,book_name,pages,author_name,publication,released_date,price,book_status,rack_no) values (?,?,?,?,?,?,?,?,?,?)";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		stmt.setLong(1, books.ISBN);
		stmt.setInt(2, books.bookId);
		stmt.setString(3, books.bookName);
		stmt.setInt(4, books.pages);
		stmt.setString(5, books.authorName);
		stmt.setString(6, books.publication);
		Date bw = Date.valueOf(books.releasedDate);
		stmt.setDate(7, bw);
		stmt.setInt(8, books.price);
		stmt.setString(9, books.bookStatus);
		stmt.setInt(10, books.rackNo);
		int rows = stmt.executeUpdate();
		System.out.println(rows);
	}

	public ArrayList<String> viewBooks() throws Exception {
		// TODO Auto-generated method stub

		String sqlinsert = "Select book_name, publication from Booklist ";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		ArrayList<String> out = new ArrayList<String>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			out.add(rs.getString("publication"));
			out.add(rs.getString("book_name"));
			

		}for (String string : out) {
			System.out.println(string);
		}
		// int row = stmt.executeUpdate();
		//System.out.println(sqlinsert);
		return out;
	}

	public void removeBooks(BookList book3) throws Exception {
		String sqlinsert = "delete booklist where ISBN=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		stmt.setLong(1, book3.ISBN);
		stmt.executeUpdate();
		System.out.println(sqlinsert);
	}


	public ArrayList<BookList> List() throws Exception {
		String sqlinsert = "Select * from booklist";
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sqlinsert);

		System.out.println(sqlinsert);

		BookList bb = new BookList();
		ArrayList<BookList> obj1 = new ArrayList<BookList>();

		while (rs.next()) {
			long a = rs.getLong("ISBN");
			int b = rs.getInt("book_id");
			String c = rs.getString("book_name");
			int d = rs.getInt("pages");
			String e = rs.getString("author_name");
			String f = rs.getString("publication");
			Date g=rs.getDate("released_date");
			LocalDate date = g.toLocalDate();
			int h = rs.getInt("price");
			String i = rs.getString("book_status");
			int j = rs.getInt("rack_no");

			bb.ISBN = a;
			bb.bookId = b;
			bb.bookName = c;
			bb.pages = d;
			bb.authorName = e;
			bb.publication = f;
         	bb.releasedDate = g.toLocalDate();
			bb.price = h;
			bb.bookStatus = i;
			bb.rackNo = j;
			obj1.add(bb);
		}
		return obj1;

	}

	public void SortBy() throws Exception {

		

	}
}



