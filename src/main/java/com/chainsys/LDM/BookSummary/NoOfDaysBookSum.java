package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class NoOfDaysBookSum {
	

	    public int  noOfExtraDays(LocalDate borrowedDate, LocalDate dueDate, LocalDate returnDate) {
	       // LocalDate borrowedDate = LocalDate.parse("2020-0");
	        System.out.println(" "+ borrowedDate);
	        
	         
	        //LocalDate dueDate = LocalDate.parse("2016-04-15");
	        System.out.println(" " + dueDate);
	         
	        //LocalDate returnedDate = LocalDate.parse("2016-04-25");
	        System.out.println(" " + returnDate );
	         
	        int  noOfExtraDays = Period.between(dueDate, returnDate ).getDays();
	        if(noOfExtraDays>0) {
	        System.out.println(" " +  noOfExtraDays);
	        }
	        else {
		        System.out.println(0);

	        }
			return noOfExtraDays;
	    }
}
