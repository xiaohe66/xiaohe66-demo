package com.xiaohe66.demo.reactor;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author xiaohe
 * @time 2019-01-07 09:54
 */
public class ReactorTest {

	@Test
	public void test0() {

	}

	/**
	 * Flux 是一个序列，是一个集合
	 */
	@Test
	public void test1() {
		Flux.just("Hello", "World").subscribe(System.out::println);

		Flux.fromArray(new Integer[] { 1, 2, 3, 4 }).subscribe(System.out::println);
		Flux.empty().subscribe(System.out::println);
		Flux.range(1, 5).subscribe(System.out::println);
		Flux.interval(Duration.of(10, ChronoUnit.SECONDS)).subscribe(System.out::println);
		//		Flux.intervalMillis(1000).subscribe(System.out::println);

	}

	@Test
	public void test2() {
		Flux.generate(sink -> {
			sink.next("Hello");
			//不调用complete()方法的话，会一直生成调用 next()，生成一个无限序列
			sink.complete();
		}).subscribe(System.out::println);
	}

	/**
	 * 产生内容长度为10的一个序列
	 */
	@Test
	public void test22() {
		final Random random = new Random();
		Flux.generate(ArrayList::new, (list, sink) -> {
			int value = random.nextInt(100);
			list.add(value);
			sink.next(value);
			if (list.size() == 10) {
				sink.complete();
			}
			return list;
		}).subscribe(System.out::println);

	}

	@Test
	public void test3() {
		Flux.just(1, 2)
				.concatWith(Mono.error(new IllegalStateException("test")))
				.subscribe(System.out::println, System.err::println);

	}

	@Test
	public void test4() {
		Mono.fromSupplier(() -> "Hello").subscribe(System.out::println);
		Mono.justOrEmpty(Optional.of("Hello")).subscribe(System.out::println);
		Mono.create(sink -> sink.success("Hello")).subscribe(System.out::println);

	}

	@Test
	public void test5() {
		//100个元素的序列，按每组20个元素取出，共计可以分为5组
		Flux.range(1, 100).buffer(20).subscribe(System.out::println);
		//		Flux.intervalMillis(100).bufferMillis(1001).take(2).toStream().forEach(System.out::println);

		//bufferUntil()中可以设置条件，满足条件后，创建新的一组，示例是为 下标为3时，便生成新的一组
		Flux.range(1, 10).bufferUntil(i -> i % 3 == 0).subscribe(System.out::println);

		//bufferWhile()中可以设置条件，只取满足条件的元素
		Flux.range(1, 10).bufferWhile(i -> i % 3 == 0).subscribe(System.out::println);

	}

	@Test
	public void test6() {
		//filter()方法，使序列中只留下满足条件的元素，示例是输出1-20中的所有偶数
		Flux.range(1, 20).filter(i -> i % 2 == 0).subscribe(System.out::println);
	}

	@Test
	public void test7() {

		/*Flux.range(1, 100).window(10).subscribe((c) -> {
			c.subscribe(System.out::print);
			System.out.println();
		});*/

		Flux.interval(Duration.ofMillis(100)).window(Duration.ofMillis(1001))
				.take(2).toStream().forEach((c) -> {
			c.subscribe(System.out::println);
		});
	}

	@Test
	public void test8() {

		//将两个序列中的元素进行1对1的合并，结果为 [a,c],[b,d]
		Flux.just("a", "b")
				.zipWith(Flux.just("c", "d"))
				.subscribe(System.out::println);

		//将两个序列中的元素进行1对1的合并，并在合并时自定义格式
		Flux.just("a", "b")
				.zipWith(Flux.just("c", "d"), (s1, s2) -> s1 + "-" + s2)
				.subscribe(System.out::println);

	}

	@Test
	public void test9() {
		//从序列中提取 1-10号元素
		Flux.range(1, 1000).take(10).subscribe(System.out::println);
		//从序列中提取倒数10个元素
		Flux.range(1, 1000).takeLast(10).subscribe(System.out::println);
		//从序列中提取符合条件的数
		Flux.range(1, 1000).takeWhile(i -> i < 10).subscribe(System.out::println);
		//从序列中提取元素，直到条件返回true后不再提取
		Flux.range(1, 1000).takeUntil(i -> i == 10).subscribe(System.out::println);

	}

	@Test
	public void test10() {
		//对序列中的所有元素进行相加操作
		Flux.range(1, 10).reduce((x, y) -> x + y).subscribe(System.out::println);
		//对序列中的所有元素进行相加操作，并且指定初始值为100，即在得到1-10相加的结果后再加上100
		Flux.range(1, 10).reduceWith(() -> 100, (x, y) -> x + y).subscribe(System.out::println);
	}

	@Test
	public void test11() {
		//同时处理正常和错误的消息
		Flux.just(1, 2)
				.concatWith(Mono.error(new IllegalStateException()))
				.subscribe(System.out::println, System.err::println);
	}

	@Test
	public void test12() {
		Flux.just(1, 2)
				.concatWith(Mono.error(new RuntimeException("test")))
				.onErrorResume(e -> {
					if (e instanceof RuntimeException) {
						return Mono.just(1);
					}
					return Mono.empty();
				})
				.subscribe(System.out::println);

	}

	@Test
	public void test13() throws InterruptedException {

		final Flux<Long> source = Flux.interval(Duration.ofMillis(1000))
				.take(10)
				.publish()
				.autoConnect();
		source.subscribe();
		Thread.sleep(5000);
		source
				.toStream()
				.forEach(System.out::println);

	}
}
