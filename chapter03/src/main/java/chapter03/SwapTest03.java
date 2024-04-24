package chapter03;

import mypackage.Value;

public class SwapTest03 {

	public static void main(String[] args) {
		Value i = new Value(10);
		Value j = new Value(20);
		
		System.out.println(i.val + ", " + j.val);
		swap(i,j);
		System.out.println(i.val + ", " + j.val);
		
		
		
	}
	
	private static void swap(Value a, Value b) {
		int tmp = b.val;
		b.val = a.val;
		a.val = tmp;
	}

}
