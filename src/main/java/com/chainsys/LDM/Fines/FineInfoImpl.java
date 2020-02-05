package com.chainsys.LDM.Fines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.chainsys.LDM.BookSummary.BookSummary;
import com.chainsys.LDM.BookSummary.TestConnection;

public class FineInfoImpl implements FineInfoDAO  {

public void AddFineInfo(FinesInfo FI) throws Exception {
	// TODO Auto-generated method stub
	String sqlinsert ="insert into fine_amount(student_id,ISBN,fines_per_day) values(?,?,?)";
    System.out.println(sqlinsert);
	Connection con = TestConnection.getConnection();
	PreparedStatement stmt = con.prepareStatement(sqlinsert);
	stmt.setInt(1, FI.studentId);
	stmt.setLong(2, FI.ISBN);
	stmt.setInt(3, FI.finePerDay);
	 int rows= stmt.executeUpdate();
		System.out.println("" + rows);
}
	//----------------------	
	
		
	//-----	--------

public void AddFineInfo1(FinesInfo FO) throws Exception {
	// TODO Auto-generated method stub
	Connection con = TestConnection.getConnection();
	
	String sql1 = " update fine_amount set no_of_extra_days = trunc(sysdate - (select due_date from book_summary where ISBN=? ))";
	PreparedStatement stmt4 = con.prepareStatement(sql1);
    stmt4.setLong(1,FO.ISBN);
	int row1 = stmt4.executeUpdate();
	System.out.println(row1);
	System.out.println(sql1);
}


			

public int TotalFinesAmt(FinesInfo FT) throws Exception {	
			Connection con = TestConnection.getConnection();
			
			String sql0 = "update fine_amount set fines=0, no_of_extra_days=0 where trunc(( sysdate-(select due_date from book_summary where ISBN=?)))<=0 ";
			PreparedStatement stm = con.prepareStatement(sql0);
			stm.setLong(1, FT.ISBN);
			int row = stm.executeUpdate();
			System.out.println(row);
			System.out.println(sql0);
				
		
		String sql5 = "  update fine_amount set fines= no_of_extra_days * fines_per_day where student_id= ? and ISBN=?";
		PreparedStatement s = con.prepareStatement(sql5);
		s.setInt(1, FT.studentId);
		s.setLong(2, FT.ISBN);
		int rowq = s.executeUpdate();
		System.out.println(rowq);
		System.out.println(sql5);
		return 0;
	
		
   //-----------
		

	}
public int FinePerStudent(int studentId, long ISBN) throws Exception {
			FinesInfo b= new FinesInfo();
			// TODO Auto-generated method stub
			String sql6 = "select fines from fine_amount where student_id = ? and ISBN = ?";
			Connection con = TestConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql6);
			pst.setInt(1, studentId);
			pst.setLong(2,ISBN );
			System.out.println(sql6);
			ResultSet rs = pst.executeQuery();
			
			//System.out.println("" + rs.next());
			if (rs.next()) {
					b.fines = rs.getInt(1);
	}
			System.out.println(b.fines);
			return b.fines;
		
			
		}

public int bookreturned(int studentId,long iSBN) throws Exception {
			// TODO Auto-generated method stub
			Connection con = TestConnection.getConnection();
			
			String sql3 = "update book_summary set books_taken=(books_taken-1),return_date= sysdate,status ='Returned' where student_id =? and ISBN = ?";
			PreparedStatement stmt = con.prepareStatement(sql3);
			stmt.setInt(1, studentId);
			stmt.setLong(2, iSBN);
			int row3 = stmt.executeUpdate();
			
			System.out.println(row3);
			System.out.println(sql3);

             //f(row3==1) {
			//String sql = "";
			//PreparedStatement stmt1 = con.prepareStatement(sql);
			//stmt1.setInt(1, ISBN);
			//int row = stmt1.executeUpdate();
			//System.out.println(row);
			
	

			String sql0 = "update booklist set book_status = 'Available' where ISBN = ?";
			PreparedStatement stmt5 = con.prepareStatement(sql0);
			
			stmt5.setLong(1, iSBN);
			int row4 = stmt5.executeUpdate();
			
			System.out.println(row4);
			System.out.println(sql0);
			return 1;
					}

public int PenalityForBookLost(int studentId, long ISBN) throws Exception{
	
	Connection con = TestConnection.getConnection();
	
	String sql3 = "update fine_amount set lost_penality = (select price from booklist where ISBN =?) where ISBN =?";
			
	PreparedStatement stmt = con.prepareStatement(sql3);
	stmt.setInt(1, studentId);
	stmt.setLong(2, ISBN);
	int row3 = stmt.executeUpdate();
	System.out.println(row3);
	System.out.println(sql3);
	return row3;



}
}












