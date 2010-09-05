package com.meikai.common.dao;

import java.util.List;

import com.meikai.core.exception.DaoException;
import com.meikai.core.util.QueryResult;

import com.meikai.common.model.BadWord;
/**
 * 敏感词语过滤Dao接口
 * @author yookien
 */


public interface BadWordDao {	
	
	/**
	 * 通过过滤词ID取得该词对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */
	public BadWord getBadWordById(int badWordId) throws DaoException;
	
	
	/**
	 * 通过过滤词取得该词对象	 
	 *  @param badWord
	 *  @return BadWord
	 */
	public BadWord getBadWord(BadWord badWord) throws DaoException;
	
		
	/**
	 * 取得所有敏感词语列表(带分页)	 
	 *  @param badWord
	 *  @return QueryResult
	 */	
	public QueryResult getBadWords(BadWord badWord) throws DaoException;	
	
	
	/**
	 * 取得所有敏感词语列表	 
	 *  @param
	 *  @return List
	 */	
	public List <BadWord> getAllBadWords() throws DaoException;
	
	
	/**
	 * 取得敏感词语分页列表
	 *  @param
	 *  @return List
	 
	public QueryResult getBadWords(BadWord badWord) throws DaoException;
	*/
	/**
	 * 添加敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void addBadWord(BadWord badWord) throws DaoException;
	
	
	/**
	 * 修改敏感词语 
	 *  @param badWord
	 *  @return 
	 */	
	public void updateBadWord(BadWord badWord) throws DaoException;	
	
		
	/**
	 * 删除敏感词语 
	 *  @param badWordId
	 *  @return 
	 */	
	public void deleteBadWord(int badWordId) throws DaoException;

}
