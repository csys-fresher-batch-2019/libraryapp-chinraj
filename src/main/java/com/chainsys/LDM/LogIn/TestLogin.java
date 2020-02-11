package com.chainsys.LDM.LogIn;

public class TestLogin {

	public TestLogin() throws Exception {
		AdminLogin AL =new AdminLogin();
		LogIn LI = new LogIn();
		
		LI.adminlogin(AL.getEmailId(), AL.getPassword());
	}

}
