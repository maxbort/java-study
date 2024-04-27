package prob2;

public class SmartPhone extends MusicPhone {

	@Override
	public void execute(String function) {
		// TODO Auto-generated method stub
		 if (function.equals("통화")){
			 super.execute(function);
		 }
		 else if (function.equals("음악")) {
			 playmusic();
		 }
		 else {
			 runApp();
		 }
	}
	
	public void playmusic() {
		System.out.println("다운로드해서 음악재생");
	}
	public void runApp() {
		System.out.println("앱실행");
	}
	 
}
