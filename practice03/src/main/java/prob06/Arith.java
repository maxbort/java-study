package prob06;

public abstract class Arith{
	protected int a;
	protected int b;
	public abstract void calculate();
	public void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
