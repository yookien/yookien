package com.meikai.core.model;

import com.meikai.core.util.Pagination;

/**
 * 实体对象公共类
 * 
 * @author yookien
 *
 */
public abstract class BaseModel {
	
	protected Pagination pagination = new Pagination();
	public Pagination getPagination() {
		return pagination;
	}
	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}
	
}
