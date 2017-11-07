package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by twx on 2017/11/7.
 */
public class DynamicSubject implements InvocationHandler {

    //委托对象  SubjectImpl
    private Object sub;

    /**
     * 获取代理对象
     * ????关键是怎么生成这个代理对象
     * @param sub
     * @return
     */
    public Object getProxy(Object sub) {
        this.sub = sub;
        System.out.println(sub.getClass().getClassLoader());
        //取得代理对象
        return Proxy.newProxyInstance(sub.getClass().getClassLoader(),
                sub.getClass().getInterfaces(), this);
    }

    /**
     * ?????该方法什么时候被调用(见TestProxy里的解释)
     * @param proxy 代理对象
     * @param method  被调用的方法
     * @param args  调用参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before calling 1:" + method);
        System.out.println("before calling 2:" + proxy.getClass().getName());
        method.invoke(sub,args);
        System.out.println("after calling " + method);
        return null;
    }
}
