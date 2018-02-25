package com.hmn.Service;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hmn.Domain.Book;
import com.hmn.Domain.Dto;

@Service
public interface BookService {
	public void insertBook(Book book);

	public void deleteBook(Book book);

	public void updateBook(Book book);

	public Book selectBookOne(String booKCode);

	public List<Book> getBookPageList(Dto dto, Pageable pageable);

}
