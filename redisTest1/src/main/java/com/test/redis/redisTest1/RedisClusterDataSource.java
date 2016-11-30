package com.test.redis.redisTest1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisClusterDataSource {
	private static ThreadLocal<JedisCluster>dataSource=new ThreadLocal<JedisCluster>(){
		@Override
		protected JedisCluster initialValue() {
			// TODO Auto-generated method stub
			return RedisConfig.getJedisCluster();
		}
	};
	
	public static JedisCluster getdataSource()throws Exception{
		if(null==dataSource.get()){
			dataSource.set(RedisConfig.getJedisCluster());
		}
		return dataSource.get();
	}
	
	public static void initJedis()throws Exception{
		if(null==dataSource.get()){
			dataSource.set(RedisConfig.getJedisCluster());
		}
	}
	public boolean isConnectionNull(){
		return null!=dataSource.get()?true:false;
	}
	
}
