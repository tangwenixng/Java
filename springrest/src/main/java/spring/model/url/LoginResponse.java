package spring.model.url;

/**
 * Created by twx on 2017/8/23.
 */
public class LoginResponse {
    private String action="https://%s.webex.com.cn/%s/p.php";
    private String AT="LI";
    private String WID;
    private String PW;

    public String getAction() {
        return action;
    }

    public void setAction(String siteName) {
        this.action = String.format(this.action, siteName,siteName);
    }

    public String getAT() {
        return AT;
    }

    public void setAT(String AT) {
        this.AT = AT;
    }

    public String getWID() {
        return WID;
    }

    public void setWID(String WID) {
        this.WID = WID;
    }

    public String getPW() {
        return PW;
    }

    public void setPW(String PW) {
        this.PW = PW;
    }
}
