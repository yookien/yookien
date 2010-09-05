package com.meikai.common.web.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import com.meikai.core.action.BasicActionSupport;
import com.meikai.core.exception.ServiceException;

import com.meikai.common.model.BadWord;
import com.meikai.common.service.BadWordService;

/**
 * 敏感词语过滤
 * 
 * @author yookien
 * 
 */
public class BadWordManageAction extends BasicActionSupport {

	private int badWordId;
	
	
	private BadWord badWord;
	public BadWord getBadWord() {
		return badWord;
	}
	public void setBadWord(BadWord badWord) {
		this.badWord = badWord;
	}
	
	private BadWordService badWordService;	
	public void setBadWordService(BadWordService badWordService) {
		this.badWordService = badWordService;
	}
	
	private List badWordList;		
	public List getBadWordList() {
		return badWordList;
	}
	public void setBadWordList(List badWordList) {
		this.badWordList = badWordList;
	}

	/**
	 * <pre>删除过滤词</pre>
	 * 
	 * <ol>
	 * 	<li>删除过滤词</li>	
	 * </ol>
	 * @param badWordId
	 * @return
	 * @throws Exception
	 */		
	public String doDelete() throws Exception {
		try {
			badWordService.deleteBadWord(badWordId);
			super.setActionMessage("删除成功！");
		}
		catch(ServiceException se){
			throw new Exception(se);
		}
		return super.DELETE;		
	}

	
	/**
	 * <pre>通过ID取对应敏感词语对象</pre>
	 * 
	 * <ol>
	 * 	<li>通过ID取对应敏感词语对象</li>	
	 * </ol>
	 * @param badWordId
	 * @return badWord
	 * @throws Exception
	 */	
	public String doGetBadWordById() throws Exception{
		try {
			this.setBadWord(badWordService.getBadWordById(badWordId));
		}
		catch(ServiceException se){
			throw new Exception(se);
		}
		return SUCCESS;
	}
	public int getBadWordId() {
		return badWordId;
	}
	public void setBadWordId(int badWordId) {
		this.badWordId = badWordId;
	}
}
