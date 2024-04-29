package prob6;

public class Rectangle extends Shape implements Resizable {

	private double width;
	private double height;
	
	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}
	

	@Override
	public void resize(double s) {
		width *= s;
		height *= s;
		
	}


	@Override
	double getArea() {
		return width * height;
	}

	@Override
	double getPerimeter() {
		
		return 2*(width+height);
	}
}
