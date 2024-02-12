package com.example.bank;

import java.time.Year;

public class Accountnum {
	public static String createaccnum() {
		Year yy=Year.now();
		int min=100000;
		int max=999999;
		int rand=(int)Math.floor(Math.random()*(max-min)+min);
		StringBuilder ss=new StringBuilder();
		return ss.append(yy).append(rand).toString();
		
		
	}

}
