package chapter04;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Calendar.getInstance();
//		
//		Locale aLocale = Locale.getDefault(Locale.Category.FORMAT);
//		TimeZone tz = TimeZone.getDefault(); // 현재 시스템 기반으로 가져옴
//		System.out.println(aLocale + ":" + tz);
//
//		
//		System.out.println();
		
		Calendar cal = Calendar.getInstance();
		
		printDate(cal);
		
		cal.set(Calendar.YEAR, 2024);
		cal.set(Calendar.MONTH,11); // 12월
		cal.set(Calendar.DATE, 25);
		printDate(cal);
		
		cal.set(1998, 5, 25);
		cal.add(Calendar.DATE, 9450);
		printDate(cal);
				
	}

	private static void printDate(Calendar cal) {
		final String[] DAYS = {"일", "월", "화", "수", "목", "금", "토"};
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH); // 0 ~ 11, +1
		int date = cal.get(Calendar.DATE);
		int day = cal.get(Calendar.DAY_OF_WEEK); // 1(일) ~ 7(토)
		int hour = cal.get(Calendar.HOUR);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		
		System.out.println(
				year + "년 " +
		(month+1) + "월 " +
						date + "일 " +
						DAYS[day-1] + "요일 " +
		hour + "시 " +
						minute + "분 "+
		second + "초");
		}
	
	
	

}
