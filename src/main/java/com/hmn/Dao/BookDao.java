package com.hmn.Dao;
 
import org.springframework.stereotype.Repository;

import com.hmn.Domain.Book;


public interface BookDao {  
	Book findByBookCode (String bookCode);

	void save(Book book);
	
//	@Query("select max( from bookmst where bookCode={bookCode}")
//	Book getMaxSer(String bookCode);
}
