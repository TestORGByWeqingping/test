package com.test.redis.redisTest1;

public class DefaultJedisPubSubExcutor extends JedisPubSubExcutor {

	@Override
	public void Subscribing(String channel, int subscribedChannels) {
		// TODO Auto-generated method stub
		System.out.println("myself is subscrib: channel:"+channel+"\n");

	}

	@Override
	public void listenMessage(String channel, String message) {
		// TODO Auto-generated method stub
		System.out.println("get the message from channel:"+channel+" message:"+message);

	}

}
