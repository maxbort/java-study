package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Goods[] goods = new Goods[COUNT_GOODS];
		
		
		// 상품 입력
		for(int i = 0 ; i < COUNT_GOODS; i++) {
			System.out.println("상품명 가격 입고량을 순서대로 입력하시오");
			String input = scanner.nextLine();  // 전체 라인을 입력 받음
			String[] parts = input.split(" ");  // 공백을 기준으로 분리
			String name = parts[0];
			int price = Integer.parseInt(parts[1]);
			int countStock = Integer.parseInt(parts[2]);
			goods[i] = new Goods(name, price, countStock);
		}
		
		// 상품 출
		for(int i = 0; i < COUNT_GOODS; i++) {
			System.out.println(goods[i].getName() + "(가격:" + goods[i].getPrice() +"원)이 " + goods[i].getCountStock() + "개 입고 되었습니다.\r\n");
		}
		// 자원정리
		scanner.close();
	}
}


