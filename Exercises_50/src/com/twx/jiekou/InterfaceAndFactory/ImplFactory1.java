package com.twx.jiekou.InterfaceAndFactory;

public class ImplFactory1 implements ServiceFactory {

	@Override
	public Service getService() {
		// TODO Auto-generated method stub
		return new Impl1();
	}

}
