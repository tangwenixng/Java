package spring.model;

/**
 * Created by twx on 2017/8/21.
 */
public class CreateMeetingResponse {
    private String result;
    private String meetingKey;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(String meetingKey) {
        this.meetingKey = meetingKey;
    }
}
