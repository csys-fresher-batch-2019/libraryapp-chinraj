package com.chainsys.LDM.Deduction;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.chainsys.LDM.BookSummary.TestConnection;
import com.chainsys.LDM.Deduction.IdDetails;

public class IdDetailsImp implements IdDetailsDAO {
 IdDetails bb = new IdDetails();
	public void addMoneyInId(int a,int b) throws Exception {
		String sqlinsert ="insert into amount(student_id,amount_in_id) values(?,?)";
	    System.out.println(sqlinsert);
		Connection con = TestConnection.getConnection();
		PreparedStatement stmt = con.prepareStatement(sqlinsert);
		stmt.setInt(1,a);
		stmt.setInt(2,b);
		
		 int rows= stmt.executeUpdate();
			System.out.println("" + rows);
	}
	
	public int updateAmtInId(int studentId, long iSBN) throws Exception {
	Connection con = TestConnection.getConnection();
	//String sql6 = "update amount set amount_in_id =0 where amount_in_id <0";
	String sql5 = "update amount set amount_in_id = amount_in_id-(select fines from fine_amount where student_id=? and ISBN=?)where student_id=?";
	PreparedStatement s = con.prepareStatement(sql5);
	//PreparedStatement t = con.prepareStatement(sql6);
	s.setInt(1, studentId);
	s.setLong(2,iSBN);
	s.setInt(3, studentId);
	
    int rowq = s.executeUpdate();
   // int row = t.executeUpdate(sql6);
	System.out.println(sql5);
	//System.out.println(sql6);
		System.out.println(rowq);
	//	System.out.println(row);
		return rowq;
		}


	public int updateAmtInWallet(int studentId,long ISBN) throws Exception {
		Connection con = TestConnection.getConnection();
		
		String sql7 ="update amount set library_wallet = library_wallet + (select fines from fine_amount where student_id=? and ISBN=?) where student_id=?";
		String sql8= " update fine_amount set fine_status= 'paid' where student_id= ? and ISBN =?";
		
		PreparedStatement s = con.prepareStatement(sql7);
		s.setInt(1, studentId);
		s.setLong(2, ISBN);
		s.setInt(3, studentId);
		 int rowq = s.executeUpdate();
		 System.out.println(rowq);
		PreparedStatement t = con.prepareStatement(sql8);
		s.setInt(1, studentId);
		s.setLong(2, ISBN);
		
		 int row1 = s.executeUpdate();
		 System.out.println(row1);
		 System.out.println(sql7);
		
		return rowq;
		 
		 }

	public void libraryWallet() throws Exception {
		Connection con = TestConnection.getConnection();
	    CallableStatement Stmt=con.prepareCall("{call LIB_WALLET_PROC(?)}");
			//PreparedStatement s = con.prepareStatement(sql5);
		Stmt.registerOutParameter(1, Types.INTEGER);
	    Stmt.executeUpdate();
		int libraryWallet =Stmt.getInt(1);
		System.out.println(libraryWallet);
		
		
}}
