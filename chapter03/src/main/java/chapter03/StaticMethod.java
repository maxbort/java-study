package chapter03;

public class StaticMethod {
	int n;
	static int m;
	
	void f1() {
		n = 10;
	}
	
	void f2() {
		StaticMethod.m = 10; // 스태틱 변수는 클래스명으로 접근해야 하나
		m = 20; // 같은 클래스의 스새틱 변수 접근 시에는 편의성측면에서 이렇게도 허용해줌
	}
	
	void f3() {
		f2();
	}
	
	void f4() {
		StaticMethod.s1();
		
		// 같은 클래스의 스태틱 메소드 접근에서는 클래스 이름 생략 가능
		s1();
	}
	
	static void s1() {
		// n = 10; error
		
		m = 20; // 가능
		// 스태틱 메소드는 스태틱 멤버만 호출, 접근 가능
		
	}
	
	static void s2() {
		// f1(); // error
		// 스태틱 메소드에서 instance 메소드 접근 불가
	}
	
	static void s3() {
		StaticMethod.m = 10;
		
		m = 10;
		
	}
	
	static void s4() {
		StaticMethod.s1();
		s1();
	}
}
