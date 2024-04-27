package chapter04;

public class StringTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 자바에서는 그냥 무조건 경로는 / 로 표기할 것 jvm이 알아서 맞춰주니
		System.out.println("C:\\temp");
		
		// "Hello"
		System.out.println("\"Hello\"");
		
		// \t : tab
		// \r : carriage return
		// \n : newline
		// \b : beep
		
		System.out.print("hello\tworld\n");
		System.out.println("hello\tworld");
		
		// '
		char c = '\'';
		System.out.println(c);
		
	}

}
