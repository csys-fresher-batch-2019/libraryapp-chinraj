package com.chainsys.ldm.studentInfo;

import java.util.Scanner;

import logger.Logger;

public class TestStudentInfo {
	

	
	public static void main (String [] args) throws Exception{
		
		Scanner s = new Scanner(System.in);
		StudentInfo SI = new StudentInfo();
		StudentInfoImpl d = new StudentInfoImpl();
		Logger logger = Logger.getInstance();
		
		System.out.println("\n 1.Add students/n 2.delete Student");
		int n = s.nextInt();
		switch (n) {
		case 1: 
		{
		 logger.info("Enter studentId :");
		SI.setStudentId(s.nextInt());
		 logger.info("Enter studentName :");
		SI.setStudentName(s.next());
		 logger.info("Enter deptName :");
		SI.setDeptName(s.next());
		logger.info("Enter mail :");
		SI.setMailId(s.next());
		d.addStudents(SI);
		
	}
		case 2:{
			 logger.info("Enter studentId :");
				SI.setStudentId(s.nextInt());
				d.removeStudent(SI);
		}s.close();
		}
	}}		
		




