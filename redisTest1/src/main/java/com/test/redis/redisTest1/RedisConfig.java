package com.test.redis.redisTest1;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisConfig {
	
	public static Jedis getJedis(final int timeOut){
		Jedis jedis=new Jedis("192.168.17.129", 9994,timeOut);
		return jedis;
	}
	
	public static Jedis getJedis(){
		Jedis jedis=new Jedis("192.168.17.129", 9994);
		return jedis;
	}
	public static JedisCluster getJedisCluster(){
		Set<HostAndPort>sets=new HashSet<HostAndPort>();
		sets.add(new HostAndPort("192.168.17.129", 8888));
//		sets.add(new HostAndPort("192.168.17.129", 2000));
//		sets.add(new HostAndPort("192.168.17.129", 3000));
//		sets.add(new HostAndPort("192.168.17.129", 4000));



		JedisCluster jedis=new JedisCluster(sets);
		return jedis;
	}
}
