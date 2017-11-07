package proxy;

/**
 * Created by twx on 2017/11/7.
 */
public class TestProxy {
    public static void main(String[] args) {
//        DynamicSubject ds = new DynamicSubject();
//        Subject sb = (Subject)ds.getProxy(new SubjectImpl());
//        //sb其实是一个代理类对象
//        //调用hello()的时候实际上是调用 super.h.invoke(this, m4, new Object[]{var1});
//        //也就是回调了DynamicSubject的 invoke方法
//        sb.hello("twx");

        //获取代理类的class
        ProxyGeneratorUtils.writeProxyClassToHardDisk("D:/$Proxy11.class");

    }
}
