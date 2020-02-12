package com.chainsys.ldm.sendMail;
public class SendMail {


public static void chinlib(String mail,long ISBN) throws Exception {
	    String subject = "Book borrowed from ChinLib";    
	    String bodyContent = "Hi Student you borrowed a book from ChinLib \n Book ISBN  "+ISBN;
	    SendSmsIml.send("librarychinn@gmail.com","chinrajkishor", mail,subject,bodyContent);
	}
}

