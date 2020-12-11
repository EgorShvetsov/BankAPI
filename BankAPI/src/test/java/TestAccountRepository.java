import model.dao.AccountRepository;
import model.entity.Account;
import org.h2.tools.DeleteDbFiles;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class TestAccountRepository {

	@Test
	public void testAddPositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();


		boolean expected = true;

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(1000);
		boolean actual = accountRepository.add(account);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testAddNegativeScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();


		boolean expected = false;

		Account account = new Account();
		account.setFirstName("Ivan");
		account.setBalance(1000);
		boolean actual = accountRepository.add(account);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetPositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();


		boolean expected = true;

		Account account1 = new Account();
		Account account2 = new Account();

		account1.setFirstName("Ivan");
		account1.setLastName("Ivanov");
		account1.setBalance(1000);
		account2.setFirstName("Sergey");
		account2.setLastName("Sergeev");
		account2.setBalance(777);

		accountRepository.add(account1);
		accountRepository.add(account2);

		Account result = accountRepository.getByAccountNumber(1);

		boolean actual =  result.getFirstName().equals("Ivan");

		Assertions.assertEquals(expected, actual);
	}

	@Test
	public void testGetNegativeScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();


		boolean expected = true;

		Account account1 = new Account();
		Account account2 = new Account();

		account1.setFirstName("Ivan");
		account1.setLastName("Ivanov");
		account1.setBalance(1000);
		account2.setFirstName("Sergey");
		account2.setLastName("Sergeev");
		account2.setBalance(777);

		accountRepository.add(account1);
		accountRepository.add(account2);

		Account result = accountRepository.getByAccountNumber(33);

		boolean actual =  result == null;

		Assertions.assertEquals(expected, actual);
	}


	@Test
	public void testUpdatePositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();



		Account account = new Account();
		account.setFirstName("Ivan");
		account.setLastName("Ivanov");
		account.setBalance(1000);
		accountRepository.add(account);

		account.setBalance(777);
		accountRepository.update(account);

		long expected = 777;

		long actual = accountRepository.getByAccountNumber(1).getBalance();

		Assertions.assertEquals(expected, actual);
	}



	@Test
	public void testRemovePositiveScenario() {
		String dir = "/Users/o_o/Documents/java/Sber/BankAPI/src/main/resources/db";

		DeleteDbFiles.execute(dir, "juniorBank", true);

		AccountRepository accountRepository = new AccountRepository();
		accountRepository.createIfNotExists();


		Account account1 = new Account();
		Account account2 = new Account();

		account1.setFirstName("Ivan");
		account1.setLastName("Ivanov");
		account1.setBalance(1000);
		account2.setFirstName("Sergey");
		account2.setLastName("Sergeev");
		account2.setBalance(777);

		accountRepository.add(account1);
		accountRepository.add(account2);

		Account expected = null;
		accountRepository.remove(1);
		Account actual = accountRepository.getByAccountNumber(1);

		Assertions.assertEquals(expected, actual);
	}

}
