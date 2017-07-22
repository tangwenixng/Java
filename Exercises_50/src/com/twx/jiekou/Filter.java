package com.twx.jiekou;

public class Filter {
	public String name(){
		return getClass().getSimpleName();
	}
	public Waveform process(Waveform input) {
		return input;
	}
	
}
class Waveform{
	private static long counter;
	private final long id=counter++;
	public String toString() {
		return "Waveform"+id;
	}
}

class LowPass extends Filter{
	double cutoff;

	public LowPass(double cutoff) {
		this.cutoff = cutoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}

class HighPass extends Filter{
	double cutoff;

	public HighPass(double cutoff) {
		this.cutoff = cutoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}

class BandPass extends Filter{
	double cutoff,highoff;

	public BandPass(double cutoff, double highoff) {
		super();
		this.cutoff = cutoff;
		this.highoff = highoff;
	}
	public Waveform process(Waveform input) {
		return input;
	}
}
