package com.meikai.core.util;

import java.util.List;

/**
 * 查询结果对象
 * 
 * @author ntyookien
 * @link www.ntyookien.com
 */
public class QueryResult {
	
	private QueryResult(){}
	
	private Pagination pagination;
	private List items = null;	
	
	public QueryResult(Pagination pagination,List items){
		this.pagination = pagination;
		this.items = items;
	}
		
	public List getItems() {
		return this.items;
	}
	public void setItems(List items){
		this.items = items;
	}

	public Pagination getPagination() {
		return pagination;
	}
	
}
