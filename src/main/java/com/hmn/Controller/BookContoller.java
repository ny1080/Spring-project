package com.hmn.Controller;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hmn.Service.BookService;

@Controller
@RequestMapping("/board/")
public class BookContoller {
	public static final String BGROUP = "BD";
	public static final String CGROUP = "BS";

	@Autowired
	private BookService bookService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
	SimpleDateFormat sdftime = new SimpleDateFormat("yyyyMMddHHmmss");;

	@RequestMapping(value = "/insertbookForm", method = RequestMethod.GET)
	public String insertbookForm() {
		return "book/insertBookForm";
	}

	@RequestMapping(value = "/bookForm", method = RequestMethod.GET)
	public String bookForm() {
		return "book/bookForm";
	}
 
 
}
