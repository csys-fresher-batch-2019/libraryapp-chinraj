package com.chainsys.LDM.LogIn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.chainsys.LDM.BookSummary.TestConnection;



public class LogIn implements LoginDAO{	
	
	
public static void main(String[] args) throws Exception {
		
	System.out.println("Enter emailid:");
	Scanner sc=new Scanner(System.in);
	String emailid=sc.next();
	System.out.println("Enter Password:");
	String password=sc.next();
   LoginDAO com=new LogIn();


	if(com.adminlogin(emailid,password)) {
	System.out.println(">>>>LOGIN SUCESSFULL<<<<");
	//view order details

	}
	else
	{
	System.out.println(">>>>LOGIN FAILED<<<<");
	}
	
	}
	

		public boolean adminlogin(String emailid,String password) throws Exception {
		// TODO Auto-generated method stub
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
		if (stmt.executeUpdate("select email from admin_login where email='"  + emailid + "'") != 0)
		{
		ResultSet rs = stmt.executeQuery("select password from admin_login where email='" + emailid + "'");
		rs.next();
		if (password.equals(rs.getString("password")))
		{
		return true;
		}
		}
		return false;
		
		}
		}

		

