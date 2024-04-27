package prob6;
import java.lang.*;

public class RectTriangle extends Shape {

	
	public RectTriangle(double width, double height) {
		super(width,height);
	}

	@Override
	double getArea() {
		
		return (width*height)/2;
	}

	@Override
	double getPerimeter() {
		return width+height+Math.sqrt(width*width + height*height);
	}

}
