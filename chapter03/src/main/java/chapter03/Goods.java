package chapter03;

public class Goods {
	public static int countOfGoods = 0;
	
	private String name;
	private int price;
	private int countStock;
	private int countSold;
	
	public Goods() { // 기본 생성자 정의
		// 클래스 이름 생략 간으
		Goods.countOfGoods++;
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		if (price >= 0) {
			this.price = price;
		}
	}
	public int getCountStock() {
		return countStock;
	}
	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}
	public int getCountSold() {
		return countSold;
	}
	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}
	public void setName(String str)
	{
		this.name = str;
	}
	public String getName() {
		return name;
	}
	
	public void showInfo() {
		System.out.println(
				"상품이름 : " + name + 
				", " + "가격 : " + price +
				", " + "재고개수 : "+ "" + countStock +
				", " + "팔린 개수 : " + countSold);
	}
	
	public int calcDiscountPrice(float percentage) {
		int result = (int)(price * (1-percentage));

		return result;
	}
	
	// 정보 은닉(데이터 보호)
}
