package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.service.HttpClientService;
import spring.service.XmlGenerateService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twx on 2017/8/21.
 */
@RestController
@RequestMapping("/api/xml")
public class WebexXmlController {

    @Autowired
    private XmlGenerateService xgu;

    /**
     * 创建会议室
     * @param cm
     * @return
     */
    @RequestMapping(value = "/createMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CreateMeetingResponse createMeeting(@RequestBody CreateMeetingRequest cm) {
//        System.out.println("start...");
//        System.out.println("size "+cm.getConfName());
        String requestxml = xgu.createMeetingReq("/createMeetingRequest.xml",cm);
//        System.out.println(requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
//        System.out.println(responexml);
        CreateMeetingResponse md = xgu.respone2MeetingDetail(responexml);
        return  md;
    }

    /**
     * 获取单个会议室
     * @param gm
     * @return
     */
    @RequestMapping(value = "/getMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public GetMeetingResponse getMeeting(@RequestBody GetMeetingRequest gm) {
        String requestxml = xgu.getMeetingReq("/getMeetingRequest.xml", gm);
//        System.out.println(requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
//        System.out.println(responexml);
        return xgu.response2GetMeetingResponse(responexml);
    }

    /**
     * 修改会议室
     */
    @RequestMapping(value = "/setMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public String setMeeting(@RequestBody SetMeetingRequest sm) {
        String requestxml = xgu.setMeetingReq("/setMeetingRequest.xml", sm);
//        System.out.println(requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
//        System.out.println(responexml);

        String res="{\"result\":";
        Matcher matcher = Pattern.compile("<serv:result>(\\w+)</serv:result>").matcher(responexml);
        if (matcher.find()) {
            res+="\""+matcher.group(1)+"\"";
        }
        res+=",\"reason\": \"";
        Matcher matcher1 = Pattern.compile("<serv:reason>(\\D*)</serv:reason>").matcher(responexml);
        if (matcher1.find()) {
            System.out.println(matcher1.group(1));
            res+=matcher1.group(1);
        }
        res+="\"}";
        return res;
    }

    /**
     * 取消/删除会议
     * @param dm
     */
    @RequestMapping(value = "/deleteMeeting",method = RequestMethod.POST)
    public String deleteMeeting(@RequestBody GetMeetingRequest dm) {
        String requestxml = xgu.getMeetingReq("/deleteMeetingRequest.xml", dm);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);

        String res="{\"result\":";
        Matcher matcher = Pattern.compile("<serv:result>(\\w+)</serv:result>").matcher(responexml);
        if (matcher.find()) {
            res+="\""+matcher.group(1)+"\"";
        }
        res+=",\"reason\": \"";
        Matcher matcher1 = Pattern.compile("<serv:reason>(\\D*)</serv:reason>").matcher(responexml);
        if (matcher1.find()) {
            System.out.println(matcher1.group(1));
            res+=matcher1.group(1);
        }
        res+="\"}";
//        System.out.println("delete Status "+res);
        return res;
    }

    @RequestMapping(value = "/listMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void getListMeeting(@RequestBody SecurityContext sc) {
        String requestxml = xgu.getListMeetingReq("listMeetingRequest.xml",sc);
        System.out.println(requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
//        System.out.println(responexml);
    }

}
