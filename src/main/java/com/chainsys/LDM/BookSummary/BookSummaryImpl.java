package com.chainsys.LDM.BookSummary;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.LDM.SendMail.SendMail;

public class BookSummaryImpl implements BookSummaryDAO {
	public boolean checkBookStatus(long fg) throws Exception {
		String sql1 = "select book_name from booklist where ISBN = ? and book_status = 'Available'";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sql1);
		stmt.setLong(1,fg);	
		ResultSet row = stmt.executeQuery();
		if (row.next())
		{
			return true;
		}
		else {
		return false;
		}
		
	}
	public void addBookInfo(BookSummary BS) throws Exception {
		Connection con = TestConnection.getConnection();
		String sql = "insert into book_summary(student_id,ISBN,borrowed_date,due_date,catagory)"
				+ " values(?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, BS.getStudentId());	
		stmt.setLong(2, BS.getISBN());
		Date bw =Date.valueOf(BS.getBorrowedDate());
		stmt.setDate(3, bw);
		java.sql.Date dd = java.sql.Date.valueOf(BS.getDueDate());
		stmt.setDate(4, dd);
		stmt.setString(5, BS.getCategory());
		int row = stmt.executeUpdate();
		System.out.println(row);
		if(row == 1) {
			String sql1 = "update booklist set book_status = 'Notavailable' where ISBN = ?";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setLong(1, BS.getISBN());
			int row1 = stmt1.executeUpdate();
			 System.out.println(row1);
			 System.out.println(sql1);
			 
			 String sql0 = "Select  mail_id from student where student_id=? ";
				PreparedStatement stmt0 = con.prepareStatement(sql0);
				stmt0.setInt(1, BS.getStudentId());
				ResultSet rs = stmt0.executeQuery();
				String mail;
				if(rs.next()) {
					mail = rs.getString("mail_id");
					SendMail.chinlib(mail,BS.getISBN());
				}
				 System.out.println(sql0);
		}
		con.close();

	}




public List<BookSummary> onParticularDate(LocalDate borrowedDate) throws Exception {
	
	String sql6 = "select student_id,ISBN from book_summary where borrowed_date = ?";
	Connection con = TestConnection.getConnection();
	PreparedStatement pst1 = con.prepareStatement(sql6);
	Date bw = Date.valueOf(borrowedDate);
	pst1.setDate(1, bw);
	ResultSet rs=pst1.executeQuery();
	List<BookSummary> li=new ArrayList<BookSummary>();
	while (rs.next()) {
		BookSummary BS= new BookSummary();
		int Id=rs.getInt("student_id");
		BS.setstudentId(Id);
		BS.setISBN(rs.getLong("ISBN"));
		li.add(BS);
	}
	if(li.size() >0) {
	for (BookSummary bookSummary : li) {
		System.out.println(bookSummary);
	}}
	else {
		System.out.println("No book is Taken On "+borrowedDate);
	}
	return li;
}

	}