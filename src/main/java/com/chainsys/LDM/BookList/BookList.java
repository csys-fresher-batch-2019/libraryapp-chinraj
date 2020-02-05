package com.chainsys.LDM.BookList;

import java.time.LocalDate;

public class BookList {

			public long ISBN;
			public int bookId;
			public int stock;
			public int pages;
			public int price;
			public int rackNo;
			public  String bookStatus;
			public String authorName;
		    public String publication;
		    public String bookName;
		    public LocalDate releasedDate;
		    public long getISBN() {
				return ISBN;
			}
			public void setISBN(long iSBN) {
				ISBN = iSBN;
			}
			public int getBookId() {
				return bookId;
			}
			public void setBookId(int bookId) {
				this.bookId = bookId;
			}
			public int getStock() {
				return stock;
			}
			public void setStock(int stock) {
				this.stock = stock;
			}
			public int getPages() {
				return pages;
			}
			public void setPages(int pages) {
				this.pages = pages;
			}
			public int getPrice() {
				return price;
			}
			public void setPrice(int price) {
				this.price = price;
			}
			public int getRackNo() {
				return rackNo;
			}
			public void setRackNo(int rackNo) {
				this.rackNo = rackNo;
			}
			public String getBookStatus() {
				return bookStatus;
				
			}
			public void setBookStatus(String bookStatus) {
				this.bookStatus = bookStatus;
			}
			public String getAuthorName() {
				return authorName;
			}
			public void setAuthorName(String authorName) {
				this.authorName = authorName;
			}
			public String getPublication() {
				return publication;
			}
			public void setPublication(String publication) {
				this.publication = publication;
			}
			public String getBookName() {
				return bookName;
			}
			public void setBookName(String bookName) {
				this.bookName = bookName;
			}
			public LocalDate getReleasedDate() {
				return releasedDate;
			}
			public void setReleasedDate(LocalDate releasedDate) {
				this.releasedDate = releasedDate;
			}
		    
		}



