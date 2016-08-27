package com.dwlijx.bugger;

import org.apache.commons.httpclient.HttpClient;

/**
 * Created by hadoop on 2016/8/27.
 */
public class FirstBugger {
    public void fetcher(){
        HttpClient httpClient = new HttpClient() ;
        httpClient.getHostConfiguration().setProxy("198.0.0.1",9527);
    }


}
