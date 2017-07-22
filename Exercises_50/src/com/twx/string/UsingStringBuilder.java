package com.twx.string;

import java.util.Random;

public class UsingStringBuilder {
	public String toString(){
		StringBuilder sb=new StringBuilder("[");
		
		Random random=new Random(30);
		for(int i=0;i<20;i++){
			sb.append(random.nextInt(30));
			sb.append(", ");
		}
		sb.delete(sb.length()-2, sb.length());
		sb.append("]");
		
		return sb.toString();
	}
	public static void main(String[] args) {
		UsingStringBuilder u=new UsingStringBuilder();
		System.out.println(u);
	}
}
