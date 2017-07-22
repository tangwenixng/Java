package com.twx.inner;

public class Parcel5 {
	public Destination destination(String s){
		class MDestination implements Destination{
			private String label;
			public MDestination(String whereto) {
				this.label=whereto;
			}
			@Override
			public String readLabel() {
				return this.label;
			}
		}
		return new MDestination(s);
	}
	
	public static void main(String[] args) {
		Parcel5 parcel5=new Parcel5();
		Destination d =	 parcel5.destination("s");
	}
}
