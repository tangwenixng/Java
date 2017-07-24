package com.douyu;

import com.util.EmailUtil;
import org.apache.commons.mail.EmailException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by twx on 2017/7/24.
 */
public class Notify {
    /**
     * 判断当前房间是否正在直播
     * @param roomId
     * @return
     * @throws IOException
     */
    public boolean isLiving(String roomId) throws IOException {
        Document doc = Jsoup.connect("https://www.douyu.com/"+roomId).get();
        //当前没有很直观的方法判断是否主播在直播，
        //所以我分析了下 直播中和未直播的 html文件
        //发现未直播的主播，会有一个'上次直播'的div,所以这里这样处理
        Elements eles = doc.getElementsByClass("time-box");
        if (eles.size()!=0)
            return false;
        return true;
    }

    public static void main(String[] args) {
        Notify notify = new Notify();

        new Thread(() -> {
            while (true) {
                Thread currentThread = Thread.currentThread();
                System.out.println(currentThread.getName()+" is monitoring....");
                try {
                    boolean isLiving = notify.isLiving("196");
                    if (isLiving) {
                        EmailUtil.sendEmail("twx843571091@gmail.com");
                        currentThread.sleep(1000*60*60*1);
                    }else{
                        currentThread.sleep(1000*60*10);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (EmailException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("main has runned....");
    }

}
