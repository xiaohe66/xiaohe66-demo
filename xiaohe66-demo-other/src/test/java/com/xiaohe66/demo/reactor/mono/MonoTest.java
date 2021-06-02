package com.xiaohe66.demo.reactor.mono;

import org.junit.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Mono;

/**
 * @author xiaohe
 * @time 2019-01-15 17:32
 */
public class MonoTest {

	@Test
	public void test1() {

		Mono<String> mono = Mono.create(callback -> {
			/*
			 * 这里是待回调的相关代码
			 * 下面这条语句执行后，会告诉回调这个回调的人 已经回调成功并传回 一个消息test
			 * */
			callback.success("test");
		});

		// 调用 subscribe()方法后，会执行回调方法，即上面 callback 的代码
		Disposable disposable = mono.subscribe(t -> {
			/*
			 *  callback 中调用 success(obj) 方法后 会执行这个方法，并把 message 传入
			 * */
			System.out.println("成功:" + t);
		});

		//调用 callback 中调用 success() 方法后，返回值为 true
		System.out.println(disposable.isDisposed());
	}

	@Test
	public void test2() {
		Mono<String> mono = Mono.create(callback -> {
			/*
			 * 这里是待回调的相关代码
			 * 下面这条语句执行后，会给回调 callback 的人 抛出一个异常
			 * */
			callback.error(new RuntimeException("test exc"));
		});

		// 调用 subscribe()方法后，会执行回调方法，即上面 callback 的代码
		Disposable disposable = mono.subscribe(t -> {
			/*
			 *  callback 中调用 success(obj) 方法后 会执行这个方法，并把 message 传入
			 * */
			System.out.println("成功:" + t);
		}, e -> {
			System.out.println("失败");
		});

		//调用 callback 中调用 error() 后，返回值为 true
		System.out.println(disposable.isDisposed());

	}

}
