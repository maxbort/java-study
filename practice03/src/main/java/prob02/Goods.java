package prob02;

public class Goods {
	private String name;
	private int price;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	private int countStock;
	
	Goods(String name, int price, int countStock){
		this.name  = name;
		this.price = price;
		this.countStock = countStock;
	}
	
	
}
