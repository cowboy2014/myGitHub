package chapter01;

import java.util.Set;

/**
 * Created by Administrator on 2016/9/1.
 * 代码功能总结：可以实现对一个网站下相关网页的爬取，可以获取一整套的页面文件
 */
public class MyCrawler {
    /**
     * 使用种子初始化URL队列
     * @param seeds
     */
    private void initCrawlerEithSeeds(String[] seeds){
        for (int i = 0;i<seeds.length;i++){
            LinkQueue.addUnvisitedUrl(seeds[i]);
        }
    }

    /**
     * 抓取过程
     * @param seeds
     */
    public void crawling(String[] seeds, final String header){
        //定义过滤器，提取以http://www.lietu.com开头的连接
        LinkFilter filter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                if (url.startsWith(header)){
                    return true;
                }else {
                    return false;
                }
            }
        };
        //初始化URL队列
        initCrawlerEithSeeds(seeds);
        //循环条件：待抓取的连接不空且抓取的网页不多于1000
        while (!LinkQueue.unVisitedUrlsEmpty() && LinkQueue.getVisitedUrlNum()<=1000){
            //对头URL出队列
            String visitUrl = (String) LinkQueue.unVisitedUrlDeQueue();
            if (visitUrl == null) continue;
            DownloadFile downloader = new DownloadFile();
            //下载网页
            downloader.downloadFile(visitUrl);
            LinkQueue.addVisitedUrl(visitUrl);
            Set<String> links = HtmlparserTool.extractLinks(visitUrl,filter);
            //新的未访问的URL入队列
            for (String link : links){
                LinkQueue.addUnvisitedUrl(link);
            }
        }
    }

    public static void main(String[] args) {
        MyCrawler crawler = new MyCrawler();
        crawler.crawling(new String[] {"http://www.eastmoney.com/"},"http://www.eastmoney.com/");
    }
}
