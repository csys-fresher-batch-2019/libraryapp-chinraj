package com.chainsys.ldm.bookList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import logger.Logger;

public class BookListImpl implements BookListDAO {
	Logger logger = Logger.getInstance();

	public int addBooks(BookList books) {
		int rows=0;
		String sqlinsert = "insert into booklist(ISBN,book_name,pages,author_name,publication,released_date,price,rack_no) values (?,?,?,?,?,?,?,?)";
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

				stmt.setInt(8, books.getRackNo());
				rows = stmt.executeUpdate();
				logger.info(rows);
			}
		} catch (Exception e) {
			logger.error(e);
		}
		return rows;
	}

	public java.util.List<BookList> viewBooks()  {
		List<BookList> list=null;
		
		String sqlinsert = "Select * from Booklist ";
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {

				try (ResultSet rs = stmt.executeQuery();) {
					list= new ArrayList<BookList>();
				
					while (rs.next()) {
						BookList b = new BookList();	
						b.setISBN(rs.getLong("ISBN"));
						b.setBookName(rs.getString("book_name"));
						b.setAuthorName(rs.getString("author_name"));
						b.setPublication(rs.getString("publication"));
						list.add(b);
					}
					
						
					}

				}

			
			
		} catch (Exception e) {
			logger.error(e);
		}
		return list;
	}

	public int removeBooks(BookList isbn) {
		String sqlinsert = "delete booklist where ISBN=?";
		int row=0;
		try (Connection con = TestConnection.getConnection();) {
			try (PreparedStatement stmt = con.prepareStatement(sqlinsert);) {
				stmt.setLong(1, isbn.getISBN());
				row = stmt.executeUpdate();
				logger.info(sqlinsert);
				logger.info(row);
				if (row != 1) {
					logger.info("\nNo book is available on" + isbn.getISBN());
				}
			}
		} catch (Exception e) {

			logger.error(e);
		}
		return row;
	}

	public ArrayList<BookList> list() {

		ArrayList<BookList> obj1 = new ArrayList<BookList>();
		String sqlinsert = "Select * from booklist";
		try (Connection con = TestConnection.getConnection();) {
			try (Statement stmt = con.createStatement();) {
				try (ResultSet rs = stmt.executeQuery(sqlinsert);) {

					logger.info(sqlinsert);

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

				}
			}
		} catch (Exception e) {
			logger.error(e);

		}
		return obj1;
	}

}
