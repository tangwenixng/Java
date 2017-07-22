package com.twx.inner;

public class TestParcel4 {
	public static void main(String[] args) {
		Parcel4 parcel4=new Parcel4();
		Contents contents = parcel4.contents();
		Destination destination = parcel4.destination("James");
	}
}
