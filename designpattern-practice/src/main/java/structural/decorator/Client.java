package structural.decorator;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ConcretComponent("Hello World").operation());
		System.out.println(new BracesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new ParenthesesDecorator(new BracesDecorator(new ConcretComponent("Hello World"))).operation());
		System.out.println(new ParenthesesDecorator(new ConcretComponent("Hello World")).operation());
		System.out.println(new BracesDecorator(new ParenthesesDecorator(new BracesDecorator(new ConcretComponent("Hello World")))).operation());
		
	}

}
