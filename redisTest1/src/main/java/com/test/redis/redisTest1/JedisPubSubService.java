package com.test.redis.redisTest1;

import redis.clients.jedis.Jedis;

public class JedisPubSubService {
	private static JedisPubSubService instance;
	private JedisPubSubService(){
		
	}
	public void process(Jedis client,JedisPubSunExcutorCreator creator,String... channels)throws Exception{
		client.subscribe(creator.create(), channels);
	}
	
	public static JedisPubSubService instance(){
		if(null==instance){
			instance=new JedisPubSubService();
		}
		return instance;
		
	}
	
	public void publish(String messsage,String... channels) throws Exception{
		RedisApi.instance().publish(messsage, channels);
	
		
	}
	

}
