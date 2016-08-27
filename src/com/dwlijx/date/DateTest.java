package com.dwlijx.date;
import java.util.*;
import java.text.*;

public class DateTest {
   public static void main(String args[]) {
        int year=0,month=0,day=0,hour=0,minute=0,second=0;  
        //在此处添加代码，获取Calendar类的实例cl
        Calendar cl =  Calendar.getInstance()  ;//这里获取到的就是记录当前的日期和时间的对象
        System.out.println(cl.getTime());
        System.out.println(cl.get(Calendar.SECOND));  //用来测试后面的second是不是
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        year=cl.get(Calendar.YEAR);
        //在此处添加代码，获取当前月份，提示：month不是当前月
        month = cl.get(Calendar.MONTH)+1;
        day=cl.get(Calendar.DAY_OF_MONTH);//日  
        hour=cl.get(Calendar.HOUR_OF_DAY);//小时  
        minute=cl.get(Calendar.MINUTE);//分钟  
        second=cl.get(Calendar.SECOND);//秒  
          
        System.out.println("现在时间:"+year+"年"+month+"月"+day+"日 "+hour+":"+minute+":"+second); 
    
   }
}
