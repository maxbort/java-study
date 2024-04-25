package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods camera = new Goods("Nikon" ,40000,30,50);
//		camera.setName("Nikon");
//		camera.setPrice(40000);
//		camera.setCountStock(30);
//		camera.setCountSold(50);
		
		Goods goods2 = new Goods();
		Goods goods3 = new Goods();
		
		
		System.out.println(goods3.countOfGoods);
		
		System.out.println(camera.calcDiscountPrice(0.5f));
		
	}

}
