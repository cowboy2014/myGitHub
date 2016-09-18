package com.dwlijx.httpClient;

/**
 * Created by hadoop on 2016/9/4.
 */
public class ClientTest {
    public static void main(String[] args) {
        HttpClientDealer dealer = new HttpClientDealer();
//        dealer.get();
        dealer.postForm();
    }
}
