package chapter04;

public class StringTest03 {

	public static void main(String[] args) {
		//String s1 = "Hello " + "World" + " java" + 17;
		
		
		String s1 = new StringBuffer("Hello ")
						.append("World")
						.append(" java")
						.append(17)
						.toString();
		
//		String s1 = new StringBuilder("Hello ")
//				.append("World")
//				.append(" java")
//				.append(17)
//				.toString();
		
		String s2 = "";
		for(int i = 0; i < 1000000; i++) {
			//s2 += "h";
			//s2 = new StringBuffer(s2).append("h").toString();
			
		}
		
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i<1000000; i++) {
			sb.append("h");
		}
		String s3 = sb.toString();
		
		
		// String method들
		String s4 = "aBcABCabcAbc";
		System.out.println(s4.length()); // 길이
		System.out.println(s4.charAt(2)); // 해당위치 문자
		System.out.println(s4.indexOf("abc")); //abc가 어디에 있는지 찾을 때
		System.out.println(s4.indexOf("abc",7));  // 위와 동일, 시작 위치 지정
		System.out.println(s4.substring(3));  // 
		System.out.println(s4.substring(3,5)); 
		
		
		String s5 = "     ab     cd    ";
		String s6 = "efg,hij,klm,nop,qrs";
		
		String s7 = s5.concat(s6);
		System.out.println(s7);
		
		System.out.println("---------" + s5.trim() + "---------");
		System.out.println("----" + s5.replaceAll(" ", "") + "-------");
		//System.out.println(s5.trim()); // 끝 공백 제거
		
		String[] tokens = s6.split(",");
		for(String s : tokens) {
			System.out.println(s);
		}
		System.out.println(s1);

		
		String[] tokens2 = s6.split(" ");
		for(String s: tokens2) {
			System.out.println(s);
		}
		
	}

}
