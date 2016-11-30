package com.test.redis.redisTest1;

import org.junit.Test;

import redis.clients.jedis.Jedis;

public class JedisPubsubTest {
	@Test
	public void test()throws Exception{
		
		Jedis jedis=new Jedis("192.168.17.129", 9994);
		JedisPubSubService.instance().process(jedis, new JedisPubSunExcutorCreator() {
			
			public JedisPubSubExcutor create() throws Exception {
				// TODO Auto-generated method stub
				return new DefaultJedisPubSubExcutor();
			}
		}, "dongnao");
		jedis.disconnect();
		jedis.close();
	
		
	}

}
