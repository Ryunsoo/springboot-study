package com.kh.bookmanager.book;

import java.util.List;

public class BookController {
	
	private BookService bookService =  new BookService();

	public List<Book> searchAllBooks() {
		return bookService.findAllBooks();
	}
	
	public int registBook(Book book) {
		return bookService.persistBook(book);
	}
	
	public int modifyBook(Long bkIdx, String info) {
		return bookService.modifyBook(bkIdx, info);
	}
	
	public int removeBook(Long bkIdx) {
		return bookService.removeBook(bkIdx);
	}
	
	public List<Book> searchBookByTitle(String keyword) {
		return bookService.findBookByTitle(keyword);
	}

	public List<Book> searchBookWithRank() {
		return bookService.findBookWithRank();
	}

	

	

	
	
	
}
