package com.hmn.Controller;

import java.text.SimpleDateFormat;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hmn.Domain.Book;
import com.hmn.Service.BookService;

@RestController
public class BookContoller {
	public static final String BGROUP = "BD";
	public static final String CGROUP = "BS";

	@Autowired
	private BookService bookService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdftime = new SimpleDateFormat("yyyyMMddHHmmss");;

	@RequestMapping(value = "/insertbookForm", method = RequestMethod.GET)
	public ModelAndView insertbook(ModelAndView mav) {
		mav.setViewName("book/insertBookForm");
		return mav;
	}

	@RequestMapping(value = "/book/{bookCode}", method = RequestMethod.GET)
	public ModelAndView bookForm(@PathVariable String bookCode, HttpServletRequest request, ModelAndView mav) {
		mav.addObject("book", bookService.selectBookOne(bookCode));
		mav.setViewName("book/bookForm");
		return mav;
	}
 

	@RequestMapping(value = "/deletebook", method = RequestMethod.DELETE)
	public void deleteBook(Book book, HttpServletRequest request) {
		String permission;

		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("bm_permission")) {
				permission = cookie.getValue();
				// if (permission.equals("0"))
				// return "member/adminfail";
			}
		}
		bookService.deleteBook(book);
	}
}
