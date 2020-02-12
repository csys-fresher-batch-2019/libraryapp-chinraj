package com.chainsys.ldm.logIn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.chainsys.ldm.bookSummary.TestConnection;

import logger.Logger;



public class LogIn implements LoginDAO{	

	
	public static void main(String[] args) throws Exception {

	Logger logger = Logger.getInstance();
	 Scanner sc=new Scanner(System.in);

		
	
	logger.info("Enter emailid:");
	String emailid=sc.next();
	logger.info("Enter Password:");
	String password=sc.next();
   LoginDAO com=new LogIn();
	if(com.adminlogin(emailid,password)) {
		logger.info(">>>>LOGIN SUCESSFULL<<<<");
	}
	else
	{
	logger.info(">>>>LOGIN FAILED<<<<");
	}sc.close();
	}
		public boolean adminlogin(String emailid,String password) throws Exception {
			Logger logger = Logger.getInstance();
			try(Connection con = TestConnection.getConnection();){
			try(Statement stmt = con.createStatement();){
		if (stmt.executeUpdate("select email from admin_login where email='"  + emailid + "'") != 0)
		{
		try(ResultSet rs = stmt.executeQuery("select password from admin_login where email='" + emailid + "'");){
		rs.next();
		if (password.equals(rs.getString("password")))
		{
		return true;
		}
		}
		return false;
		}
		
		}}
			catch (Exception e) {
			logger.error(e);	
		}
			return false;
		}}
		

