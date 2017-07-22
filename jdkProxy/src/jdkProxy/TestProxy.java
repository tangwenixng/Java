package jdkProxy;

public class TestProxy {
	public static void main(String[] args) {
		DynamicSubject ds = new DynamicSubject();
		Subject sb = (Subject)ds.getProxy(new RealSubject());
		sb.request();
		
	}
}
