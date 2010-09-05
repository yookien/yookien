package com.meikai.core.exception;

public class DaoException extends Exception {
	
	//错误代号
	private int errorCode;
	
	//错误描述
	private String errorDes;
	
	//原始异常
	private Exception originException;

	public DaoException(){
		super();
	}
	
	public DaoException(String msg){
		super(msg);
		this.errorDes=msg;
	}

	public DaoException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public DaoException(int errorCode, String errorDes) {
		super(errorDes);
		this.errorCode = errorCode;
		this.errorDes = errorDes;
	}
	
	public DaoException(int errorCode, String errorDes, Exception originException) {
		super(errorDes,originException);
		this.errorCode = errorCode;
		this.errorDes = errorDes;
		this.originException = originException;
	}
	public DaoException( String errorDes, Exception originException) {
		super(errorDes,originException);		
		this.errorDes = errorDes;
		this.originException = originException;
	}
	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorDes
	 */
	public String getErrorDes() {
		return errorDes;
	}

	/**
	 * @param errorDes the errorDes to set
	 */
	public void setErrorDes(String errorDes) {
		this.errorDes = errorDes;
	}

	/**
	 * @return the originException
	 */
	public Exception getOriginException() {
		return originException;
	}

	/**
	 * @param originException the originException to set
	 */
	public void setOriginException(Exception originException) {
		this.originException = originException;
	}
	

}
