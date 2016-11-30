package com.test.redis.redisTest1;

import java.util.List;
import java.util.Map;


import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisApi {
	private static RedisApi api;
	private JedisCluster getdataSource()throws Exception{
		return RedisClusterDataSource.getdataSource();
	}
	private RedisApi(){

	}
	
   public static RedisApi instance(){
	if(api==null){
		api=new RedisApi();
	}
	return api;
  }
   
   
   public String getString(String key)throws Exception{
	   return getdataSource().get(key);
   }
   
   public boolean setString(String key,String value)throws Exception{
	   String resultStr=getdataSource().set(key, value);
	   return "1".equals(resultStr)?true:false;
   }
   public long appengString(String key,String value)throws Exception{
	   return getdataSource().append(key, value);
   }
   
   public boolean keyExsits(String key)throws Exception{
	  return  getdataSource().exists(key);
   }
   
   public long hashMapHSet(String key, String field,String value)throws Exception{
	  return  getdataSource().hset(key, field, value);
   }
   
   public String hashMapHMSet(String key, Map map)throws Exception{
		  return  getdataSource().hmset(key, map);
    
   }
   
   public Map<String,String> hashMapGetAll(String key)throws Exception{
	   getdataSource().hlen(key);
		  return  getdataSource().hgetAll(key);
 
   }
   
   public long hashMapLength(String key)throws Exception{
	   return getdataSource().hlen(key);
   }
   
   public boolean hashMapExistsKey(String key, String field)throws Exception{
		  return  getdataSource().hexists(key, field);
   }
   public String hashMapHget(String key, String field)throws Exception{
		  return  getdataSource().hget(key, field);
   }
   
   public List<String> hashMapHMget(String key, String[] field)throws Exception{
		  return  getdataSource().hmget(key, field);
   }
   public long hashMapDeleteByKey(String key, String[] fields)throws Exception{
		  return  getdataSource().hdel(key, fields);
   }
   
   public long listPush(String key,String ...value)throws Exception{
	  return  getdataSource().lpush(key, value);
   }
   
   public String listPop(String key)throws Exception{
		  return  getdataSource().lpop(key);
	   }
   
   public List<String> listRange(String key,long start,long end)throws Exception{
		  return  getdataSource().lrange(key, start, end);
   }
   
   public String listGetByIndex(String key,long index)throws Exception{
		  return  getdataSource().lindex(key, index);
    }
   
   public long listDelete(String key,long count,String value)throws Exception{
		  return  getdataSource().lrem(key, count, value);
   }
   
   public String listSet(String key,long index,String value)throws Exception{
		  return  getdataSource().lset(key, index, value);
   }
   
   public long listSet(String key)throws Exception{
		  return  getdataSource().llen(key);
   }
   
   public void publish(String messsage,String... channels) throws Exception{
	   for (int i = 0; i < channels.length; i++) {
		   getdataSource().publish(channels[i] ,messsage);
		}
		
   }



}
