package prob04;

public class StringUtil {
	public static String concatenate(String[] str) {
		// 문자열 결합하여 리턴하는 메소드
		String result = "";
		for(String s : str) {
			result += s;
		}
		return result;
		
	}
}


