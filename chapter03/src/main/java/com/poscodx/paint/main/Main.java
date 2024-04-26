package com.poscodx.paint.main;

import com.poscodx.paint.i.Drawable;
import com.poscodx.paint.point.ColorPoint;
import com.poscodx.paint.point.Point;
import com.poscodx.paint.shape.Circle;
import com.poscodx.paint.shape.Rectangle;
import com.poscodx.paint.shape.Shape;
import com.poscodx.paint.shape.Triangle;
import com.poscodx.paint.text.GraphicText;

public class Main {
	public static void main(String[] args) {
		Point point = new Point(2,5);
//		
//		point.setX(2);
//		point.setY(5);
		
		draw(point);
		point.draw(false);
		ColorPoint point2 = new ColorPoint(3,4,"blue");
		
		draw(point2);
		point2.draw(false);
		point2.draw(true);
		
		//drawTriangle(new Triangle());
		//drawRectangle(new Rectangle());
		
		draw(new Triangle());
		draw(new Rectangle());
		draw(new Circle());
		
		draw(new GraphicText("Hello World"));
		
		Circle c = new Circle();
		
		System.out.println(c instanceof Circle);
		System.out.println(c instanceof Shape);
		System.out.println(c instanceof Object);
		
//		오류: 연산자 우측항이 클래스인 경우
//			레퍼런스 하고 있는 class 타입의 hierachy 상의 하위 상위만
		//	instanceof 연산자 사용 가능
//		System.out.println(c instanceof Point);
		
		Object o = new Circle();
		System.out.println(o instanceof String);
		
		// 연산자 우측항이 인터페이스인 경우
		// Hierachy 상관없이 instanceof 연산자 사용 가능.
		System.out.println(c instanceof Drawable);
		System.out.println(c instanceof Runnable);
		
	}
	
	private static void draw(Drawable drawable) {
		drawable.draw();
	}
	
//	private static void drawShape(Draw shape) {
//		shape.draw();
//	}
//	private static void drawPoint(ColorPoint colorPoint) {
//		colorPoint.show();
//	}
	
//	private static void drawTriangle(Triangle triangle) {
//		triangle.show();
//	}
//	private static void drawRectangle(Rectangle rectangle) {
//		rectangle.show();
//	}
}
