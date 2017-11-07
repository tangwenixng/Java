package spring.model;

import org.slf4j.Logger;

/**
 * 获取会议、删除会议、查询录像 通用
 * Created by twx on 2017/8/22.
 */
public class GetMeetingRequest extends SecurityContext {

    private String meetingKey;

    public String getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(String meetingKey) {
        this.meetingKey = meetingKey;
    }

    @Override
    public boolean checkSelf(Logger logger) {
        boolean parent = super.checkSelf(logger);
        if (parent) {
            if (meetingKey == "") {
                logger.error("meetingKey is null");
                return false;
            }
            return true;
        }
        return false;
    }
}
