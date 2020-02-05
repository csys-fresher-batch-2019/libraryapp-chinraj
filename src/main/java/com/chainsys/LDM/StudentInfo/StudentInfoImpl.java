package com.chainsys.LDM.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chainsys.LDM.BookSummary.TestConnection;

public class StudentInfoImpl implements StudentInfoDAO {

	public void addStudents(StudentInfo SS) throws Exception {
		
			String sqlinsert ="insert into student(student_id,student_name,dept_name) values(?,?,?)";
		    System.out.println(sqlinsert);
			Connection con = TestConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sqlinsert);
			stmt.setInt(1, SS.studentId);
			stmt.setString(2, SS.studentName);
			stmt.setString(3, SS.deptName);
			 int rows= stmt.executeUpdate();
				System.out.println("" + rows);
				
	

	
	}

	}


