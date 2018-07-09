package com.taotao.util;

import java.util.Random;

public class IdUtils {
        public static long GetItemId(){
        	
        	long time=System.currentTimeMillis();
        	Random r=new Random();
        	int s=r.nextInt(99);
        	String num=time+String.format("%02d",s);
        	
        	String n=num.substring(num.length()-6, num.length());
        	
        	Long id=new Long(n);
			return id;
                	
        }
}
