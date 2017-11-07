package proxy;

/**
 * Created by twx on 2017/11/7.
 */
public class SubjectImpl implements Subject {
    @Override
    public void request() {
        System.out.println("SubjectImpl.....");
    }

    @Override
    public String response() {
        System.out.println("SubjectImpl Response....");
        return "response";
    }

    @Override
    public void hello(String name) {
        System.out.println("hello "+name);
    }
}
