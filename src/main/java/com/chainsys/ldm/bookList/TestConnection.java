package com.chainsys.ldm.bookList;
import java.sql.DriverManager;
import java.sql.Connection;

public class TestConnection {
	static Connection getConnection()throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:XE","system","oracle");
	return connection;
	}
	

}
