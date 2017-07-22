package com.twx.jiekou;
/**
 * ÊÊÅäÆ÷Ä£Ê½
 * @author twx
 *
 */
public class FilterAdapter implements Processor {
	Filter f;
	
	public FilterAdapter(Filter f) {
		super();
		this.f = f;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return f.name();
	}

	@Override
	public Waveform process(Object input) {
		// TODO Auto-generated method stub
		return f.process((Waveform) input);
	}

}
