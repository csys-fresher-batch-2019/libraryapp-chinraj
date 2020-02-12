package com.chainsys.ldm.sendMail;

import java.util.Properties;

import javax.mail.*;    
import javax.mail.internet.*;
public class SendSmsIml {

	
		
			public static void send(final String from,final String password,String to,String sub,String a) throws Exception
			{  
				Properties props = new Properties();    
		        props.put("mail.smtp.host", "smtp.gmail.com");    
		        props.put("mail.smtp.socketFactory.port", "465");    
		        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		        props.put("mail.smtp.auth", "true");    
		        props.put("mail.smtp.port", "465");    
		        props.put("mail.smtp.ssl.checkserveridentity", true);
		        Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() 
		        {    
		        	protected PasswordAuthentication getPasswordAuthentication() 
		        	{    
		        		return new PasswordAuthentication(from,password);  
		        	}      
		        });
		        try
		        {
			        MimeMessage message = new MimeMessage(session);    
					message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));    
					message.setSubject(sub);    
					BodyPart messageBodyPart1 = new MimeBodyPart();  
					messageBodyPart1.setText("Greetings, From ChinLib");  
					 
					BodyPart messageBodyPart2 = new MimeBodyPart(); 
					messageBodyPart2.setText("\nDear,hii \n \t\t ");
					BodyPart messageBodyPart3 = new MimeBodyPart(); 
					messageBodyPart3.setText(a);
					BodyPart messageBodyPart4 = new MimeBodyPart(); 
					messageBodyPart4.setText("\n\t\tThank you");
					BodyPart messageBodyPart5 = new MimeBodyPart(); 
					messageBodyPart5.setText("\n\t Team ChinLib...");
	
					//String filename = "SendAttachment.java";  
					//FileDataSource source = new FileDataSource("./src/test/java/com/chainsys/PayrollApp/SendMailSSL.java");  
					//messageBodyPart2.setDataHandler(new DataHandler(source));  
					//messageBodyPart2.setFileName(filename);  
					
					Multipart multipart = new MimeMultipart();
					multipart.addBodyPart(messageBodyPart1);  
					multipart.addBodyPart(messageBodyPart2);
					multipart.addBodyPart(messageBodyPart3);
					multipart.addBodyPart(messageBodyPart4);
					multipart.addBodyPart(messageBodyPart5);
	       
					message.setContent(multipart );  
					Transport.send(message);    
					System.out.println("message sent successfully");    
			}
		
		     catch (MessagingException e) 
		        {
		        	throw new RuntimeException(e);
		        }    
			}  
		}



