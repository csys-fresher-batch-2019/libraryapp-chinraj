package com.chainsys.ldm.bookSummary;

import java.time.LocalDate;
import java.util.List;

public interface BookSummaryDAO {
	void addBookInfo(BookSummary BS) throws Exception;
	List<BookSummary> onParticularDate (LocalDate borrowedDate) throws Exception;
}
