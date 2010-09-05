package com.meikai.common.web.action;

import java.util.List;

import com.meikai.common.model.BadWord;
import com.meikai.common.service.BadWordService;
import com.meikai.common.service.impl.HomepageClientServiceImpl;
import com.meikai.core.action.BasicActionSupport;
import com.meikai.core.exception.ServiceException;
import com.meikai.core.util.QueryResult;

/**
 * 敏感词语过滤
 * 
 * @author yookien
 * 
 */
public class BadWordListAction extends BasicActionSupport {
	
	private BadWordService badWordService;
	private HomepageClientServiceImpl homepageClientServiceImpl;
	
	public HomepageClientServiceImpl getHomepageClientServiceImpl() {
		return homepageClientServiceImpl;
	}
	public void setHomepageClientServiceImpl(
			HomepageClientServiceImpl homepageClientServiceImpl) {
		this.homepageClientServiceImpl = homepageClientServiceImpl;
	}
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
	
	private String keyword;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		keyword = keyword==null?"":keyword;
		this.keyword = keyword;
	}
	
	
	/**
	 * <pre>获取所有敏感词语列表（不带分页）</pre>
	 * 
	 * <ol>
	 * 	<li>获取所有敏感词语列表</li>
	 * </ol>
	 * @param 
	 * @return List
	 * @throws Exception
	 */		
	public String doGetBadWords() throws Exception {
		
		return super.LIST;
	}
	
	/**
	 * <pre>获取所有敏感词语列表（不带分页）</pre>
	 * 
	 * <ol>
	 * 	<li>设定检索的关键字和分页参数</li>
	 * 	<li>按条件执行查询数据</li>
	 * 	<li>返回结果列表</li>
	 * 	<li>设置分页信息</li>
	 * </ol>
	 * @param keyword，badWord
	 * @return List
	 * @throws Exception
	 */	
	public String doGetBadWordsByAjax() throws Exception {
		try {
			BadWord badWord = new BadWord();
			
			
			String str = homepageClientServiceImpl.getString();
			System.out.println(str);
			
			
			// 设定检索的关键字和分页参数
			badWord.setBadWord(keyword);
			badWord.getPagination().setStart(super.getPaginationStart());
			
			// 按条件执行查询数据
			QueryResult queryResult = badWordService.getBadWords(badWord);
			
			// 返回结果列表
			this.setBadWordList(queryResult.getItems());
			
			// 设置分页信息
			this.setPagination(queryResult.getPagination());
		}
		catch(ServiceException se){
			throw new Exception(se);
		}
		return super.LIST;
	}
	
}
