import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import spring.config.HelloWorldConfiguration;
import spring.model.CreateMeetingResponse;
import spring.service.XmlGenerateService;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by twx on 2017/8/22.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HelloWorldConfiguration.class})
@WebAppConfiguration
public class TestXMLGenerator {

    @Autowired
    private  XmlGenerateService xgu;

    @Test
    public void testDoc2MeetingDetail() {
        CreateMeetingResponse md = xgu.respone2CreateMeetingResponse("<serv:message xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\" xmlns:com=\"http://www.webex.com/schemas/2002/06/common\" xmlns:meet=\"http://www.webex.com/schemas/2002/06/service/meeting\" xmlns:att=\"http://www.webex.com/schemas/2002/06/service/attendee\"><serv:header><serv:response><serv:result>SUCCESS</serv:result><serv:gsbStatus>PRIMARY</serv:gsbStatus></serv:response></serv:header><serv:body><serv:bodyContent xsi:type=\"meet:createMeetingResponse\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><meet:meetingkey>185547549</meet:meetingkey><meet:iCalendarURL><serv:host>https://soyuan.webex.com.cn/soyuan/j.php?MTID=mcd9ccbbdbb990b026bd744bb8e424f18</serv:host><serv:attendee>https://soyuan.webex.com.cn/soyuan/j.php?MTID=m9f3c7f6dc97fec909ec29d6ad35022c1</serv:attendee></meet:iCalendarURL><meet:guestToken>87000596da6d2770302dfadcb4e2a9c1</meet:guestToken></serv:bodyContent></serv:body></serv:message>");
    }

    @Test
    public void testDoc2GetMeetingResponse() {
        xgu.response2GetMeetingResponse("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<serv:message xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\" xmlns:com=\"http://www.webex.com/schemas/2002/06/common\" xmlns:meet=\"http://www.webex.com/schemas/2002/06/service/meeting\" xmlns:att=\"http://www.webex.com/schemas/2002/06/service/attendee\"><serv:header><serv:response><serv:result>SUCCESS</serv:result><serv:gsbStatus>PRIMARY</serv:gsbStatus></serv:response></serv:header><serv:body><serv:bodyContent xsi:type=\"meet:getMeetingResponse\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><meet:accessControl><meet:listToPublic>false</meet:listToPublic><meet:isPublic>false</meet:isPublic><meet:meetingPassword>123456</meet:meetingPassword></meet:accessControl><meet:metaData><meet:confName>TestByTWX</meet:confName><meet:meetingType>156</meet:meetingType><meet:agenda>Test</meet:agenda><meet:invitation></meet:invitation><meet:isInternal>false</meet:isInternal></meet:metaData><meet:participants><meet:maxUserNumber>2</meet:maxUserNumber><meet:attendees><meet:attendee><att:person><com:name>admin</com:name><com:firstName>admin</com:firstName><com:address><com:addressType>PERSONAL</com:addressType></com:address><com:phones/><com:email>843571091@qq.com</com:email><com:type>VISITOR</com:type></att:person><att:contactID>945793342</att:contactID><att:joinStatus>INVITE</att:joinStatus><att:meetingKey>182468596</att:meetingKey><att:language>SIMPLIFIED CHINESE</att:language><att:role>ATTENDEE</att:role><att:languageID>3</att:languageID></meet:attendee><meet:attendee><att:person><com:name>admin</com:name><com:firstName>admin</com:firstName><com:address><com:addressType>PERSONAL</com:addressType></com:address><com:phones/><com:email>twx843571091@gmail.com</com:email><com:type>VISITOR</com:type></att:person><att:contactID>945793347</att:contactID><att:joinStatus>INVITE</att:joinStatus><att:meetingKey>182468596</att:meetingKey><att:language>SIMPLIFIED CHINESE</att:language><att:role>ATTENDEE</att:role><att:languageID>3</att:languageID></meet:attendee></meet:attendees></meet:participants><meet:enableOptions><meet:chat>true</meet:chat><meet:poll>true</meet:poll><meet:audioVideo>true</meet:audioVideo><meet:attendeeList>true</meet:attendeeList><meet:fileShare>true</meet:fileShare><meet:presentation>true</meet:presentation><meet:applicationShare>true</meet:applicationShare><meet:desktopShare>true</meet:desktopShare><meet:webTour>true</meet:webTour><meet:meetingRecord>true</meet:meetingRecord><meet:annotation>false</meet:annotation><meet:importDocument>false</meet:importDocument><meet:saveDocument>false</meet:saveDocument><meet:printDocument>false</meet:printDocument><meet:pointer>false</meet:pointer><meet:switchPage>false</meet:switchPage><meet:fullScreen>false</meet:fullScreen><meet:thumbnail>false</meet:thumbnail><meet:zoom>false</meet:zoom><meet:copyPage>false</meet:copyPage><meet:rcAppShare>true</meet:rcAppShare><meet:rcDesktopShare>true</meet:rcDesktopShare><meet:rcWebTour>true</meet:rcWebTour><meet:javaClient>false</meet:javaClient><meet:nativeClient>false</meet:nativeClient><meet:attendeeRecordMeeting>false</meet:attendeeRecordMeeting><meet:voip>true</meet:voip><meet:faxIntoMeeting>false</meet:faxIntoMeeting><meet:enableReg>false</meet:enableReg><meet:supportQandA>true</meet:supportQandA><meet:supportFeedback>true</meet:supportFeedback><meet:supportBreakoutSessions>false</meet:supportBreakoutSessions><meet:supportPanelists>true</meet:supportPanelists><meet:supportRemoteComputer>false</meet:supportRemoteComputer><meet:supportShareWebContent>true</meet:supportShareWebContent><meet:supportUCFWebPages>false</meet:supportUCFWebPages><meet:supportUCFRichMedia>false</meet:supportUCFRichMedia><meet:autoDeleteAfterMeetingEnd>true</meet:autoDeleteAfterMeetingEnd><meet:viewAnyDoc>false</meet:viewAnyDoc><meet:viewAnyPage>false</meet:viewAnyPage><meet:allowContactPrivate>false</meet:allowContactPrivate><meet:chatHost>false</meet:chatHost><meet:chatPresenter>false</meet:chatPresenter><meet:chatAllAttendees>false</meet:chatAllAttendees><meet:multiVideo>false</meet:multiVideo><meet:notes>true</meet:notes><meet:closedCaptions>false</meet:closedCaptions><meet:singleNote>false</meet:singleNote><meet:sendFeedback>false</meet:sendFeedback><meet:displayQuickStartHost>true</meet:displayQuickStartHost><meet:displayQuickStartAttendees>false</meet:displayQuickStartAttendees><meet:supportE2E>false</meet:supportE2E><meet:supportPKI>false</meet:supportPKI><meet:HQvideo>true</meet:HQvideo><meet:HDvideo>true</meet:HDvideo><meet:viewVideoThumbs>true</meet:viewVideoThumbs></meet:enableOptions><meet:schedule><meet:startDate>08/26/2017 10:10:10</meet:startDate><meet:timeZoneID>45</meet:timeZoneID><meet:timeZone>GMT+08:00, China (Beijing)</meet:timeZone><meet:duration>60</meet:duration><meet:openTime>0</meet:openTime><meet:hostWebExID>luxf@soyuan.com.cn</meet:hostWebExID><meet:showFileStartMode>false</meet:showFileStartMode><meet:showFileContPlayFlag>false</meet:showFileContPlayFlag><meet:showFileInterVal>0</meet:showFileInterVal><meet:entryExitTone>0</meet:entryExitTone><meet:extNotifyTime>0</meet:extNotifyTime><meet:joinTeleconfBeforeHost>false</meet:joinTeleconfBeforeHost><meet:firstAttendeeAsPresenter>false</meet:firstAttendeeAsPresenter></meet:schedule><meet:telephony><meet:telephonySupport>NONE</meet:telephonySupport></meet:telephony><meet:tracking/><meet:repeat><meet:repeatType>NO_REPEAT</meet:repeatType></meet:repeat><meet:remind/><meet:attendeeOptions><meet:request>false</meet:request><meet:registration>false</meet:registration><meet:auto>false</meet:auto><meet:participantLimit>0</meet:participantLimit><meet:excludePassword>false</meet:excludePassword><meet:joinRequiresAccount>false</meet:joinRequiresAccount></meet:attendeeOptions><meet:meetingkey>182468596</meet:meetingkey><meet:status>NOT_INPROGRESS</meet:status><meet:hostJoined>false</meet:hostJoined><meet:participantsJoined>false</meet:participantsJoined><meet:telePresence>false</meet:telePresence><meet:hostKey>521524</meet:hostKey><meet:eventID>24264547</meet:eventID><meet:guestToken>f6e4defd3e7c62bbedfc93251429fc12</meet:guestToken><meet:hostType>1019001</meet:hostType></serv:bodyContent></serv:body></serv:message>");
    }


    @Test
    public void testSetMeetingResponse() {
        String response = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<serv:message xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\" xmlns:com=\"http://www.webex.com/schemas/2002/06/common\" xmlns:meet=\"http://www.webex.com/schemas/2002/06/service/meeting\" xmlns:att=\"http://www.webex.com/schemas/2002/06/service/attendee\"><serv:header><serv:response><serv:result>FAILURE</serv:result><serv:reason>Incorrect user or password</serv:reason><serv:gsbStatus>PRIMARY</serv:gsbStatus><serv:exceptionID>030002</serv:exceptionID></serv:response></serv:header><serv:body><serv:bodyContent/></serv:body></serv:message>";
        Pattern pattern = Pattern.compile("<serv:result>(\\w+)</serv:result>");
        Matcher matcher = pattern.matcher(response);

        String res="{\"result\":";
        if (matcher.find()) {
            System.out.println(matcher.group(1));
            res+="\""+matcher.group(1)+"\"";
        }
        res+=",\"reason\": \"";
        Matcher matcher1 = Pattern.compile("<serv:reason>(\\D*)</serv:reason>").matcher(response);
        if (matcher1.find()) {
            System.out.println(matcher1.group(1));
            res+=matcher1.group(1);
        }
        res+="\"}";
        System.out.println(res);
    }
}
