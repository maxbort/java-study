package chapter03;

public class SwapTest01 {

	public static void main(String[] args) {
		int i = 10;
		int j = 20;
		
		System.out.println(i + ", " + j);
		
		int tmp = j;
		// tmp = j;
		j = i;
		i = tmp;
		System.out.println(i + ", " + j);
		
		j = swap(i,i = j);
		
		System.out.println(i+", "+j);
		
	}
	
	private static int swap(int a, int b) {
		return a;
	}

}
