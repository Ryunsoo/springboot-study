package com.kh.bookmanager.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.kh.bookmanager.common.code.jpa.JpaTemplate;

public class BookService {

	private BookRepository bookRepository = new BookRepository();
	
	public List<Book> findAllBooks() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<>();
		
		try {
			bookList = bookRepository.findAllBooks(em);
		} finally {
			em.close();
		}
		return bookList;
	}
	
	public List<Book> selectBookByTitle(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Book> selectBookWithRank() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
