package spring.model.url;

/**
 * Created by twx on 2017/8/25.
 */
public class JoinMeetingRequest {
    private String siteName;
    private String meetingKey;
    private String emailAddress;
    private String userName;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getMeetingKey() {
        return meetingKey;
    }

    public void setMeetingKey(String meetingKey) {
        this.meetingKey = meetingKey;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
