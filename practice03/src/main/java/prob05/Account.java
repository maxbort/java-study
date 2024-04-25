package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void save(int money) {
		this.balance += money;
	}
	public void deposit(int money) {
		if(balance >= money) {
			balance -= money;
		}
		else {
			System.out.println("잔액 부족");
		}
	}
	
	
}
