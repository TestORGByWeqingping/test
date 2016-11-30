package com.test.redis.redisTest1;

import java.util.HashMap;
import java.util.Map;

public class AppTest 
{
    @org.junit.Test
    public void testApp() throws Exception
    {
    	RedisCommonService service=ServiceFactory.getService(RedisCommonService.class);
    	Map<String,String>result=service.hashMapGetAll("maptest1");
    	System.out.println(result);
    }
    
   public static void main(String[]args){
	   RedisCommonService service;
	try {
		service = ServiceFactory.getService(RedisCommonService.class);
	     for(int i=0;i<100;i++){
	    		String result=service.hashMapHMSet("abcdefg"+i, new HashMap<String,String>(){{
	    			put("name", "weiqp");
	    			put("id", "12345667");

	    		}
	    			
	    		});
	    	   	System.out.println(result);
	     }
	

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   	
  }
}
