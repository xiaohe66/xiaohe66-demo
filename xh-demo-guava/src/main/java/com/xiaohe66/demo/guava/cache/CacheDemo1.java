package com.xiaohe66.demo.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * demo1 简单使用
 *
 * @author xiaohe
 * @time 2019-02-25 16:05
 */
public class CacheDemo1 {

	private static final Logger logger = LoggerFactory.getLogger(CacheDemo1.class);

	private static Cache<String, String> cache = CacheBuilder.newBuilder().build();

	public static void main(String[] args) {
		CacheUtils.printAll(cache);
		CacheUtils.line();

		cache.put("1","one");
		cache.put("2","two");
		cache.put("3","three");
		CacheUtils.printAll(cache);

		logger.info(cache.getIfPresent("1"));

		cache.invalidate("1");
		CacheUtils.printAll(cache);
	}


}
