package com.chainsys.LDM.SendMail;
public class SendMail {


public static void chinlib(String mail,long ISBN) throws Exception {
		//Scanner sc = new Scanner(System.in);
	    String subject = "Book borrowed from ChinLib";    
	    String bodyContent = "Hi Student you borrowed a book from ChinLib \n Book ISBN  "+ISBN;
	    SendSmsIml.send("librarychinn@gmail.com","chinrajkishor", mail,subject,bodyContent);
	}
}

