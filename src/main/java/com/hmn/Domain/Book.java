package com.hmn.Domain;

import org.apache.ibatis.type.Alias;

import lombok.Data;
  
@Alias("book") 
public @Data class Book {
  
	private String bookCode;
	private String isbn;
	private String title;
	private String author;
	private String publish;
	private String summary; 
	private String receiveDate;
	private String recommend;	
	private int quantity; 
	private int price;  	
	private String imageurl;
	private String link;

	private String fill;
	private String group1;
	private String group2;
	private String group3;
	private String rentStatus;
	private String rsvStatus;

}
