package com.twx.jiekou;
/**
 *   ≈‰ƒ£ Ω
 * @author twx
 *
 */
public class ElecProductAdapter2 extends ElecProduct implements Processor{
	public ElecProductAdapter2() {
		
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

	@Override
	public Object process(Object input) {
		// TODO Auto-generated method stub
		return swap((String)input);
	}
	public static void main(String[] args) {
		String s="fdsfefp";
		Apply.process(new ElecProductAdapter2(), s);
	}
}
