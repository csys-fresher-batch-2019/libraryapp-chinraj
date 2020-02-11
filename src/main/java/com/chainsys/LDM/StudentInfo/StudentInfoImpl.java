package com.chainsys.LDM.StudentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chainsys.LDM.BookSummary.TestConnection;

import Logger.Logger;

public class StudentInfoImpl implements StudentInfoDAO {

	public void addStudents(StudentInfo SS) throws Exception {
		Logger logger = Logger.getInstance();
			String sqlinsert ="insert into student(student_id,student_name,dept_name,mail_id) values(?,?,?,?)";
		   logger.info(sqlinsert);
			Connection con = TestConnection.getConnection();
			PreparedStatement stmt = con.prepareStatement(sqlinsert);
			stmt.setInt(1, SS.studentId);
			stmt.setString(2, SS.studentName);
			stmt.setString(3, SS.deptName);
			stmt.setString(4, SS.mailId);
			 int rows= stmt.executeUpdate();
			 logger.info("" + rows);
				
	}
	}


