package collection;

import java.util.LinkedList;
import java.util.Queue;


public class QueueTest {

	public static void main(String[] args) {
		Queue<String> q = new LinkedList<>();
		
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		while(!q.isEmpty()) {
			String str = new String(q.poll());
			System.out.println(str);
		}
		
		q.poll(); // 예외는 아니지만 null 값.
		q.offer("마이콜");
		q.offer("둘리");
		q.offer("또치");
		
		
		System.out.println(q.poll());
		System.out.println(q.peek());
		System.out.println(q.poll());
		System.out.println(q.peek());
			
			

	}

}
