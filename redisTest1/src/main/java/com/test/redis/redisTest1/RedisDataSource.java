package com.test.redis.redisTest1;

import redis.clients.jedis.Jedis;

public class RedisDataSource {
	private static ThreadLocal<Jedis>dataSource=new ThreadLocal<Jedis>(){
		@Override
		protected Jedis initialValue() {
			// TODO Auto-generated method stub
			return RedisConfig.getJedis();
		}
	};
	
	public static Jedis getdataSource()throws Exception{
		if(null==dataSource.get()){
			dataSource.set(RedisConfig.getJedis());
		}
		return dataSource.get();
	}
	
	public static void initJedis()throws Exception{
		if(null==dataSource.get()){
			dataSource.set(RedisConfig.getJedis());
		}
	}
	public boolean isConnectionNull(){
		return null!=dataSource.get()?true:false;
	}
	
}
