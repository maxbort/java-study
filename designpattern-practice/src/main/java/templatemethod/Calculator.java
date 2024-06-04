package templatemethod;

import java.util.Scanner;

@SuppressWarnings("resource")
public class Calculator {

	public void add() {
		Scanner sc = new Scanner(System.in);

		System.out.println("(val1, val2) >");
		int val1 = sc.nextInt();
		int val2 = sc.nextInt();
		
		int result = val1 + val2;
		
		System.out.println(result);
		
	}
	public void subtract() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(val1, val2) >");
		int val1 = sc.nextInt();
		int val2 = sc.nextInt();
		
		int result = val1 - val2;
		
		System.out.println(result);
		
	}
	

}
