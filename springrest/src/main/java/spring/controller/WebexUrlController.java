package spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.model.CreateMeetingResponse;
import spring.model.url.*;
import spring.service.HttpClientService;

import java.util.List;

/**
 * Created by twx on 2017/8/23.
 */
@RestController
@RequestMapping("/api/url")
public class WebexUrlController {
    private static final Logger logger = LoggerFactory.getLogger(WebexUrlController.class);
    /**
     * 开始会议
     * @param ur
     * @return
     */
    @RequestMapping(value = "/getHMObj",method = RequestMethod.POST)
    public ResponseEntity<HMResponse> getHMJson(@RequestBody UrlRequest ur) {
        if (!ur.checkSelf(logger)) {
            logger.error(ur.getClass().getName()+" checkSelf() not passBad Request---Bad Request");
            return new ResponseEntity<>((HMResponse) null, HttpStatus.BAD_REQUEST);
        }
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
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    /**
     * 获取会议状态
     * @param meetingKey
     * @return
     */
    @RequestMapping(value = "/getMeetingStatus",method = RequestMethod.GET)
    public String getMeetingStatus(@RequestParam String meetingKey){
        if (meetingKey == "") {
            logger.error("getMeetingStatus is null");
            return "MeetingKey is null";
        }
        String[] response =  HttpClientService.getMeetingStatusRes("https://soyuan.webex.com.cn/soyuan/w.php",meetingKey);
        return "{\"result\": \"" + response[0] + "\",\"status\":\"" + response[1] + "\"}";
    }

    /**
     * 加会
     * @return
     */
    @RequestMapping(value = "/getJMUrl",method = RequestMethod.POST)
    public ResponseEntity<JoinMeetingResponse> getJMUrl(@RequestBody JoinMeetingRequest jm) {
        if (!jm.checkSelf(logger)) {
            logger.error(jm.getClass().getName()+" checkSelf() not passBad Request---Bad Request");
            return new ResponseEntity<>((JoinMeetingResponse) null, HttpStatus.BAD_REQUEST);
        }
        JoinMeetingResponse jmr = new JoinMeetingResponse();
        jmr.setAction(String.format("https://%s.webex.com.cn/%s/m.php",jm.getSiteName(),jm.getSiteName()));
        jmr.setMK(jm.getMeetingKey());
        jmr.setAN(jm.getUserName());
        jmr.setAE(jm.getEmailAddress());
        return new ResponseEntity<>(jmr,HttpStatus.OK);
    }

    @RequestMapping(value = "/getKMObj",method = RequestMethod.POST)
    public ResponseEntity<KMResponse> getKMUrl(@RequestBody UrlRequest ur) {
        if (ur.checkSelf(logger)) {
            logger.error(ur.getClass().getName()+" checkSelf() not passBad Request---Bad Request");
            return new ResponseEntity<>((KMResponse) null, HttpStatus.BAD_REQUEST);
        }
        KMResponse response = new KMResponse();
        String siteName = ur.getSiteName();
        response.setAction(siteName);
        response.setWID(ur.getWebExId());
        response.setPW(ur.getPassword());
        response.setMU(siteName,siteName,ur.getMeetingKey());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
