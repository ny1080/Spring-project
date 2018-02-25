package com.hmn.Controller;
 
import java.awt.print.Pageable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hmn.Dao.BookDao;
import com.hmn.Domain.Book;
import com.hmn.Domain.Dto;
import com.hmn.Service.BookService; 

@RestController 
public class BookRestContoller {
	
	@Autowired
	private BookService bookService; 
	@Autowired
	private BookDao bookDao;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdftime = new SimpleDateFormat("yyyyMMddHHmmss");
  
	@RequestMapping(value="/setRecommend/", method=RequestMethod.PUT)
	public void setRecommend(Book book) {		
		bookService.updateBook(book);
	} 

	@RequestMapping(value = "/bookPageList", method=RequestMethod.GET)
	@ResponseBody
	public List<Book> bookPageList(Model model, Dto dto, Pageable pageable)  {		
		return bookService.getBookPageList(dto, pageable);
	}
 
	@RequestMapping(value = "/book/{bookCode}", method=RequestMethod.GET)		
	public Book book(@PathVariable String bookCode, ModelAndView mav)  { 
		return bookService.selectBookOne(bookCode);
	}
	 
	
	@RequestMapping(value="/book/deletebook", method=RequestMethod.DELETE)
	public void deleteBook(Book book, HttpServletRequest request) {
		String permission;

		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("bm_permission")) {
				permission = cookie.getValue();
//				if (permission.equals("0"))
//					return "member/adminfail";
			}
		} 

		bookService.deleteBook(book);		
	}
}
