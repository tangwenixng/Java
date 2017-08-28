package spring.model;

/**
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
}
