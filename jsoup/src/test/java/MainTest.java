import com.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * jsoup是一个类似javascript的工具包，用来操作DOM
 * 它的API和js很像
 * 英文cookbook:https://jsoup.org/cookbook
 * 中文翻译: http://www.cnblogs.com/jycboy/p/jsoupdoc.html
 * Created by twx on 2017/7/22.
 */
public class MainTest {
    /***************继承关系***********************/
    /*****Document extends Element extends Node. TextNode extends Node.******/

    //解析一个html字符串
    @Test
    public void parseHTML() {
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        //parse有个重载方法parse(String html, String baseUri)
        //baseUri 用来把相对url解析成绝对url
        Document doc = Jsoup.parse(html);
        System.out.println(doc);
        assertNotNull(doc);
    }

    //把字符串解析成到body元素中
    @Test
    public void parseBodyFragment() {
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body.html());
        assertNotNull(body);
    }

    //使用Connection对象获取Document
    @Test
    public void parseConn() throws IOException {
        Connection conn = Jsoup.connect("http://www.baidu.com");
        Document doc = conn.get();
        Element head = doc.head();
        System.out.println(head);
        System.out.println("**************");
        Element body = doc.body();
        System.out.println(body);
        assertNotNull(body);
    }

    //遍历文档
    @Test
    public void traverseDocument() throws IOException {
        Document doc = Jsoup.connect("http://www.baidu.com").get();
        Elements alinks = doc.getElementsByTag("a");
        for (Element e : alinks) {
            String href = e.attr("href");
            String text = e.text();
            System.out.println("href: "+href+" text:"+text);
        }
    }

    @Test
    public void testDouyu196() throws IOException {
        Document doc = Jsoup.connect("https://www.douyu.com/4809").get();
//        System.out.println(doc);

        Elements eles = doc.getElementsByClass("time-box");
        for (Element e : eles) {
            System.out.println(e.html());
            System.out.println("****************************");
            String aVal = e.getElementsByTag("a").text();
            System.out.println(aVal);
        }
        System.out.println(eles.size());
    }

    @Test
    public void testSendEmail() throws EmailException {
        EmailUtil.sendEmail("twx843571091@gmail.com");
    }

}
