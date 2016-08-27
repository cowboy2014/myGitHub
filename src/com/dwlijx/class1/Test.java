package com.dwlijx.class1;

public class Test {

//		static String line = "g@7@huawei";
//
//		public static void main(String[] args) throws Exception {
//			String arr[] = line.split("@");
//			for(String i:arr){
//				System.out.println(i);
//			}
//			Class.forName("");
//		}

    static String line = "g@7@huawei";
    public static void main(String[] args) throws Exception {
        String flg = "5@";
        System.out.println(line.indexOf(flg));
        
        for (int i=0;i<30;i++)
        {System.out.println((int)(1+Math.random()*10));
        }
//        (int)(1+Math.random()*10);
        
    }
}
