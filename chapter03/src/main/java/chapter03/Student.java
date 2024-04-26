package chapter03;

public class Student extends Person{
	public Student() {
		// super(); 를 컴파일러가 자동적으로 호출해줌
		// 자식 생성자에서 부모 생성자를 명시적으로 호출하지 않으면
		// 자동으로 부모의 기본 생성자를 호출하게 된다.
		System.out.println("Student class의 생성자 호출");
	}



}
