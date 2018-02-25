package com.hmn.Domain;

import lombok.Data;
import lombok.Getter;

@Data 
@Getter
public class Dto {
	private String count;
	private String month;
	private String year; 
	private String b_group;
	private String c_group;
	private String field ;
	private String keyword ;
	private String queryType;
	private String isbn;
}
