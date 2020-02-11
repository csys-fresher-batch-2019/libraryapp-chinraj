package com.chainsys.LDM.StudentInfo;

import java.util.Scanner;

import Logger.Logger;

public class TestStudentInfo {

	public static void main (String [] args) throws Exception{
		Scanner s= new Scanner(System.in);
		Logger logger = Logger.getInstance();
		StudentInfoImpl d = new StudentInfoImpl();
		StudentInfo SI = new StudentInfo();
		
		 logger.info("Enter studentId :");
		SI.studentId = s.nextInt();
		 logger.info("Enter studentName :");
		SI.studentName = s.next();
		 logger.info("Enter deptName :");
		SI.deptName = s.next();
		logger.info("Enter mail :");
		SI.mailId=s.next();
		d.addStudents(SI);
		s.close();
	} 
}