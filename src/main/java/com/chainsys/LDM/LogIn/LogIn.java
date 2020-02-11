package com.chainsys.LDM.LogIn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.chainsys.LDM.BookSummary.TestConnection;

import Logger.Logger;



public class LogIn implements LoginDAO{	

	Logger logger = Logger.getInstance();

	static Scanner sc=new Scanner(System.in);
public static void main(String[] args) throws Exception {
	System.out.println("Enter emailid:");
	String emailid=sc.next();
	System.out.println("Enter Password:");
	String password=sc.next();
   LoginDAO com=new LogIn();
	if(com.adminlogin(emailid,password)) {
	System.out.println(">>>>LOGIN SUCESSFULL<<<<");
	}
	else
	{
	System.out.println(">>>>LOGIN FAILED<<<<");
	}
	}
		public boolean adminlogin(String emailid,String password) throws Exception {
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
		

