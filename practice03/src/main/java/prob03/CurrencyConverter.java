package prob03;

public class CurrencyConverter {
	private static double rate;
	
	public static double toDollar(double won) {
		return won/rate;
	}
	
	public static double toKRW(double dollor) {
		return dollor * rate;
	}
	
	public static void setRate(double r) {
		rate = r;
	}
}
