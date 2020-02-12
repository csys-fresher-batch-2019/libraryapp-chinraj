package com.chainsys.ldm.bookSummary;

import java.time.LocalDate;
import java.util.List;

public interface BookSummaryDAO {
	void addBookInfo(BookSummary BS);
	List<BookSummary> onParticularDate (LocalDate borrowedDate);
}
