package prob06;

public class Div extends Arith{
	public void calculate() {
		int result = a/b;
		System.out.println(">> " + result);
	}
	
	public double calculate(int k) {
		return a/b;
	}
}
