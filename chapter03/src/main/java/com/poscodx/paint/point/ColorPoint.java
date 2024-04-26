package com.poscodx.paint.point;

public class ColorPoint extends Point {
	private String color;
	
	public ColorPoint(int x, int y, String color) {
		super(x,y);
		this.color = color;
	}
	

	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	
	@Override
	public void draw() {
		System.out.println(
				"점[x=" + super.getX() + 
				"," + "y=" + super.getY() +
				", color = " + color +
				"] 을 그렸습니다.");
	}
	
	public void draw(boolean visible) {
		if(visible) {
			draw();
		}
		else {
			System.out.println("점[x=" + super.getX() + "," + "y=" + super.getY()+ "] 을 지웠습니다.");
		}
	}
	
}
