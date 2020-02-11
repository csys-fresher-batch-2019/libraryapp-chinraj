package com.chainsys.LDM.Fines;

import java.util.Scanner;

public class TestFineInfo {
	 static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
	
		System.out.println("\n 1.AddFineInf\n 2.booksReturned\n 3.Fine per Student\n 4.LostPenality\n 5.Book Renewal");
	
		FineInfoImpl d = new FineInfoImpl();
		FinesInfo f = new FinesInfo();
		int n = s.nextInt();
		switch (n) {
		case 1: {
			
			System.out.println("Enter studentId :");
			f.studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			f.ISBN = s.nextLong();
			System.out.println("Enter fines per day :");
			f.finePerDay = s.nextInt();
			d.AddFineInfo(f);
			d.AddFineInfo1(f);
			d.TotalFinesAmt(f);
		}
			break;
		case 2:{	

			System.out.println("Enter studentId :");
			f.studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			f.ISBN = s.nextLong();
			d.bookreturned(f.studentId, f.ISBN);
			
	} 
	break;
		case 3:{
			System.out.println("Enter studentId :");
			f.studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			f.ISBN = s.nextLong();
			d.AddFineInfo1(f);
			d.TotalFinesAmt(f);
			d.FinePerStudent(f.studentId, f.ISBN);
		}break;
		case 4:{
			System.out.println("Enter studentId :");
			f.studentId=s.nextInt();
			System.out.println("Enter ISBN :");
			f.ISBN = s.nextLong();
			d.PenalityForBookLost(f.studentId, f.ISBN);
			
		}break;
		case 5:{
			System.out.println("Enter studentId :");
			f.studentId = s.nextInt();
			System.out.println("Enter ISBN :");
			f.ISBN = s.nextLong();
			d.renewal(f.studentId, f.ISBN);
		}
		}
	}}
