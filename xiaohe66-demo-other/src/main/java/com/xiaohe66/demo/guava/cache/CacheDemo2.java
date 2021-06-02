package com.xiaohe66.demo.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 定义 cache 的总容量、超时时间等
 *
 * @author xiaohe
 * @time 2019-02-25 16:33
 */
public class CacheDemo2 {

	private static final Logger logger = LoggerFactory.getLogger(CacheDemo1.class);

	public static void main(String[] args) throws Exception {
		maxSize();
		timeout();
	}

	/**
	 * 定义了 cache 的最大数量后，超过该数量后，老的 cache 会被删除掉
	 */
	private static void maxSize(){

		Cache<String, String> cache = CacheBuilder.newBuilder()
				.maximumSize(2)
				.build();

		CacheUtils.printAll(cache);

		cache.put("1","one");
		cache.put("2","two");
		CacheUtils.printAll(cache);

		cache.put("3","three");
		CacheUtils.printAll(cache);

		cache.put("4","four");
		CacheUtils.printAll(cache);
	}

	/**
	 * 定义了 cache 的超时时间后，超过超时时间后，将会被删除<br>
	 * 但是获取key对应的 cache 时，会刷新该key对应 cache 的生存时间
	 */
	private static void timeout() throws InterruptedException{

		//定义了缓存过期时间为5秒的 cache
		Cache<String, String> cache = CacheBuilder.newBuilder()
				.expireAfterAccess(5, TimeUnit.SECONDS)
				.build();

		// 创建一个线程，用来输出 cache 中的元素（每秒）
		new Thread(()->{
			for (int i = 0; i < 15; i++) {
				CacheUtils.printAll(cache);
				try {
					Thread.sleep(1000);
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		cache.put("1","one");
		cache.put("2","two");
		cache.put("3","three");
		cache.put("4","four");
		Thread.sleep(1100);

		cache.put("5","five");
		cache.put("6","six");

		Thread.sleep(1100);
		cache.put("7","seven");

		Thread.sleep(1100);
		cache.put("8","eight");

		Thread.sleep(2000);
		// 这里获取了 key 为6 的值，相当于刷新了6的生存时间，因此6是最后才被删除的
		logger.info("key '6' value is : {}",cache.getIfPresent("6"));

	}




}
