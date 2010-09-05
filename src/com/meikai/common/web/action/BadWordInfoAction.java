package com.meikai.common.web.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ModelDriven;

import com.meikai.core.action.BasicActionSupport;
import com.meikai.core.exception.ServiceException;
import com.meikai.core.util.QueryResult;

import com.meikai.common.model.BadWord;
import com.meikai.common.service.BadWordService;

/**
 * 敏感词语过滤
 * 
 * @author yookien
 * 
 */
public class BadWordInfoAction extends BasicActionSupport implements ModelDriven {

	private BadWord badWord = new BadWord();
	
	public Object getModel() {
		return badWord;
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
	 * <pre>打开新增过滤词页面</pre>
	 * 
	 * <ol>
	 * 	<li>打开页面</li>	
	 * </ol>
	 * @param
	 * @return
	 * @throws Exception
	 */		
	public String doOpenCreate() throws Exception {
		return super.CREATE;
	}	
	
	/**
	 * <pre>新增过滤词</pre>
	 * 
	 * <ol>
	 * 	<li>操作新增过滤词</li>
	 * </ol>
	 * @param badWord
	 * @return
	 * @throws Exception
	 */	
	public String doCreate() throws Exception {
		try {
			badWordService.addBadWord(badWord);
		}
		catch(ServiceException se){
			throw new Exception(se);
		}
		return super.CREATE;
	}
	
	/**
	 * <pre>修改过滤词</pre>
	 * 
	 * <ol>
	 * 	<li>操作修改过滤词</li>
	 * </ol>
	 * @param badWord
	 * @return
	 * @throws Exception
	 */
	public String doUpdate() throws Exception {
		try {
			badWordService.updateBadWord(badWord);
			super.setActionMessage("修改成功!");
		}
		catch(ServiceException se){
			throw new Exception(se);
		}
		return super.UPDATE;
	}	
	
	
}
