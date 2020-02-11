package com.chainsys.LDM.Fines;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.chainsys.LDM.BookSummary.TestConnection;

import Logger.Logger;

public class FineInfoImpl implements FineInfoDAO  {

public void AddFineInfo(FinesInfo FI) throws Exception {	
	Logger logger = Logger.getInstance();
	String sqlinsert ="insert into fine_amount(student_id,ISBN,fines_per_day) values(?,?,?)";
    logger.info(sqlinsert);
	Connection con = TestConnection.getConnection();
	PreparedStatement stmt = con.prepareStatement(sqlinsert);
	stmt.setInt(1, FI.studentId);
	stmt.setLong(2, FI.ISBN);
	stmt.setInt(3, FI.finePerDay);
	 int rows= stmt.executeUpdate();
		logger.info("" + rows);
}

public void AddFineInfo1(FinesInfo FO) throws Exception {
    Logger logger = Logger.getInstance();
	Connection con = TestConnection.getConnection();
	String sql1 = " update fine_amount set no_of_extra_days = trunc(sysdate - (select due_date from book_summary where ISBN=? ))";
	PreparedStatement stmt4 = con.prepareStatement(sql1);
    stmt4.setLong(1,FO.ISBN);
	int row1 = stmt4.executeUpdate();
	logger.info(row1);
	logger.info(sql1);
}


			

public int TotalFinesAmt(FinesInfo FT) throws Exception {	
	Logger logger = Logger.getInstance();
			Connection con = TestConnection.getConnection();
			
			String sql0 = "update fine_amount set fines=0, no_of_extra_days=0 where trunc(( sysdate-(select due_date from book_summary where ISBN=?)))<=0 ";
			PreparedStatement stm = con.prepareStatement(sql0);
			stm.setLong(1, FT.ISBN);
			int row = stm.executeUpdate();
			logger.info(row);
			logger.info(sql0);
				
		
		String sql5 = "  update fine_amount set fines= no_of_extra_days * fines_per_day where student_id= ? and ISBN=?";
		PreparedStatement s = con.prepareStatement(sql5);
		s.setInt(1, FT.studentId);
		s.setLong(2, FT.ISBN);
		int rowq = s.executeUpdate();
		logger.info(rowq);
		logger.info(sql5);
		return 0;
	
		
   //-----------
		

	}
public int FinePerStudent(int studentId, long ISBN) throws Exception {
	Logger logger = Logger.getInstance();
			FinesInfo b= new FinesInfo();
			// TODO Auto-generated method stub
			String sql6 = "select fines from fine_amount where student_id = ? and ISBN = ?";
			Connection con = TestConnection.getConnection();
			PreparedStatement pst = con.prepareStatement(sql6);
			pst.setInt(1, studentId);
			pst.setLong(2,ISBN );
			logger.info(sql6);
			ResultSet rs = pst.executeQuery();
			
			//logger.info("" + rs.next());
			if (rs.next()) {
				
					b.fines = rs.getInt(1);
					if(b.fines==0) {
						
					}
	}
			
			logger.info(b.fines);
			return b.fines;
		
			
		}

public int bookreturned(int studentId,long iSBN) throws Exception {
			// TODO Auto-generated method stub
	Logger logger = Logger.getInstance();
			Connection con = TestConnection.getConnection();
			
			String sql3 = "update book_summary set status ='Returned',return_date=sysdate where student_id =? and ISBN = ?";
			PreparedStatement stmt = con.prepareStatement(sql3);
			stmt.setInt(1, studentId);
			stmt.setLong(2, iSBN);
			int row3 = stmt.executeUpdate();
			
			logger.info(row3);
			logger.info(sql3);

    		
			String sql0 = "update booklist set book_status = 'Available' where ISBN = ?";
			PreparedStatement stmt5 = con.prepareStatement(sql0);
			
			stmt5.setLong(1, iSBN);
			int row4 = stmt5.executeUpdate();
			
			logger.info(row4);
			logger.info(sql0);
			return 1;
					}

public int PenalityForBookLost(int studentId, long ISBN) throws Exception{
	Logger logger = Logger.getInstance();
	Connection con = TestConnection.getConnection();
	
	String sql3 = "update fine_amount set lost_penality = (select price from booklist where ISBN =?) where ISBN =?";

	PreparedStatement stmt = con.prepareStatement(sql3);
	stmt.setLong(1, ISBN);
	stmt.setLong(2, ISBN);
	int row3 = stmt.executeUpdate();
	logger.info(row3);
	logger.info(sql3);
	
	String sql ="Select lost_penality from fine_amount where ISBN=?";
	PreparedStatement stmt1= con.prepareStatement(sql);
	stmt1.setLong(1, ISBN);
	ResultSet row = stmt1.executeQuery();
	while(row.next()) {
		int status = row.getInt("lost_penality");
		System.out.println(status);
	logger.info(row);
	logger.info(sql);
	}
	return row3;
	
	


}
public void renewal(int studentId ,Long isbn) throws Exception{

	Logger logger = Logger.getInstance();
	Connection con = TestConnection.getConnection();
	System.out.println(con);
	String sqll="select fine_status from fine_amount where student_id=? and ISBN =?";
	PreparedStatement pst=con.prepareStatement(sqll);
	pst.setInt(1,studentId);
	pst.setLong(2, isbn);
	ResultSet row3 = pst.executeQuery();

	while(row3.next()) {
		String status = row3.getString("fine_status");
		System.out.println(status);
	  if(status.contentEquals("paid")) {
		  
			Connection con1 = TestConnection.getConnection();
			String sql3 ="update book_summary set renewal_count =  renewal_count-1, due_date=due_date+10"
					+ " where student_id=? and ISBN = ?";
			PreparedStatement stmt = con1.prepareStatement(sql3);
			stmt.setInt(1,studentId);
			stmt.setLong(2,isbn );
			int row = stmt.executeUpdate();
			System.out.println(sql3);
			System.out.println(row);
			
	  }
	  else  {
		  logger.info("Pay Fine amount");
	  }		
	
	
}
}
}











