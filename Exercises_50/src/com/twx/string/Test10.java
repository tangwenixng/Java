package com.twx.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test10 {
	public static void main(String[] args) {
		String s="Java now has regular expressions";
		Pattern  pattern=Pattern.compile("J");
		Matcher matcher=pattern.matcher(s);
		System.out.println(matcher.replaceAll(""));
	}
}
