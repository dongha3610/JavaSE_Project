package mylab.bank.entity;

import java.util.ArrayList;
import java.util.List;

import mylab.bank.exception.AccountNotFoundException;
import mylab.bank.exception.InsufficientBalanceException;

// 은행: 계좌 생성/조회/입출금/이체를 관리 (Account의 생명주기를 Bank가 관리 = 합성 관계)
public class Bank {
	private List<Account> accounts;  // 은행이 관리하는 계좌 목록
	private int nextAccountNumber;   // 다음에 부여할 계좌번호

	public Bank() {
		accounts = new ArrayList<>();
		nextAccountNumber = 1000;
	}

	// 새 계좌번호 생성: AC1000, AC1001, ...
	private String generateAccountNumber() {
		return "AC" + (nextAccountNumber++);
	}

	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		SavingsAccount account = new SavingsAccount(generateAccountNumber(), ownerName, initialBalance, interestRate);
		accounts.add(account);
		System.out.println("저축 계좌가 생성되었습니다: " + account);
		return account.getAccountNumber();
	}

	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		CheckingAccount account = new CheckingAccount(generateAccountNumber(), ownerName, initialBalance, withdrawalLimit);
		accounts.add(account);
		System.out.println("체킹 계좌가 생성되었습니다: " + account);
		return account.getAccountNumber();
	}

	// 계좌번호로 계좌 찾기, 없으면 예외
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account account : accounts) {
			if (account.getAccountNumber().equals(accountNumber)) {
				return account;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + accountNumber + "에 해당하는 계좌를 찾을 수 없습니다.");
	}

	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		findAccount(accountNumber).deposit(amount);
	}

	public void withdraw(String accountNumber, double amount)
			throws AccountNotFoundException, InsufficientBalanceException {
		findAccount(accountNumber).withdraw(amount);
	}

	// 송금: 두 계좌를 먼저 모두 찾은 뒤 출금 -> 입금
	// (받는 계좌가 없으면 출금 전에 예외가 나므로 돈이 사라지지 않음)
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount)
			throws AccountNotFoundException, InsufficientBalanceException {
		Account from = findAccount(fromAccountNumber);
		Account to = findAccount(toAccountNumber);

		from.withdraw(amount);
		to.deposit(amount);
		System.out.println(amount + "원이 " + fromAccountNumber + "에서 " + toAccountNumber + "로 송금되었습니다.");
	}

	public void printAllAccounts() {
		System.out.println("=== 모든 계좌 목록 ===");
		for (Account account : accounts) {
			System.out.println(account);
		}
		System.out.println("===================");
	}
}
