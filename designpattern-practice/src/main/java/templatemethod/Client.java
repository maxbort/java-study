package templatemethod;

public class Client {
	
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
		new Calculator().add();
		new Calculator().subtract();
		
		AbstractCalculator ac = new MultiplyCalculate();
		
		ac = new DivideCalculate();
		ac.templateMethod();
		
	}
}
