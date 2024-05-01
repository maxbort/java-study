package prob06;

import java.util.Scanner;

public class CalcApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		while( true ) {
			System.out.print( ">> " );
			String expression = scanner.nextLine();
			
			if( "quit".equals( expression ) ) {
				break;
			}
			
			String[] tokens = expression.split( " " );
			
			if( tokens.length != 3 ) {
				System.out.println( ">> 알 수 없는 식입니다.");
				continue;
			}
			
			int lValue = Integer.parseInt( tokens[ 0 ] );
			int rValue = Integer.parseInt( tokens[ 2 ] );
			Arith arith = null;
			
			switch( tokens[ 1 ] ) {
				case "+" : {
					arith = new Add();
					break;
				}
				case "-" : {
					arith = new Sub();
					break;
				}
				case "*" : {
					arith = new Mul();					
					break;					
				}
				case "/" : {
					Div d = new Div();
					//arith = new Div();	
					System.out.println(d.calculate(0));
					break;
					
				}
				default :  {
					System.out.println( ">> 알 수 없는 연산입니다.");
				}
			}
			
			if(arith != null) {
				arith.setValue(lValue, rValue);
				arith.calculate();
			}
		}
		
		scanner.close();

	}

}