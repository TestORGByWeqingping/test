package com.test.redis.redisTest1;

import java.util.Map;

import com.test.redis.redisTest1.annotation.Transaction;

public class RedisCommonService {
	@Transaction
	 public Map<String,String> hashMapGetAll(String key)throws Exception{
		return  RedisApi.instance().hashMapGetAll(key);		 
	 }
	@Transaction
	 public String getString(String key)throws Exception{
		return  RedisApi.instance().getString(key);		 	   
		
	}
	
	 public String hashMapHMSet(String key, Map map)throws Exception{
		  return  RedisApi.instance().hashMapHMSet(key, map);
   
  }
	 


}
