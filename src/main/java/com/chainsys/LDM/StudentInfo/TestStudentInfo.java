package com.chainsys.ldm.studentInfo;

import java.util.Scanner;

import logger.Logger;

public class TestStudentInfo {

	public static void main (String [] args) throws Exception{
		Scanner s= new Scanner(System.in);
		Logger logger = Logger.getInstance();
		StudentInfoImpl d = new StudentInfoImpl();
		StudentInfo SI = new StudentInfo();
		
		 logger.info("Enter studentId :");
		SI.setStudentId(s.nextInt());
		 logger.info("Enter studentName :");
		SI.setStudentName(s.next());
		 logger.info("Enter deptName :");
		SI.setDeptName(s.next());
		logger.info("Enter mail :");
		SI.setMailId(s.next());
		d.addStudents(SI);
		s.close();
	} 
}