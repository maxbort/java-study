package collection;

import java.util.Enumeration;
import java.util.Vector;

public class VectorTest01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector<String> v = new Vector<>();
		
		v.addElement("둘리");
	//	v.add("마이콜"); // x
		v.addElement("마이콜");
		v.addElement("또치");
		
		
		// 순회 1
		for(int i = 0; i < v.size(); i++) {
			String s= v.elementAt(i);
			System.out.println(s);
		}
		
		// 삭제
		v.removeElementAt(2);
		
		// 순회 2
		Enumeration<String> e = v.elements();
		while(e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s);
		}
		
		

	}

}
