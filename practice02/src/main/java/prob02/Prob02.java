package prob02;

import java.util.Scanner;
import java.util.*;

public class Prob02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[ 5 ];
		double sum = 0;

		System.out.println("5개의 숫자를 입력하세요");
		for(int i = 0; i < 5; i++) {
			int num = 0;
			num = scanner.nextInt();
			intArray[i] = num;
		}
        double average = Arrays.stream(intArray).average().orElse(0);

		System.out.println("평균: " + average);
		scanner.close();
	}
}
