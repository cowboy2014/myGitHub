import chapter01.HtmlparserTool;
import chapter01.LinkFilter;

/**
 * Created by Administrator on 2016/8/28.
 */
public class Test {
    public static void main(String[] args) {
        HtmlparserTool htmlparserTool = new HtmlparserTool();
        LinkFilter linkFilter = new LinkFilter() {
            @Override
            public boolean accept(String url) {
                return true;
            }
        };
        HtmlparserTool.extractLinks("www.baidu.com",linkFilter);
    }
}
