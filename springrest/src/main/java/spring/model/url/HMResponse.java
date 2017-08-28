package spring.model.url;

/**
 * Created by twx on 2017/8/23.
 */
public class HMResponse extends LoginResponse{

    private String MU = "https://%s.webex.com.cn/%s/m.php?AT=HM&MK=%s";
    private String KILL="https://%s.webex.com.cn/%s/w.php?AT=KM&MK=%s";
    private String killMeetingKey="";
    private boolean isShouldKill=false;

    public String getKillMeetingKey() {
        return this.killMeetingKey;
    }

    public void setKillMeetingKey(String killMeetingKey) {
        this.killMeetingKey = killMeetingKey;
    }

    public boolean isShouldKill() {
        return isShouldKill;
    }

    public void setShouldKill(boolean shouldKill) {
        isShouldKill = shouldKill;
    }

    public String getKILL() {
        return this.KILL;
    }

    public void setKILL(String siteName, String siteName1, String meetingKey) {
        this.KILL = String.format(this.KILL, siteName, siteName1,meetingKey);

    }

    public void setMU(String siteName, String siteName1, String meetingKey) {
        this.MU=String.format(this.MU, siteName, siteName1,meetingKey);
    }

    public String getMU() {
        return this.MU;
    }


    public static void main(String[] args) {
        HMResponse response = new HMResponse();
        response.setKILL("soyuan","soyuan","1111");
        System.out.println(response.getKILL());
    }

}
