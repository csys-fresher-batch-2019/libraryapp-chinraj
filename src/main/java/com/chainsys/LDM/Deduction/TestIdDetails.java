package com.chainsys.ldm.deduction;

import java.util.Scanner;

import logger.Logger;

public class TestIdDetails {
         
	public static void main(String[] args) throws Exception {
		Logger logger = Logger.getInstance();
		IdDetailsImp ii = new IdDetailsImp();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
       logger.info("\n 1.AddAmount\n 2.UpadateAmountInIdAfterFine\n 3.UpdateLibWalet \n4.Library Wallet");

		switch (n) {
		case 1: {

			logger.info("Enter studentId :");
			int studentId = s.nextInt();
			
		
			logger.info("Enter Amount to be added:");
			int deposit = s.nextInt();
			ii.addMoneyInId(studentId, deposit);
		}
			break;
		case 2: {
			logger.info("Enter studentId :");
			int studentId = s.nextInt();
			logger.info("Enter ISBN :");
			long ISBN = s.nextLong();
			ii.updateAmtInId(studentId, ISBN);
		}
			break;

		case 3:
			logger.info("Enter studentId :");
			int studentId = s.nextInt();
			logger.info("Enter ISBN :");
			long ISBN = s.nextLong();
			ii.updateAmtInWallet(studentId, ISBN);

			break;
		case 4: {
			ii.libraryWallet();
	}}
		s.close();
	}}	
	