package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.time.Period;

public class BookSummaryFines {
	
    public  int  noOfExtraDays;
    public  int finePerDay;


    public  static int fines(LocalDate borrowedDate, LocalDate dueDate, LocalDate returnedDate) {
      //  LocalDate borrowedDate = LocalDate.parse("2016-03-15");
        
         
      //  LocalDate dueDate = LocalDate.parse("2016-04-15");
         
    //    LocalDate returnedDate = LocalDate.parse("2016-04-25");
         
        int  noOfExtraDays = Period.between(dueDate, returnedDate ).getDays();

        System.out.println("BorrowedDAte= "+ borrowedDate + ",DueDate:" + dueDate + ",returnDate =" + returnedDate +", noOfExtraDays:" + noOfExtraDays);
         int totalFine = 0;

        if (  noOfExtraDays > 0){
            totalFine =  2* noOfExtraDays;
        } else {
        
            	totalFine =0;
           
	        System.out.println("Total Fine:" + totalFine);	        

        }
        return totalFine;

    }



	
}





