package com.hmn.Dao;
 
import java.awt.print.Pageable;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hmn.Domain.Book;

@Repository
public interface BookDao {  

	List<Book> findAll(Pageable pageable);
	
	Book findByBookCode (String bookCode);

	void save(Book book);
	
//	@Query("select max( from bookmst where bookCode={bookCode}")
//	Book getMaxSer(String bookCode);
}
