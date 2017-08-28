package spring.model.url;

/**
 * Created by twx on 2017/8/25.
 */
public class JoinMeetingResponse {
    private String action;
    private String AT="JM";
    private String MK;
    private String AN;
    private String AE;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAT() {
        return AT;
    }

    public void setAT(String AT) {
        this.AT = AT;
    }

    public String getMK() {
        return MK;
    }

    public void setMK(String MK) {
        this.MK = MK;
    }

    public String getAN() {
        return AN;
    }

    public void setAN(String AN) {
        this.AN = AN;
    }

    public String getAE() {
        return AE;
    }

    public void setAE(String AE) {
        this.AE = AE;
    }
}
