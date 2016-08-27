package com.dwlijx.bugger;

import java.util.HashSet;
import java.util.Set;

/**
 * 处理收集到的url：判断是够已经处理过，是则不处理；判断是不是已经加入队列，是则不处理。
 * 关键步骤：保证处理的url的唯一性
 * Created by hadoop on 2016/8/27.
 */
public class LinkQueue {
    //已访问url的集合
    private static Set visitedUrl = new HashSet();
    //待访问url的集合
    private static Queue unvisitedUrl = new Queue();
    //获得url队列
    public static Queue getUnvisitedUrl(){
        return unvisitedUrl;
    }
    //添加到访问过的url队列
    public static void addVisitedUrl(String url){
        visitedUrl.add(url);
    }
    //移除访问过的url
    public static void removeVisitedUrl(String url){
        visitedUrl.remove(url);
    }
    //未访问的url出队列
    public static Object unVisitedUrlDeQueue(){
        return unvisitedUrl.deQueue();
    }
    //保证每个url只被访问一次.url分发
    public static void addUnvisitedUrl (String url){
        if(url !=null && !url.trim().equals("")
                && !visitedUrl.contains(url)
                && !unvisitedUrl.isContain(url)){
            unvisitedUrl.enQueue(url);
        }
    }
    //获得已访问的url的数目
    public static int getVisitedUrlNum(){
        return visitedUrl.size();
    }
    //判断未访问的url队列是否为空
    private static boolean unVisitedUrlsEmpty(){
        return unvisitedUrl.isQueueEmpty();
    }
}
