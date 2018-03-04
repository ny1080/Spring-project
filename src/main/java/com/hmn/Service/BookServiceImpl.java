package com.hmn.Service;
 
import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmn.Dao.BookDao;
import com.hmn.Domain.Book;
import com.hmn.Domain.Dto; 

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

	@Override
	public List<Book> getBookPageList(Dto dto, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	} 

  
}
