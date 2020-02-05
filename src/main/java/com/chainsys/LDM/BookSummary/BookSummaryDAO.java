package com.chainsys.LDM.BookSummary;

import java.time.LocalDate;
import java.util.List;

public interface BookSummaryDAO {
	void addBookInfo(BookSummary BS) throws Exception;

public void renewal(BookSummary BS) throws Exception ;

	//int noOfExtraDays (int studentId) throws Exception;
	 //int totalFine() throws Exception ;
	 //public int FineAmount1() throws Exception;
	//int bookreturned(int studentId,int ISBN) throws Exception ;

	List<BookSummary> onParticularDate (LocalDate borrowedDate) throws Exception;
}
