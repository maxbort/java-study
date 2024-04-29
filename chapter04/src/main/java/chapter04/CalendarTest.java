package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calendar.getInstance();
		
		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
		TimeZone tz = TimeZone.getDefault(); // 현재 시스템 기반으로 가져옴
		System.out.println(aLocale + ":" + tz);

		
		System.out.println();
				
	}

}
