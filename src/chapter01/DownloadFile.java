package chapter01;


import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

import java.io.*;

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
        try {
            //根据文件输出地址建立文件输出流
            DataOutputStream out= new DataOutputStream(new FileOutputStream(new File(filePath)));
            for (int i=0;i<data.length;i++){
                out.write(data[i]);
            }
            out.flush();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 构造方法：下载URL指定的网页
     * @param url
     * @return
     */
    public String downloadFile(String url){
        String filePath = null;
        //1.生成HttpClient对象并设置参数
        HttpClient httpClient = new HttpClient();
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);

        //2.生成GetMethod对象并设置参数
        GetMethod getMethod = new GetMethod(url);
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT,5000);
        //设置请求重试处理
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());

        //3.执行Http Get请求
        try {
            int statusCode = httpClient.executeMethod(getMethod);
            //判断状态码
            if (statusCode != HttpStatus.SC_OK){
                System.err.println("Method failed:"+getMethod.getStatusLine());
                filePath = null;
            }

            //4.处理Http响应内容
            byte[] responseBody = getMethod.getResponseBody();
            filePath = "E:\\east\\" + getFileNameByUrl(url,getMethod.getResponseHeader(
                            "Content-Type").getValue());
            saveToLocal(responseBody,filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            getMethod.releaseConnection();
        }
        return filePath;
    }


}
