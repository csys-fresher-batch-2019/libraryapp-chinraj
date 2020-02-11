package com.chainsys.LDM.Deduction;

import java.util.Scanner;

public class TestIdDetails {
         
	public static void main(String[] args) throws Exception {
		IdDetailsImp ii = new IdDetailsImp();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println("\n 1.AddAmount\n 2.UpadateAmountInIdAfterFine\n 3.UpdateLibWalet \n4.Library Wallet");

		switch (n) {
		case 1: {

			System.out.println("Enter studentId :");
			int studentId = s.nextInt();
			
		
			System.out.println("Enter Amount to be added:");
			int deposit = s.nextInt();
			ii.addMoneyInId(studentId, deposit);
		}
			break;
		case 2: {
			System.out.println("Enter studentId :");
			int studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			long ISBN = s.nextLong();
			ii.updateAmtInId(studentId, ISBN);
		}
			break;

		case 3:
			System.out.println("Enter studentId :");
			int studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			long ISBN = s.nextLong();
			ii.updateAmtInWallet(studentId, ISBN);

			break;
		case 4: {
			ii.libraryWallet();
	}}
		s.close();
	}}	
	