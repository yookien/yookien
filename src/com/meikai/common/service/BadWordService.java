package com.meikai.common.service;

import java.util.List;

import com.meikai.core.util.QueryResult;
import com.meikai.core.exception.ServiceException;

import com.meikai.common.model.BadWord;
/**
 * 敏感词语过滤Service接口
 * @author yookien
 */


public interface BadWordService {
	
	/**
	 * 通过ID取对应敏感词语对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */	
	public BadWord getBadWordById(int badWordId) throws ServiceException;
	
	/**
	 * 通过敏感词取对应敏感词语对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */	
	public BadWord getBadWord(BadWord badWord) throws ServiceException;
	
	
	/**
	 * 取得所有敏感词语列表（带分页） 
	 *  @param badWord
	 *  @return QueryResult
	 */	
	public QueryResult getBadWords(BadWord badWord) throws ServiceException;
	
	/**
	 * 取得所有敏感词语列表	 
	 *  @param
	 *  @return List
	 */	
	public List <BadWord> getAllBadWords() throws ServiceException;
	
	/**
	 * 添加敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void addBadWord(BadWord badWord) throws ServiceException;
	
	/**
	 * 修改敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void updateBadWord(BadWord badWord) throws ServiceException;
	
	/**
	 * 删除敏感词语 
	 *  @param badWordId
	 *  @return 
	 */	
	public void deleteBadWord(int badWordId) throws ServiceException;
	
	/**
	 * 过滤敏感词语 
	 *  @param source 将要过滤的词语
	 *  @return String 过滤后的词语
	 */	
	public String filterBadWord(String source) throws ServiceException;


}
