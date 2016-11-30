package com.test.redis.redisTest1;

import java.util.HashMap;
import java.util.Map;

import com.test.redis.redisTest1.proxy.RedisApiProxy;

public class ServiceFactory {
static Map<Class,Object>instanceMp =new HashMap<Class, Object>();

 public static <T> T getService(Class<T> clas)throws Exception{
	 if(null==instanceMp.get(clas)){
		 
		 RedisApiProxy proxy=RedisApiProxy.instance();
		 instanceMp.put(clas,proxy.proxyObj(clas.newInstance()));
	 }
	 return(T) instanceMp.get(clas);
 }
}
