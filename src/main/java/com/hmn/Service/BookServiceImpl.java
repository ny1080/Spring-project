package com.hmn.Service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmn.Dao.BookDao;
import com.hmn.Domain.Book; 

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	 
	 

	@Override
	public void insertBook(Book book) {
		bookDao.save(book);
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub 
	}

	@Override
	public void updateBook(Book book) {
		bookDao.save(book);
	}

	@Override
	public Book selectBookOne(String bookCode) {
		return bookDao.findByBookCode(bookCode);
	} 

  
}
