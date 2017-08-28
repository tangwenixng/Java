package spring.model.url;

/**
 * Created by twx on 2017/8/23.
 */
public class KMResponse extends LoginResponse {
    private String MU = "https://%s.webex.com.cn/%s/w.php?AT=KM&MK=%s";

    public void setMU(String siteName,String siteName1,String meetingKey) {
        this.MU=String.format(this.MU, siteName, siteName1,meetingKey);
    }
    public String getMU() {
        return MU;
    }
}
