package base.typecast;

/**
 * Created by twx on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
        B b = new B();
        C c = (C) b;
        c.a();
    }
}
