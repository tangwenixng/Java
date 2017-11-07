package proxy;

/**
 * Created by twx on 2017/11/7.
 */
public interface Subject {
    public void request();
    public String response();
    public void hello(String name);
}
