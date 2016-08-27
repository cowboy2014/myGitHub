package com.dwlijx.bugger;

/**
 * Created by hadoop on 2016/8/27.
 */
public class DownloadFile {
    /**
     * 根据网页类型生成需要保存的网页的文件名，去除URL中的非文件名字符
     * @param url
     * @param contenType
     * @return
     */
    public String getFileNameByUrl(String url ,String contenType){
        //移除http
        url=url.substring(7);
        //去除html文件的特殊字符
        if(contenType.indexOf("html") != -1 ){
            url  = url.replaceAll("[\\?/:*|<>\"]","_")+".html";
            return url;
        }else{
            return url.replaceAll("[\\?/:*|<>\"]","_")+"."+contenType.substring(contenType.lastIndexOf("/"+1));
        }
    }

    /**
     * 保存网页字节数组到本地文件，filePath为要保存的文件的相对地址
     * @param data
     * @param filePath
     */
    public void saveToLocal (byte[] data,String filePath){

    }

    /**
     * 构造方法：下载URL指定的网页
     * @param url
     * @return
     */
    public String downloadFile(String url){
        return null;
    }


}
