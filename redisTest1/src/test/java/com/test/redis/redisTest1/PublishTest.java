package com.test.redis.redisTest1;

import org.junit.Test;

public class PublishTest {

	@Test
	public void test() throws Exception{
		JedisPubSubService sevice =JedisPubSubService.instance(); 
		sevice.publish("hello i am coming", "dongnao");
	}
}
