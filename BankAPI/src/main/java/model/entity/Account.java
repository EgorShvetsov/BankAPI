package model.entity;

import java.util.Objects;
import java.util.Scanner;

public class Account {

	private long accountNumber;
	private String firstName;
	private String lastName;
	private long balance;

	public Account() {
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return accountNumber == account.accountNumber && balance == account.balance && Objects.equals(firstName, account.firstName) && Objects.equals(lastName, account.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNumber, firstName, lastName, balance);
	}
	@Override
	public String toString() {
		return "Account{" +
				"accountNumber=" + accountNumber +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", balance=" + balance +
				'}';
	}
}
