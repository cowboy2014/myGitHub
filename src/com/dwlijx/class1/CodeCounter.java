package com.dwlijx.class1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能：统计文件夹下某种格式的文件的总行数统计
 */
public class CodeCounter {

	static long  normalLine=0;
    static long commentLine=0;
    static long whiteLine=0;

     public static void p(Object obj){
         System.out.println(obj);
     }

    /**
     * 对当前文件的行数进行统计
     * @param f
     */
     public static void countcode(File f){
         BufferedReader  br=null;
         boolean bln=false;
         try{
             br=new BufferedReader(new FileReader(f));
             String  line="";
             try {
                 while((line = br.readLine()) != null) {
                     line=line.trim();
                     if(line.matches("^[\\s&&[^\\n]]*$")){
                         whiteLine+=1;
                     }else if(line.startsWith("/*")&&!line.equals("*/")){
                         commentLine+=1;
                         bln=true;
                     }else if (bln==true){
                         commentLine+=1;
                         if(line.endsWith("*/")){
                             bln=false;
                         }
                     }else if(line.startsWith("/*")&&line.endsWith("*/")){
                         commentLine+=1;
                     }else if(line.startsWith("//")){
                         commentLine+=1;
                     }else {
                         normalLine+=1;
                     }
                 }
             }
             catch (IOException e) {
                 e.printStackTrace();
             }
         }catch(FileNotFoundException e){
             e.printStackTrace();
         }finally {
             if(br!=null){
                 try {
                     br.close();
                     br=null;
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
                  
             }
         }

     }

    /**
     * 获取当前目录下的所有文件完整路径
     * @param file
     * @param resultFileName
     * @return
     */
    public static List<String> getSubFiles(File file, List<String> resultFileName){
        File[] files = file.listFiles();
        if(files==null) return resultFileName;
        for(File f: files){
            if(f.isDirectory()){
                resultFileName.add(f.getPath());
                getSubFiles(f,resultFileName);
            }else{
                resultFileName.add(f.getPath());
            }
        }
        return resultFileName;
    }


    public static void main(String args[]){
        //读取该目录下面的 所有 .java 文件进行统计。目前没进行文件夹递归访问
        File f=new File("E:\\Java_Develope\\workspace\\hzgoveg\\src\\main");
        List<String> resultFileName = new ArrayList<String>();
        resultFileName = getSubFiles(f,resultFileName);
        File file;
        for (String filePath: resultFileName){
            file = new File(filePath);
           if(file.getName().matches(".*\\.java")){
               countcode(file);
               p("========="+filePath+"==============");
               p("注释的代码行数:"+commentLine);
               p("空白的代码行数:"+whiteLine);
               p("有效的代码行数:"+normalLine);
           }

        }

    }

}
