package com.xiaohe66.demo.guava.cache;

import com.google.common.cache.Cache;
import java.util.Map;
import java.util.Map.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaohe
 * @time 2019-02-25 16:38
 */
class CacheUtils {

	private static final Logger logger = LoggerFactory.getLogger(CacheUtils.class);

	private CacheUtils(){

	}

	/**
	 * 遍历 cache 中的所有内容
	 */
	static void printAll(Cache<String,String> cache){
		Map<String,String> map = cache.asMap();
		if(map.size() == 0){
			logger.info("cache is empty");
		}else{
			for (Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String val = entry.getValue();
				logger.info("key : {}, value:{}",key,val);
			}
		}
		line();
	}

	static void line(){
		logger.info("-------------------------------------");
	}
}
