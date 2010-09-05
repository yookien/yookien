package com.meikai.common.service.impl;

import com.meikai.HomepageAuthRes;
import com.meikai.common.service.HomepageService;

/**
 * 敏感词语过滤Service接口实现
 * @author yookien
 */

public class HomepageClientServiceImpl {
	
	private HomepageService homepageService;
	
	
	
	public String getString(){
		HomepageAuthRes homepageAuthRes = homepageService.homepageAuth("0");
		return homepageAuthRes.getMac();
	}

	public HomepageService getHomepageService() {
		return homepageService;
	}

	public void setHomepageService(HomepageService homepageService) {
		this.homepageService = homepageService;
	}
	
	
}
