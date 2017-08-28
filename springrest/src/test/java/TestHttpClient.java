import org.junit.Test;
import spring.service.HttpClientService;
import static org.junit.Assert.*;

/**
 * Created by twx on 2017/8/25.
 */
public class TestHttpClient {
    /**
     * 测试获取会议状态
     */
    @Test
    public void testGetMS() {
        String url = "https://soyuan.webex.com.cn/soyuan/w.php";
        String[] res = HttpClientService.getMeetingStatusRes(url,"185458324");
        System.out.println(res[0]+" "+res[1]);
        assertEquals("NOT_INPROGRESS",res[1]);
    }

    /**
     * 测试Post
     */
    @Test
    public void testDoPost() {
        String url="https://soyuan.webex.com.cn/WBXService/xml8.0.0/XMLService";
        String postData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<serv:message xmlns:serv=\"http://www.webex.com/schemas/2002/06/service\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n" + "    <header>\n" + "        <securityContext>\n" + "            <siteName>soyuan</siteName>\n" + "            <webExID>luxf@soyuan.com.cn</webExID>\n" + "            <password>Tony8188</password>\n" + "        </securityContext>\n" + "    </header>\n" + "    <body>\n" + "        <bodyContent xsi:type=\"java:com.webex.service.binding.meeting.SetMeeting\">\n" + "            <metaData>\n" + "                <confName>" +
                "终极乱码9b</confName>\n" + "                <agenda>Test</agenda>\n" + "            </metaData>\n" + "            <enableOptions>\n" + "                <chat>false</chat>\n" + "                <poll>true</poll>\n" + "                <audioVideo>true</audioVideo>\n" + "            </enableOptions>\n" + "            <schedule>\n" + "                <startDate>09/03/2017 11:10:10</startDate>\n" + "                <duration>60</duration>\n" + "                <timeZone>GMT+08:00, China (Beijing)</timeZone>\n" + "            </schedule>\n" + "            <attendeeOptions>\n" + "                <auto>true</auto>\n" + "            </attendeeOptions>\n" + "            <meetingkey>185458324</meetingkey>\n" + "        </bodyContent>\n" + "    </body>\n" + "</serv:message>";
        String res = HttpClientService.doPost(url, postData);
        System.out.println(res);
        assertNotNull(res);
    }
}
