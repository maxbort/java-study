package prob01;

public class Printer {
//
//	public void println(Object s) {
//		System.out.println(s);
//	}
//	
	public <T> void println(T t) {
		System.out.println(t);
	}
	
	
	public <T> void println(T ... ts) {
		for(T t : ts) {
			System.out.print(t);
		}
		System.out.println();
	}
	
	
	public int sum(Integer ... nums) {
		int s = 0;
		for(Integer i : nums) {
			s += i;
		}
		return s;
	}
}
