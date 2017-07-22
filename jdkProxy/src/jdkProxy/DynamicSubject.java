package jdkProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicSubject implements InvocationHandler {
	private Object sub;
	
	 public Object getProxy(Object sub) {  
        this.sub = sub;  
        //取得代理对象  
        return Proxy.newProxyInstance(sub.getClass().getClassLoader(),  
        		sub.getClass().getInterfaces(), this); 
    }  
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("before calling 1:" + method);
		System.out.println("before calling 2:" + proxy.getClass().getName());
	    method.invoke(sub,args);
	    System.out.println("after calling " + method);
	    return null;
	}

}
