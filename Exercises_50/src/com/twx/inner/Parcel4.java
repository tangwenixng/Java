package com.twx.inner;

public class Parcel4 {
	private class PContents implements Contents{
		private int i=11;
		@Override
		public int value() {
			return this.i;
		}
	}
	protected class PDestination implements Destination{
		private String label;
		public PDestination(String whereto) {
			this.label=whereto;
		}
		@Override
		public String readLabel() {
			return this.label;
		}
	}
	public Destination destination(String s) {
		return new PDestination(s);
	}
	public Contents contents() {
		return new PContents();
	}
}
