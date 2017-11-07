package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.*;
import spring.service.HttpClientService;
import spring.service.XmlGenerateService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twx on 2017/8/21.
 */
@RestController
@RequestMapping("/api/xml")
public class WebexXmlController {

    private static final Logger logger = LoggerFactory.getLogger(WebexXmlController.class);

    @Autowired
    private XmlGenerateService xgu;
    /**
     * 创建会议室
     * @param cm
     * @return
     */
    @RequestMapping(value = "/createMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CreateMeetingResponse>  createMeeting(@RequestBody CreateMeetingRequest cm) {
        if (!cm.checkSelf(logger)) {
            logger.error(cm.getClass().getName()+" checkSelf() not passBad Request---Bad Request");
            return new ResponseEntity<>((CreateMeetingResponse) null, HttpStatus.BAD_REQUEST);
        }
        String requestxml = xgu.createMeetingReq("/createMeetingRequest.xml",cm);
        logger.debug("createMeeting requestxml: "+requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
        logger.debug("createMeeting responexml"+responexml);
         CreateMeetingResponse md = xgu.respone2CreateMeetingResponse(responexml);
        return  new ResponseEntity<>(md,HttpStatus.OK);
    }

    /**
     * 获取单个会议室
     * @param gm
     * @return
     */
    @RequestMapping(value = "/getMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GetMeetingResponse> getMeeting(@RequestBody GetMeetingRequest gm) {
        if (!gm.checkSelf(logger)) {
            logger.error(gm.getClass().getName()+" checkSelf() not pass--Bad Request");
            return new ResponseEntity<>((GetMeetingResponse) null, HttpStatus.BAD_REQUEST);
        }
        String requestxml = xgu.getMeetingReq("/getMeetingRequest.xml", gm);
        logger.debug("getMeeting requestxml"+requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
        logger.debug("getMeeting responexml"+responexml);
        GetMeetingResponse gmr = xgu.response2GetMeetingResponse(responexml);
        return new ResponseEntity<>(gmr,HttpStatus.OK);
    }

    /**
     * 修改会议室
     */
    @RequestMapping(value = "/setMeeting",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> setMeeting(@RequestBody SetMeetingRequest sm) {
        if (!sm.checkSelf(logger)) {
            logger.error(sm.getClass().getName()+" checkSelf() not pass--Bad Request");
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        String requestxml = xgu.setMeetingReq("/setMeetingRequest.xml", sm);
        logger.debug("setMeeting request"+requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
        logger.debug("setMeeting response"+responexml);
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
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    /**
     * 取消/删除会议
     * @param dm
     */
    @RequestMapping(value = "/deleteMeeting",method = RequestMethod.POST)
    public ResponseEntity<String> deleteMeeting(@RequestBody GetMeetingRequest dm) {
        if (!dm.checkSelf(logger)) {
            logger.error(dm.getClass().getName()+" checkSelf() not pass--Bad Request");
            return new ResponseEntity<>("Bad Request", HttpStatus.BAD_REQUEST);
        }
        String requestxml = xgu.getMeetingReq("/deleteMeetingRequest.xml", dm);
        logger.debug(" deleteMeeting requestxml :"+requestxml);
        String responexml = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
        logger.debug("deleteMeeting responexml :"+responexml);
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
        return new ResponseEntity<>(res,HttpStatus.OK);
    }

    @RequestMapping(value = "/listRecording",method = RequestMethod.POST)
    public List<MeetingRecord> listRecording(@RequestBody List<GetMeetingRequest> listRecords) {
        List<MeetingRecord> mrLists = new ArrayList<>();
        for (GetMeetingRequest recordReq : listRecords) {
            String header = header(recordReq.getSiteName(), recordReq.getWebExId(), recordReq.getPassword());
            String body = LstRecordingBody(recordReq.getMeetingKey());
            String requestxml = header+body;
//            System.out.println("request: "+requestxml);
            String response = HttpClientService.doPost("https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService",requestxml);
//            System.out.println("response: "+response);
            List<MeetingRecord> tempList =  xgu.response2MeetingRecord(response);
            if (tempList != null) {
                mrLists.addAll(tempList);
            }
        }
        return mrLists;
    }

    private String header(String siteName,String webexId,String pwd) {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
                .append("<serv:message xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n")
                .append("<header>\n<securityContext>\n")
                .append("<siteName>").append(siteName).append("</siteName>")
                .append("<webExID>").append(webexId).append("</webExID>")
                .append("<password>").append(pwd).append("</password>")
                .append("</securityContext>").append("</header>");
        return sb.toString();
    }

    private String LstRecordingBody(String meetingKey) {
        StringBuilder sb = new StringBuilder();
        sb.append("<body>\n<bodyContent xsi:type=\"java:com.webex.service.binding.ep.LstRecording\">")
                .append("<listControl><startFrom>0</startFrom><maximumNum>10</maximumNum>")
                .append("</listControl>")
                .append("<sessionKey>").append(meetingKey).append("</sessionKey>")
                .append("</bodyContent></body></serv:message>");
        return sb.toString();
    }
}
