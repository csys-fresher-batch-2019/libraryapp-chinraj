package com.chainsys.LDM.Fines;

import java.util.Scanner;

public class TestFineInfo {
	

	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.println("\n 1.AddFineInf\n 2.booksReturned\n 3.Fine per Student\n 4.LostPenality\n 5.Book Renewal");

		FineInfoImpl d = new FineInfoImpl();
		FinesInfo f = new FinesInfo();
		int n = s.nextInt();
		switch (n) {
		case 1: {

			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			System.out.println("Enter fines per day :");
			f.setFinePerDay(s.nextInt());
			d.AddFineInfo(f);
			d.AddFineInfo1(f);
			d.TotalFinesAmt(f);
		}
			break;
		case 2: {

			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.bookreturned(f.getStudentId(), f.getISBN());

		}
			break;
		case 3: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.AddFineInfo1(f);
			d.TotalFinesAmt(f);
			d.FinePerStudent(f.getStudentId(), f.getISBN());
		}
			break;
		case 4: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.PenalityForBookLost(f.getStudentId(), f.getISBN());

		}
			break;
		case 5: {
			System.out.println("Enter studentId :");
			f.setStudentId(s.nextInt());
			System.out.println("Enter ISBN :");
			f.setISBN(s.nextLong());
			d.renewal(f.getStudentId(), f.getISBN());
		}
		}
		s.close();
	}
}
