package model.logic;

import model.dao.AccountRepository;
import model.dao.CardRepository;
import model.entity.Account;
import model.entity.Card;

import java.util.ArrayList;

public class Service {

	private CardRepository cardRepository = new CardRepository();
	private AccountRepository accountRepository = new AccountRepository();

	public boolean addCardById(Card card) {

		if (card != null && card.getAccountID() > 0) {
			accountRepository.createIfNotExists();
			cardRepository.createIfNotExists();
			if (accountRepository.getByAccountNumber(card.getAccountID()) == null) return false;
			return cardRepository.add(card);
		}
		return false;
	}

	public ArrayList<Card> getCardsList(long accountNumber) {

		ArrayList<Card> result = null;

		if (accountNumber > 0) {
			accountRepository.createIfNotExists();
			cardRepository.createIfNotExists();
			if (accountRepository.getByAccountNumber(accountNumber) != null) {
				result = cardRepository.getAll(accountNumber);
			}
		}
		return result;
	}

	public boolean addBalance(Account account) {

		long balance = account.getBalance();

		if (account != null && account.getAccountNumber() > 0) {
			accountRepository.createIfNotExists();
			if (accountRepository.getByAccountNumber(account.getAccountNumber()) == null) return false;
			balance += accountRepository.getByAccountNumber(account.getAccountNumber()).getBalance();
			account.setBalance(balance);
			return accountRepository.update(account);
		}
		return false;
	}

	public Account getBalance(Account account) {

		if (account != null && account.getAccountNumber() > 0) {
			accountRepository.createIfNotExists();
			if (accountRepository.getByAccountNumber(account.getAccountNumber()) == null) return null;
			return accountRepository.getByAccountNumber(account.getAccountNumber());
		}
		return null;
	}

}
