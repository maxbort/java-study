package prob5;
// *
public class Prob5 {

	public static void main(String[] args) {
		for(int i = 0; i<100; i++) {
			String check = Integer.toString(i);
			String answer = "";
				for(int j = 0; j < check.length();j++) {
					if (check.charAt(j) == '3' || check.charAt(j) == '6' || check.charAt(j)=='9') {
					answer += '짝';
					}
				}
				if (answer != "") {
					System.out.print(i + " ");
					System.out.println(answer);
				}
		}
			
			
		}
	
}
