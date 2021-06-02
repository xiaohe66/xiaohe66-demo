package com.xiaohe66.demo.guava.base;

import com.google.common.base.Preconditions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xiaohe
 * @time 2019-02-25 17:15
 */
public class PreconditionsTest {

	private static final Logger logger = LoggerFactory.getLogger(PreconditionsTest.class);

	private String msg = "test msg";

	private String nullStr = null;

	private String notNull = "this is a not null string";

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test1(){
		thrown.expect(IllegalArgumentException.class);
		Preconditions.checkArgument(false);
	}

	@Test
	public void test2(){
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage(msg);
		Preconditions.checkArgument(false,msg);
	}

	@Test
	public void test3(){
		thrown.expect(NullPointerException.class);
	    String str = Preconditions.checkNotNull(nullStr);
		logger.info("str : {}",str);
	}

	@Test
	public void test4(){
		thrown.expect(NullPointerException.class);
		thrown.expectMessage(msg);
	    String str = Preconditions.checkNotNull(nullStr,msg);
	    logger.info("str : {}",str);
	}

	@Test
	public void test41(){
	    String str = Preconditions.checkNotNull(notNull);
	    logger.info("str : {}",str);
	}

	@Test
	public void test5(){
		thrown.expect(IllegalStateException.class);
	    Preconditions.checkState(false);
	}

	@Test
	public void test6(){
		thrown.expect(IllegalStateException.class);
		thrown.expectMessage(msg);
	    Preconditions.checkState(false,msg);
	}

	@Test
	public void test7(){

		StringBuilder stringBuilder = new StringBuilder("1");
		thrown.expect(IndexOutOfBoundsException.class);
		thrown.expectMessage(msg);
	    Preconditions.checkPositionIndex(2,stringBuilder.length(),msg);

	    stringBuilder.append("2");
	    Preconditions.checkPositionIndex(2,stringBuilder.length());
	}

}
