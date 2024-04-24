package mypackage;

public class Goods2 {
	public String name; // 모든 접근 가능 (접근 제한x)
	protected int price; // 같은 패키지 + 자식 클래스 접근 가능.
	int countStock;		// 같은 패키지 (default)
	private int countSold;

}
