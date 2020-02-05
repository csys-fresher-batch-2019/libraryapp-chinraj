package com.chainsys.LDM.StudentInfo;

import java.util.Scanner;

public class TestStudentInfo {

	public static void main (String [] args) throws Exception{
		
		StudentInfoImpl d = new StudentInfoImpl();
		StudentInfo SI = new StudentInfo();
		Scanner s= new Scanner(System.in);
		System.out.println("Enter studentId :");
		SI.studentId = s.nextInt();
		System.out.println("Enter studentName :");
		SI.studentName = s.next();
		System.out.println("Enter deptName :");
		SI.deptName = s.next();
		d.addStudents(SI);

	} 
}
