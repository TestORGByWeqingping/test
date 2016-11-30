package com.test.redis.redisTest1.proxy;

import java.lang.reflect.Method;

import com.test.redis.redisTest1.RedisDataSource;
import com.test.redis.redisTest1.annotation.Transaction;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;


public class RedisApiProxy implements MethodInterceptor {
	
	private static RedisApiProxy redisApiProxy;
	private Object ob;
	

	private RedisApiProxy() {
	}
	
	public static RedisApiProxy instance(){
		if(null==redisApiProxy){
			redisApiProxy=new RedisApiProxy();
		}
		
		return redisApiProxy;
	}

	
	
	public Object intercept(Object obj, Method method, Object[] arg2, MethodProxy proxyMethod) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("-------------start proxy---------");
		if(method.isAnnotationPresent(Transaction.class)){
			System.out.println(RedisDataSource.getdataSource());
			RedisDataSource.initJedis();
		}
		Object result=  method.invoke(ob, arg2);
		System.out.println(RedisDataSource.getdataSource());
		System.out.println("are you ok");
		System.out.println("are you ok");
		

		
		
		

		RedisDataSource.getdataSource().disconnect();
		RedisDataSource.getdataSource().close();
		return result;
	}
	
   public <T> T proxyObj(T ob)throws Exception{
	   this.ob=ob;
	  return(T)Enhancer.create(ob.getClass(), this);
   }
	
	

}
