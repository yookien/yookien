package com.meikai.common.model;

import com.meikai.core.model.BaseModel;

/**
 * ping bean
 * date 2010-01-01
 *modify:
 * @author yookien
 *
 */
public class BadWord extends BaseModel{
	
	private int badWordId;//
	//
	private String badWord;
	private String replaceWord;
	
	
	public String getBadWord() {
		return badWord;
	}
	public void setBadWord(String badWord) {
		this.badWord = badWord;
	}
	public int getBadWordId() {
		return badWordId;
	}
	public void setBadWordId(int badWordId) {
		this.badWordId = badWordId;
	}
	public String getReplaceWord() {
		return replaceWord;
	}
	public void setReplaceWord(String replaceWord) {
		this.replaceWord = replaceWord;
	}
	
}
