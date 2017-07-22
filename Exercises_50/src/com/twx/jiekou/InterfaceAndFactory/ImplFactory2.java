package com.twx.jiekou.InterfaceAndFactory;

public class ImplFactory2 implements ServiceFactory {

	@Override
	public Service getService() {
		// TODO Auto-generated method stub
		return new Impl2();
	}

}
