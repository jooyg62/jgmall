package com.cafe24.config.app;

import java.util.Calendar;
import java.util.Date;

public class test {

	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		int i = calendar.get(Calendar.MILLISECOND);
		
		System.out.println(i);

	}

}
