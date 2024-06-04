package templatemethod;

import java.util.Scanner;

public abstract class AbstractCalculator {
	public void templateMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.println("(val1, val2) >");
		int val1 = sc.nextInt();
		int val2 = sc.nextInt();
		
		int result = val1 + val2;
		
		System.out.println(result);
	}
	
	public abstract int caculate(int val1, int val2);
}
