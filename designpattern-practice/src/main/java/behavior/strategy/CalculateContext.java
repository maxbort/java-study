package behavior.strategy;

import java.util.Scanner;

public class CalculateContext {
	
	public void execute(CalculateStrategy calculateStrategy ) {
		Scanner sc = new Scanner(System.in);
		System.out.println("(val1, val2) >");
		int val1 = sc.nextInt();
		int val2 = sc.nextInt();
		
		int result = calculateStrategy.calculate(val1, val2);
		
		System.out.println(result);
	}
}
