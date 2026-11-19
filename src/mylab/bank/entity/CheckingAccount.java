package mylab.bank.entity;

import mylab.bank.exception.InsufficientBalanceException;
import mylab.bank.exception.WithdrawalLimitExceededException;

// 체킹 계좌: 1회 출금 한도가 있는 계좌
public class CheckingAccount extends Account {
	private double withdrawalLimit; // 출금 한도

	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}

	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}

	// 한도를 먼저 검사하고, 통과하면 부모의 출금(잔액 검사 포함)을 그대로 사용
	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		super.withdraw(amount);
	}

	@Override
	public String toString() {
		return super.toString() + ", 출금 한도: " + withdrawalLimit + "원";
	}
}
