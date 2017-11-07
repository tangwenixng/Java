package spring.model.url;

import org.slf4j.Logger;
import spring.model.SecurityContext;

import java.util.List;

/**
 * Created by twx on 2017/8/23.
 */
public class UrlRequest extends SecurityContext {
    private String meetingKey;
    private List<String> preMeetingKeys;

    public List<String> getPreMeetingKeys() {
        return preMeetingKeys;
    }

    public void setPreMeetingKeys(List<String> preMeetingKeys) {
        this.preMeetingKeys = preMeetingKeys;
    }

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
        }
        return parent;
    }
}
