package com.twx.jiekou;
/**
 *   ≈‰ƒ£ Ω
 * @author twx
 *
 */
public class ElecProductAdapter implements Processor{
	private ElecProduct ep;
	public ElecProductAdapter(ElecProduct ep) {
		this.ep=ep;
	}
	@Override
	public String name() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName();
	}

	@Override
	public Object process(Object input) {
		// TODO Auto-generated method stub
		return ep.swap((String)input);
	}
	public static void main(String[] args) {
		String s="fdsfefp";
		Apply.process(new ElecProductAdapter(new ElecProduct()), s);
	}
}
