package com.meikai.common.dao.impl;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.apache.log4j.Logger;

import com.meikai.core.exception.DaoException;
import com.meikai.core.util.QueryResult;

import com.meikai.common.model.BadWord;
import com.meikai.common.dao.BadWordDao;


import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * 敏感词语过滤Dao接口实现类
 * 
 * @author yookien
 */
public class BadWordDaoImpl extends SqlMapClientDaoSupport implements BadWordDao {

	/**
	 * 通过过滤词ID取得该词对象	 
	 *  @param badWordId
	 *  @return BadWord
	 */
	public BadWord getBadWordById(int badWordId) throws DaoException {
		
		try {
			return (BadWord) getSqlMapClientTemplate().queryForObject("getBadWordById",badWordId);
		} 
		catch (Exception ex) {
			throw new DaoException("通过过滤词ID取得该词对象发生错误...", ex);
		}
		
	}
	
	
	/**
	 * 通过过滤词取得该词对象	 
	 *  @param badWord
	 *  @return BadWord
	 */
	public BadWord getBadWord(BadWord badWord) throws DaoException {
		
		try {
			return (BadWord) getSqlMapClientTemplate().queryForObject("getBadWord",badWord);
		} 
		catch (Exception ex) {
			throw new DaoException("通过过滤词取得该词对象发生错误...", ex);
		}
	}
	
	
	/**
	 * 取得所有敏感词语列表(带分页)	 
	 *  @param badWord
	 *  @return QueryResult
	 */	
	public QueryResult getBadWords(BadWord badWord) throws DaoException {
		
		try {	
			badWord.setBadWord(badWord.getBadWord()+"%");
			badWord.getPagination().setTotalRecord(((Integer)(getSqlMapClientTemplate().queryForObject("countAllBadWords", badWord))).intValue());
			return new QueryResult(badWord.getPagination(),getSqlMapClientTemplate().queryForList("getBadWords", badWord));
			
		} catch (Exception ex) {
			throw new DaoException("取得所有敏感词语列表发生错误...", ex);
		}
	}	
	
		
	/**
	 * 取得所有敏感词语列表
	 * 
	 * @param
	 * @return List
	 */
	
	public List<BadWord> getAllBadWords() throws DaoException {

		try {
			return getSqlMapClientTemplate().queryForList("getAllBadWords");
		} catch (Exception ex) {
			throw new DaoException("取得所有敏感词语列表发生错误...", ex);
		}
	}

	
	/**
	 * 添加敏感词语
	 * 
	 * @param badWord
	 * @return
	 */
	public void addBadWord(BadWord badWord) throws DaoException {

		try {
			getSqlMapClientTemplate().insert("addBadWord", badWord);
		} catch (Exception ex) {
			throw new DaoException("添加敏感词语发生错误...", ex);
		}
	}

	/**
	 * 修改敏感词语
	 * 
	 * @param badWord
	 * @return
	 */
	public void updateBadWord(BadWord badWord) throws DaoException {

		try {
			getSqlMapClientTemplate().update("updateBadWord", badWord);
		} catch (Exception ex) {
			throw new DaoException("修改敏感词语发生错误...", ex);
		}
	}

	/**
	 * 删除敏感词语
	 * 
	 * @param badWordId
	 * @return
	 */
	public void deleteBadWord(int badWordId) throws DaoException {

		try {
			getSqlMapClientTemplate().delete("deleteBadWord", badWordId);
		} catch (Exception ex) {
			throw new DaoException("删除敏感词语发生错误...", ex);
		}
	}

}
