//import javax.swing.text.html.parser.Parser;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
package chapter01;

import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.HashSet;
import java.util.Set;

/**
 * 用来从网页上获取URL
 * Created by Administrator on 2016/8/28.
 */
public class HtmlparserTool {
    //获取一个网站上的链接，filter用来过滤连接
    public static Set<String> extractLinks(String url ,LinkFilter filter){
        Set<String> links = new HashSet<String>();
        try {
            Parser parser = new Parser(url);
            if ("ISO-8859-1".equals(parser.getEncoding())) {
                parser.setEncoding("GB2312");
            }else{
                parser.setEncoding("UTF-8");
            }

            //过滤<frame>标签的filter,用来提取frame标签里的src属性
            NodeFilter frameFilter = new NodeFilter() {
                @Override
                public boolean accept(Node node) {
                    if(node.getText().startsWith("frame src=")){
                        return true;
                    }else{
                        return false;
                    }
                }
            };

            //OrFilter 来设置过滤<a>标签和<frame>标签
            OrFilter linkFilter = new OrFilter(new NodeClassFilter(
                    LinkTag.class),frameFilter);

            //得到所有经过过滤的标签
            NodeList list = parser.extractAllNodesThatMatch(linkFilter);
            for (int i = 0;i < list.size();i++){
                Node tag = list.elementAt(i);
                if(tag instanceof LinkTag)//<a>标签
                {
                    LinkTag link = (LinkTag) tag;
                    String linkUrl = link.getLink();
                    if(filter.accept(linkUrl))
                        links.add(linkUrl);
                }else// <frame>标签
                {
                    //提取frame里src属性的链接，如：<frame src="text.html">
                    String frame = tag.getText();
                    int start = frame.indexOf("src=");
                    frame = frame.substring(start);
                    int end = frame.indexOf(" ");
                    if(end == -1)
                        end = frame.indexOf(">");
                    String frameUrl = frame.substring(5,end - 1);
                    if (filter.accept(frameUrl))
                        links.add(frameUrl);
                }
            }
        } catch (ParserException e) {
            e.printStackTrace();
        }
        return links;
    }
}
