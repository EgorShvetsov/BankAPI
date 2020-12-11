import model.dao.AccountRepository;
import model.dao.CardRepository;
import model.entity.Account;
import model.entity.Card;
import model.logic.Service;
import org.h2.tools.DeleteDbFiles;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class TestService {

	@Test
	public void testAddCardByIdPositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";
		DeleteDbFiles.execute(dir, "juniorBank", true);

		Service service = new Service();
		AccountRepository accountRepository = new AccountRepository();
		CardRepository cardRepository = new CardRepository();
		accountRepository.createIfNotExists();
		cardRepository.createIfNotExists();

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(1000);
		account.setAccountNumber(1);
		accountRepository.add(account);

		Card newCard = new Card();
		newCard.setAccountID(account.getAccountNumber());

		boolean actual = service.addCardById(newCard);
		boolean expected = true;
		Assertions.assertEquals(expected, actual);
	}


	@Test
	public void testAddCardByIdNegativeScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";
		DeleteDbFiles.execute(dir, "juniorBank", true);

		Service service = new Service();
		CardRepository cardRepository = new CardRepository();
		cardRepository.createIfNotExists();

		Card newCard = new Card();

		boolean actual = service.addCardById(newCard);
		boolean expected = false;
		Assertions.assertEquals(expected, actual);
	}


	@Test
	public void testGetCardsListPositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";
		DeleteDbFiles.execute(dir, "juniorBank", true);

		Service service = new Service();
		AccountRepository accountRepository = new AccountRepository();
		CardRepository cardRepository = new CardRepository();
		accountRepository.createIfNotExists();
		cardRepository.createIfNotExists();

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(1000);
		account.setAccountNumber(1);
		accountRepository.add(account);

		Card newCard1 = new Card();
		Card newCard2 = new Card();
		Card newCard3 = new Card();
		newCard1.setAccountID(account.getAccountNumber());
		newCard2.setAccountID(account.getAccountNumber());
		newCard3.setAccountID(account.getAccountNumber());

		service.addCardById(newCard1);
		service.addCardById(newCard2);
		service.addCardById(newCard3);

		ArrayList<Card> result = service.getCardsList(account.getAccountNumber());

		int actual = result.size();
		int expected = 3;
		Assertions.assertEquals(expected, actual);
	}


	@Test
	public void testGetBalancePositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";
		DeleteDbFiles.execute(dir, "juniorBank", true);

		Service service = new Service();
		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(7777);
		account.setAccountNumber(1);
		accountRepository.add(account);

		long actual = service.getBalance(account).getBalance();
		long expected = 7777;
		Assertions.assertEquals(expected, actual);
	}


	@Test
	public void testAddBalancePositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";
		DeleteDbFiles.execute(dir, "juniorBank", true);

		Service service = new Service();
		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(1000);
		account.setAccountNumber(1);
		accountRepository.add(account);

		account.setBalance(2000);
		service.addBalance(account);

		long actual = service.getBalance(account).getBalance();
		long expected = 3000;
		Assertions.assertEquals(expected, actual);
	}


}
