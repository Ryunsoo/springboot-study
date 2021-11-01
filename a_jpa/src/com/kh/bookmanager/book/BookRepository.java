package com.kh.bookmanager.book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class BookRepository {

	public List<Book> findAllBooks(EntityManager em) {
		return em.createQuery("from Book", Book.class).getResultList();
	}

	public List<Book> findBookByTitle(EntityManager em, String keyword) {
		return em.createQuery("select b from Book b where b.title like '%'||:keyword||'%'", Book.class)
				.setParameter("keyword", keyword)
				.getResultList();
	}

	public List<Book> findBookWithRank(EntityManager em) {
		TypedQuery<Book> query = em.createQuery("select b from Book b order by b.rentCnt desc", Book.class);
		query.setMaxResults(5);
		return query.getResultList();
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
