package mylab.bank.entity;

// 저축 계좌: 이자율이 있는 계좌
public class SavingsAccount extends Account {
	private double interestRate; // 이자율 (예: 0.03 = 3%)

	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}

	public double getInterestRate() {
		return interestRate;
	}

	// 현재 잔액에 이자율을 곱한 만큼 입금
	public void applyInterest() {
		double interest = getBalance() * interestRate;
		deposit(interest);
		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
	}

	@Override
	public String toString() {
		return super.toString() + ", 이자율: " + (interestRate * 100) + "%";
	}
}
