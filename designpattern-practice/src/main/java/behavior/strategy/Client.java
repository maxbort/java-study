package behavior.strategy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CalculateContext cc = new CalculateContext();
		cc.execute(new CalculateStrategy() {
			@Override
			public int calculate(int val1, int val2) {
				return val2 + val2;
			}
		});
		cc.execute((val1, val2) -> val1 - val2);
		cc.execute((val1, val2) -> val1 * val2);
		cc.execute((val1, val2) -> val1 / val2);
	}

}
