package com.meikai.common.service.impl;

import java.util.Iterator;
import java.util.List;

import com.meikai.core.util.QueryResult;
import com.meikai.core.exception.DaoException;
import com.meikai.core.exception.ServiceException;

import com.meikai.common.model.BadWord;
import com.meikai.common.dao.BadWordDao;
import com.meikai.common.service.BadWordService;

/**
 * 敏感词语过滤Service接口实现
 * @author yookien
 */

public class BadWordServiceImpl implements BadWordService {
	
	private BadWordDao badWordDao;

	public void setBadWord(BadWordDao badWordDao) {
		this.badWordDao = badWordDao;
	}

	
	/**
	 * 通过ID取对应敏感词语对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */	
	public BadWord getBadWordById(int badWordId) throws ServiceException{
		
		try{
			return badWordDao.getBadWordById(badWordId);
		}
		catch (DaoException de){
			throw new ServiceException("通过ID取得所有敏感词语对象发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 通过敏感词取对应敏感词语对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */	
	public BadWord getBadWord(BadWord badWord) throws ServiceException {
		
		try{
			return badWordDao.getBadWord(badWord);
		}
		catch (DaoException de){
			throw new ServiceException("通过ID取得所有敏感词语对象发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 取得所有敏感词语列表（带分页） 
	 *  @param badWord
	 *  @return QueryResult
	 */	
	public QueryResult getBadWords(BadWord badWord) throws ServiceException {
		
		try{
			return badWordDao.getBadWords(badWord);
		}
		catch (DaoException de){
			throw new ServiceException("取得所有敏感词语列表发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 取得所有敏感词语列表	 
	 *  @param
	 *  @return List
	 */	
	public List <BadWord> getAllBadWords() throws ServiceException {
		
		try{
			return badWordDao.getAllBadWords();
		}
		catch (DaoException de){
			throw new ServiceException("取得所有敏感词语列表发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 添加敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void addBadWord(BadWord badWord) throws ServiceException {
		
		try{
			badWordDao.addBadWord(badWord);
		}
		catch (DaoException de){
			throw new ServiceException("添加敏感词语发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 修改敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void updateBadWord(BadWord badWord) throws ServiceException {
		
		try{
			badWordDao.updateBadWord(badWord);
		}
		catch (DaoException de){
			throw new ServiceException("修改敏感词语发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 删除敏感词语 
	 *  @param badWordId
	 *  @return 
	 */	
	public void deleteBadWord(int badWordId) throws ServiceException {
		
		try{
			badWordDao.deleteBadWord(badWordId);
		}
		catch (DaoException de){
			throw new ServiceException("删除敏感词语发生错误...",de.getOriginException());	
		}
	}
	
	/**
	 * 过滤敏感词语 
	 *  @param source 将要过滤的词语
	 *  @return String 过滤后的词语
	 */	
	public String filterBadWord(String source) throws ServiceException {
		try{
			List badWordList = badWordDao.getAllBadWords();
			
			if (badWordList!=null) {
				for (Iterator iter = badWordList.iterator(); iter.hasNext();) {
					BadWord badWord = (BadWord) iter.next();
					source = source.replaceAll(badWord.getBadWord(),badWord.getReplaceWord());
				}
			}
			return source;
		}
		catch (DaoException de){
			throw new ServiceException("过滤敏感词语发生错误...",de.getOriginException());
		}
	}

}
