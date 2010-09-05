package com.meikai.core.util;

import org.apache.log4j.Logger;


/**
 * 分页BEAN
 * @author Administrator
 *
 */
public class Pagination {
	
	private final static Logger logger = Logger.getLogger(Pagination.class);
	
	public Pagination(){
		this.offset = 10;
	}
	
	public Pagination(int start,int offset){
		init(start,offset);
	}
	
	/**
	 * 初始化分页
	 * @param parameters 参数Map
	 * @param offset 每页显示信息数
	 */
	private void init(int start,int offset){
		this.offset = offset;
		if( start == 0 ){
			this.start = 0;
			return;
		}
		else{
			this.start = start;
		}
	}
	
	public Pagination(int start){
		init(start,20);
	}
	
	private int start;
	private int offset;
	private int totalPage;
	private int totalRecord;
	
	public int getOffset(){
		return offset;
	}
	public void setOffset(int offset){
		this.offset = offset;
	}
	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	
	public void setTotalRecord(int totalRecord) {
		if(logger.isDebugEnabled()){
			logger.debug("总记录数 = " + totalRecord);
		}
		int temp = totalRecord % offset;
		if (temp == 0){
			totalPage = totalRecord / offset;
		}
		else{
			totalPage = totalRecord / offset + 1;
		}
		if(logger.isDebugEnabled()){
			logger.debug("totalPage = " + totalPage);
		}
		this.totalRecord = totalRecord;
	}
	
	
	/**
	 * 该页是否有下一页.
	 */
	public boolean hasNextPage() {
		return true;
		//return this.getCurrentPageNo() < this.totalPage - 1;
	}

	/**
	 * 该页是否有上一页.
	 */
	public boolean hasPreviousPage() {
		return true;
		//return this.getCurrentPageNo() > 1;
	}
	
}
