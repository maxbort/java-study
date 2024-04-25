package shape;

public class GraphicText implements Drawable {
	
	private String text;
	
	public GraphicText(String text) {
		this.text= text;
	}
	
	@Override
	public void draw() {
		System.out.println(text);
	}
}
