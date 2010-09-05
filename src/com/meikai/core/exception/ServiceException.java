package com.meikai.core.exception;

public class ServiceException extends Exception {
	
	//错误代号
	private int errorCode;
	
	//错误描述
	private String errorDes;
	
	//原始异常
	private Exception originException;

	public ServiceException(){
		super();
	}
	
	public ServiceException(String msg){
		super(msg);
		this.errorDes=msg;
	}

	public ServiceException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}
	
	public ServiceException(int errorCode, String errorDes) {
		super(errorDes);
		this.errorCode = errorCode;
		this.errorDes = errorDes;
	}
	
	public ServiceException(int errorCode, String errorDes, Exception originException) {
		super(errorDes,originException);
		this.errorCode = errorCode;
		this.errorDes = errorDes;
		this.originException = originException;
	}
	public ServiceException( String errorDes, Exception originException) {
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
