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
		List<BookList> list = new ArrayList<BookList>();
		String sqlinsert = "Select * from Booklist ";
		try(Connection con = TestConnection.getConnection();){
		try(PreparedStatement stmt = con.prepareStatement(sqlinsert);){
		
		try(ResultSet rs = stmt.executeQuery();){
		while (rs.next()) {
			System.out.println(list);
			BookList b = new BookList();
			b.setISBN(rs.getLong("ISBN"));
			b.setBookName(rs.getString("book_name"));
			b.setAuthorName(rs.getString("author_name"));
			b.setPublication(rs.getString("publication"));
			list.add(b);
	
		}	
		}}}
		catch(Exception e)
		{	
			logger.error(e);
		}
		return list;
		}
	public void removeBooks(BookList book3) throws Exception {
		String sqlinsert = "delete booklist where ISBN=?";
		try(Connection con = TestConnection.getConnection();){
		try(PreparedStatement stmt = con.prepareStatement(sqlinsert);){
		stmt.setLong(1, book3.getISBN());
		int row =stmt.executeUpdate();
		System.out.println(sqlinsert);
		System.out.println(row);
		if(row!=1) {
			System.out.println("\nNo book is available on"+ book3.getISBN());
		}
		
	}}
	catch(Exception e)
	{
		
		logger.error(e);
	}
		}
	public ArrayList<BookList> List() throws Exception {

		ArrayList<BookList> obj1 = new ArrayList<BookList>();
		String sqlinsert = "Select * from booklist";
		try(Connection con = TestConnection.getConnection();){
		try(Statement stmt = con.createStatement();){
		try(ResultSet rs = stmt.executeQuery(sqlinsert);){

		System.out.println(sqlinsert);

		BookList bb = new BookList();
		

		while (rs.next()) {
			long a = rs.getLong("ISBN");
			
			String c = rs.getString("book_name");
			int d = rs.getInt("pages");
			String e = rs.getString("author_name");
			String f = rs.getString("publication");
			Date g = rs.getDate("released_date");
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
	
		}}}
		catch(Exception e)
		{		
		logger.error(e);
		
	}
		return obj1;
}
	
	
}
