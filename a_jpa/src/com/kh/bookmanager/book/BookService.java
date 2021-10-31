package com.kh.bookmanager.book;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
	
	public int persistBook(Book book) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		tx.begin();
		
		try {
			em.persist(book);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return res;
	}
	
	public int modifyBook(Long bkIdx, String info) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		tx.begin();
		
		try {
			Book book = em.find(Book.class, bkIdx);
			if(book == null) return res;
			
			book.setInfo(info);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			res = -1;
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return res;
	}
	
	public int removeBook(Long bkIdx) {
		EntityManager em = JpaTemplate.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		int res = 0;
		tx.begin();
		
		try {
			Book book = em.find(Book.class, bkIdx);
			if(book == null) return res;
			
			em.remove(book);
			tx.commit();
			res = 1;
		} catch (Exception e) {
			res = -1;
			e.printStackTrace();
			tx.rollback();
		} finally {
			em.close();
		}
		return res;
	}
	
	public List<Book> findBookByTitle(String keyword) {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			bookList = bookRepository.findBookByTitle(em, keyword);
		} finally {
			em.close();
		}
		return bookList;
	}

	public List<Book> findBookWithRank() {
		EntityManager em = JpaTemplate.createEntityManager();
		List<Book> bookList = new ArrayList<Book>();
		
		try {
			bookList = bookRepository.findBookWithRank(em);
		} finally {
			em.close();
		}
		return bookList;
	}
	
	
}
