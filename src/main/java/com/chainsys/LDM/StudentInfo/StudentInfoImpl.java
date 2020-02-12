package com.chainsys.ldm.studentInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.chainsys.ldm.bookSummary.TestConnection;

import logger.Logger;

public class StudentInfoImpl implements StudentInfoDAO {

	public void addStudents(StudentInfo SS) throws Exception {
		Logger logger = Logger.getInstance();
			String sqlinsert ="insert into student(student_id,student_name,dept_name,mail_id) values(?,?,?,?)";
		   logger.info(sqlinsert);
			try(Connection con = TestConnection.getConnection();){
			try(PreparedStatement stmt = con.prepareStatement(sqlinsert);){
			stmt.setInt(1, SS.getStudentId());
			stmt.setString(2, SS.getStudentName());
			stmt.setString(3, SS.getDeptName());
			stmt.setString(4, SS.getMailId());
			 int rows= stmt.executeUpdate();
			 logger.info("" + rows);
				
	}
	}
	
catch (Exception e) {
	logger.error(e);	
}}}

