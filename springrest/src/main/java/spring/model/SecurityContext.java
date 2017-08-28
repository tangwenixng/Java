package spring.model;

/**
 * Created by twx on 2017/8/22.
 */
public class SecurityContext {
    private String siteName;
    private String webExId;
    private String password;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getWebExId() {
        return webExId;
    }

    public void setWebExId(String webExId) {
        this.webExId = webExId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
