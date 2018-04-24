package com.xiaohe66.demo.webcollector;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatum;
import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.jsoup.nodes.Element;

/**
 * @author xh
 * @date 18-04-02 002
 */
public class MyWebCollector extends BreadthCrawler {

    private static final String URL_START = "https://buy.cnooc.com.cn/cbjyweb/001/1.html";
    private static final String HOME_URL = "https://buy.cnooc.com.cn";
    private static final String URL = "https://buy.cnooc.com.cn/cbjyweb/001/*.html";

    private static final String LIST_TYPE = "list";
    private static final String CONTENT_TYPE = "content";

    private DataService dataService = new DataService();

    private int count;

    public MyWebCollector(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);

        int start = 1;
        int end = 1;
        for (int i = start; i <= end; i++) {
            this.addSeed(URL.replace("*", String.valueOf(i)), LIST_TYPE);
        }

        setThreads(50);
        setExecuteInterval(2000);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {
        String url = page.url();
        try {
            if (page.matchType(LIST_TYPE)) {
                for (Element element : page.select("#categorypagingcontent ul li")) {
                    String href = HOME_URL+element.select("a").attr("href");
                    String date = element.select("span").text();
                    crawlDatums.add(new CrawlDatum(href,CONTENT_TYPE).meta("date",date));
                }
            } else if (page.matchType(CONTENT_TYPE)) {
                String title = page.select(".article-title").text();
                String content = page.select(".article-Content").html();

                System.out.println("title="+title);
                System.out.println("content="+content);
                String date = page.meta("date");

                dataService.execute(url, title, content,date);
            } else {
                System.out.println("other");
            }
        } catch (Exception e) {
            System.out.println("有异常");
        }
    }
}
