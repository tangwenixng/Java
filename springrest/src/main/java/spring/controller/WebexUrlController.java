package spring.controller;

import org.springframework.web.bind.annotation.*;
import spring.model.url.*;
import spring.service.HttpClientService;

import java.util.List;

/**
 * Created by twx on 2017/8/23.
 */
@RestController
@RequestMapping("/api/url")
public class WebexUrlController {

    /**
     * 开始会议
     * @param ur
     * @return
     */
    @RequestMapping(value = "/getHMObj",method = RequestMethod.POST)
    public HMResponse getHMJson(@RequestBody UrlRequest ur) {
//        System.out.println("jjjjjj");
        HMResponse response = new HMResponse();
        String siteName = ur.getSiteName();//站点名称

        List<String> preKeys = ur.getPreMeetingKeys();
        if (preKeys != null && preKeys.size() > 0) {
            for (String preKey : preKeys) {
                String[] arr = HttpClientService.getMeetingStatusRes("https://soyuan.webex.com.cn/soyuan/w.php",preKey);
                //在开会
                if (arr[1].equalsIgnoreCase("INPROGRESS")){
                    response.setShouldKill(true);
                    response.setKILL(siteName,siteName,preKey);
                    break;
                }
            }
        }
        response.setAction(siteName);
        response.setWID(ur.getWebExId());
        response.setPW(ur.getPassword());
        response.setMU(siteName,siteName,ur.getMeetingKey());
        return response;
    }

    /**
     * 获取会议状态
     * @param meetingKey
     * @return
     */
    @RequestMapping(value = "/getMeetingStatus",method = RequestMethod.GET)
    public String getMeetingStatus(@RequestParam String meetingKey){
        String[] response =  HttpClientService.getMeetingStatusRes("https://soyuan.webex.com.cn/soyuan/w.php",meetingKey);
        return "{\"result\": \"" + response[0] + "\",\"status\":\"" + response[1] + "\"}";
    }

    /**
     * 加会
     * @return
     */
    @RequestMapping(value = "/getJMUrl",method = RequestMethod.POST)
    public JoinMeetingResponse getJMUrl(@RequestBody JoinMeetingRequest jm) {
        JoinMeetingResponse jmr = new JoinMeetingResponse();
        jmr.setAction(String.format("https://%s.webex.com.cn/%s/m.php",jm.getSiteName(),jm.getSiteName()));
        jmr.setMK(jm.getMeetingKey());
        jmr.setAN(jm.getUserName());
        jmr.setAE(jm.getEmailAddress());
        return jmr;
    }

    @RequestMapping(value = "/getKMObj",method = RequestMethod.POST)
    public KMResponse getKMUrl(@RequestBody UrlRequest ur) {
        System.out.println("hhh");
        KMResponse response = new KMResponse();
        String siteName = ur.getSiteName();
        response.setAction(siteName);
        response.setWID(ur.getWebExId());
        response.setPW(ur.getPassword());
        response.setMU(siteName,siteName,ur.getMeetingKey());
        return response;
    }
}
