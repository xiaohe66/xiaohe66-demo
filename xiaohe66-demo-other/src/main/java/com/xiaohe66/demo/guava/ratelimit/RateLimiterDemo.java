package com.xiaohe66.demo.guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * RateLimiter 调试器 Demo
 *
 * <p> 本类主要研究 RateLimiter 调度器的运行情况和运行特性
 *
 * <h2> 主要结论
 * <ul>
 * <li>超过等待超时时间的，会直接返回失败。而在等待超时时间范围内的，会继续等待。</li>
 * <li>调试器队列上限 = 每秒调度上限 * 超时时间（秒） + 1;（在大量线程的实际测试中，结果会有一点偏差）</li>
 * </ul>
 *
 * @author xiaohe
 * @time 2019-02-25 11:00
 */
public class RateLimiterDemo {

	private static final Logger logger = LoggerFactory.getLogger(RateLimiterDemo.class);

	public static void main(String[] args) throws InterruptedException {

		// 模拟 1-7 的情况，都是 50个线程
		for (int i = 1; i < 7; i++) {
			for (int j = 1; j < 7; j++) {

				int successSum = i * j + 1;

				logger.info("maxRequestPerSecond : {} \t timeoutSecond : {} \t successSum : {}", i, j, successSum);
				run(50, i, j, successSum);
			}
		}
	}

	private static void run(final int threadSize,
							final int maxRequestPerSecond,
							final int maxQueue,
							final int successSum) throws InterruptedException {

		NetworkRequestSimulator networkRequestSimulator = new NetworkRequestSimulator(maxRequestPerSecond, maxQueue);

		Thread[] threads = new Thread[threadSize];
		for (int i = 0; i < threadSize; i++) {
			threads[i] = new Thread(networkRequestSimulator::request);
			threads[i].start();
		}
		for (Thread thread : threads) {
			thread.join();
		}
		int practical = networkRequestSimulator.successSum.get();
		logger.info("successSum : {}, errorSum : {}", practical, networkRequestSimulator.errorSum);
		logger.info("---------------------------------------------------------");

		// 输出预计和实际不符的情况
		if (successSum != practical) {
			logger.error("error, hopeful : {}, practical : {}", successSum, practical);
			logger.info("---------------------------------------------------------");
		}
	}

	private static class NetworkRequestSimulator {

		RateLimiter rateLimiter;

		int timeoutSecond;

		/**
		 * 统计成功的数量
		 */
		AtomicInteger successSum = new AtomicInteger(0);

		/**
		 * 统计直接返回失败的数量
		 */
		AtomicInteger errorSum = new AtomicInteger(0);

		private NetworkRequestSimulator(int maxRequestPerSecond, int maxQueue) {
			rateLimiter = RateLimiter.create(maxRequestPerSecond);
			this.timeoutSecond = maxQueue;
		}

		private void request() {
			if (rateLimiter.tryAcquire(timeoutSecond, TimeUnit.SECONDS)) {
				logger.info("request start");
				successSum.getAndIncrement();
			}
			else {
				errorSum.getAndIncrement();
			}
		}

	}

}
