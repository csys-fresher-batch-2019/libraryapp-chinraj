package com.chainsys.LDM.BookList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Logger.Logger;

public class BookListImpl implements BookListDAO {
	Logger logger = Logger.getInstance();

	
	public void addBooks(BookList books) {
		String sqlinsert = "insert into booklist(ISBN,book_name,pages,author_name,publication,released_date,price,book_status,rack_no) values (?,?,?,?,?,?,?,?,?)";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setLong(1, books.getISBN());
			
				stmt.setString(2, books.getBookName());
				stmt.setInt(3, books.getPages());
				stmt.setString(4, books.getAuthorName());
				stmt.setString(5, books.getPublication());
				Date bw = Date.valueOf(books.getReleasedDate());
				stmt.setDate(6, bw);
				stmt.setInt(7, books.getPrice());
				stmt.setString(8, books.getBookStatus());
				stmt.setInt(9, books.getRackNo());
				int rows = stmt.executeUpdate();
				System.out.println(rows);
			}
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public java.util.List<BookList> viewBooks() throws Exception {

		String sqlinsert = "Select * from Booklist ";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		List<BookList> list = new ArrayList<BookList>();
		try(ResultSet rs = stmt.executeQuery();){
		while (rs.next()) {
			System.out.println(list);
			BookList b = new BookList();
			b.setISBN(rs.getLong("ISBN"));
			b.setBookName(rs.getString("book_name"));
			b.setAuthorName(rs.getString("author_name"));
			b.setPublication(rs.getString("publication"));
			list.add(b);
	
		}	return list;
		}
		}
	public void removeBooks(BookList book3) throws Exception {
		String sqlinsert = "delete booklist where ISBN=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		stmt.setLong(1, book3.getISBN());
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
			
			String c = rs.getString("book_name");
			int d = rs.getInt("pages");
			String e = rs.getString("author_name");
			String f = rs.getString("publication");
			Date g = rs.getDate("released_date");
			// LocalDate date = g.toLocalDate();
			int h = rs.getInt("price");
			String i = rs.getString("book_status");
			int j = rs.getInt("rack_no");

			bb.setISBN(a);
						bb.setBookName(c);
			bb.setPages(d);
			bb.setAuthorName(e);
			bb.setPublication(f);
			bb.setReleasedDate(g.toLocalDate());
			bb.setPrice(h);
			bb.setBookStatus(i);
			bb.setRackNo(j);
			obj1.add(bb);
		}
		return obj1;

	}

	public void SortBy() throws Exception {

	}
}
