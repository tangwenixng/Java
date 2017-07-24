package com.util;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 * Created by twx on 2017/7/24.
 */
public class EmailUtil {

    public static void sendEmail(String to_email) throws EmailException {
        Email email = new SimpleEmail();
        email.setCharset("utf-8");
        email.setHostName("smtp.163.com");
        email.setSmtpPort(994);
        email.setAuthenticator(new DefaultAuthenticator("jianrenxing00@163.com", "474913884fgh"));
        email.setSSL(true);
        email.setFrom("jianrenxing00@163.com");
        email.setSubject("小缘开播了！！！");
        email.setMsg("小缘开播了，赶紧来看吧--"+"https://www.douyu.com/196");
        email.addTo(to_email);
        email.send();
        System.out.println("发送成功....");
    }
}
