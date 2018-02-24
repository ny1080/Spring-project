package com.hmn.Service;

import org.springframework.stereotype.Service;

import com.hmn.Domain.Book;

@Service
public interface BookService {
	public void insertBook(Book book);

	public void deleteBook(Book book);

	public void updateBook(Book book);

	public Book selectBookOne(String booKCode);

}
