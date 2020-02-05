package com.chainsys.LDM.BookSummary;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "insert into book_summary(student_id,ISBN,borrowed_date,due_date,catagory, books_taken)"
				+ " values(?,?,?,?,?,?)";
		System.out.println(sql);
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setInt(1, BS.getstudentId());
		//stmt.setString(2, BS.studentName);
		//stmt.setString(3, BS.deptName);
		stmt.setLong(2, BS.ISBN);
		Date bw =Date.valueOf(BS.borrowedDate);
		stmt.setDate(3, bw);
		java.sql.Date dd = java.sql.Date.valueOf(BS.dueDate);
		stmt.setDate(4, dd);

		stmt.setString(5, BS.category);
		stmt.setInt(6, BS.booksTaken);

		int row = stmt.executeUpdate();
		System.out.println(row);
		if(row == 1) {
			String sql1 = "update booklist set book_status = 'Notavailable' where ISBN = ?";
			PreparedStatement stmt1 = con.prepareStatement(sql1);
			stmt1.setLong(1, BS.ISBN);
			int row1 = stmt1.executeUpdate();
			 System.out.println(row1);
			 System.out.println(sql1);
	
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
     //BS.studentName=rs.getString("student_name");
		int Id=rs.getInt("student_id");
		BS.setstudentId(Id);
	 //BS.deptName=rs.getString("dept_name");
		BS.ISBN=rs.getLong("ISBN");
	
		
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
public void renewal(BookSummary BS) throws Exception {
	
	String sql3 ="update book_summary set renewal_date = ?, due_date =?	where ISBN =?";    
	Connection con = TestConnection.getConnection();
	System.out.println(sql3);
	PreparedStatement stmt = con.prepareStatement(sql3);
	Date bw =Date.valueOf(BS.renewalDate);
	stmt.setDate(1, bw);
	java.sql.Date dd = java.sql.Date.valueOf(BS.dueDate);
	stmt.setDate(2, dd);
	stmt.setLong(3, BS.ISBN);
	int row = stmt.executeUpdate();
	System.out.println(row);
	

	
	
	
}
}


	




