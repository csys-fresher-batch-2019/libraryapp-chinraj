package com.chainsys.ldm.logIn;

public class TestLogin {

	public TestLogin(){
		AdminLogin AL =new AdminLogin();
		LogIn LI = new LogIn();
		
		try {
			LI.adminlogin(AL.getEmailId(), AL.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
