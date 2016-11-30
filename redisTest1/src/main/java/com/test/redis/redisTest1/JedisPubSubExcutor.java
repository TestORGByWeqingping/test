package com.test.redis.redisTest1;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public abstract class JedisPubSubExcutor extends JedisPubSub {

	@Override
	public void onMessage(String channel, String message) {
		// TODO Auto-generated method stub
		System.out.println("channel:"+channel+"  message:"+message);
		listenMessage(channel,message);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("the channel:"+channel+"  is subscribed");
		Subscribing( channel,  subscribedChannels);

	}

	public abstract void Subscribing(String channel, int subscribedChannels);
	public abstract void listenMessage(String channel, String message);
	
	
}
