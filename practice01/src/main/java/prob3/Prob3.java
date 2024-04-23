package prob3;

import java.util.Scanner;

public class Prob3 {
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int num = 0;
		int answer = 0;
		System.out.print("숫자를 입력하세요: ");
		num = scanner.nextInt();
		
		if (num % 2 == 0) {
			
			for(int i = 0; i<=num; i+=2) {
				answer += i;
			}
			System.out.println("결과 값: " + answer);
		}
		else{
			
			for(int i = 1; i<=num; i+=2) {
				answer += i;
			}
			System.out.println("결과 값: " + answer);
		}
		
		scanner.close();
	}
}
