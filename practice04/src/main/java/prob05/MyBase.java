package prob05;

public class MyBase extends Base {

	@Override
	public void service(String state) {
		// TODO Auto-generated method stub
		if("낮".equals(state)) {
			System.out.println("낮에는 열심히 일하자!");
		}
		else if("오후".equals(state)) {
			System.out.println("오후도 낮과 마찬가지로 일해야 합니다.");
		}
		else if("밤".equals(state)){
			super.night();
		}
		else {
			System.out.println("잘못 입력했습니다.");
		}
		
	}
	
	
}
