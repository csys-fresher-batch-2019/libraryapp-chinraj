package com.chainsys.LDM.SendMail;

import java.io.IOException;
import java.util.Scanner;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
public class SendMail {


public static void main(String[] args) throws Exception {
		//Scanner sc = new Scanner(System.in);
	    String subject = "Verify your new Amazon account";    
	    String bodyContent = "To verify your email address,\nplease use the following One Time Password (OTP):\n\n\n"+"\n\nDo not share this OTP with anyone.\nPrime takes your account security very seriously. ";
	    SendSmsIml.send("librarychinn@gmail.com","Reset@123","chinraj044@gmail.com",subject,bodyContent);
	    //System.out.println("Enter the OTP");
	    //System.out.println("OTP send to your MailId");
		//int a =sc.nextInt();
		//if(a == random)	
		//{
			//return true;
		//}
		//else
		//{
			//System.out.println("OTP entered is Incorrect");	
			//return false;
		//}
	}
}

