package model.dao;

import model.entity.Account;
import model.logic.Util;

import java.sql.*;
import java.util.ArrayList;

public class AccountRepository extends Util implements Dao<Account> {

	@Override
	public boolean createIfNotExists() {

		try  (Connection connection = getConnection();
			  Statement stmt = connection.createStatement()) {

			stmt.execute("CREATE TABLE IF NOT EXISTS ACCOUNTS(account_number bigint auto_increment," +
																"first_name varchar(100) not null," +
																"last_name varchar(100) not null," +
																"balance bigint);");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean add(Account account) {


		String query = "INSERT INTO ACCOUNTS (FIRST_NAME, LAST_NAME, BALANCE) VALUES(?, ?, ?)";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setString(1, account.getFirstName());
			ps.setString(2, account.getLastName());
			ps.setLong(3, account.getBalance());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Account> getAll(long accountNumber) {
		return null;
	}

	@Override
	public Account getByAccountNumber(long accountNumber) {

		Account account = new Account();
		String query = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, accountNumber);

			ResultSet resultSet = ps.executeQuery();
			if (resultSet.next()) {

				account.setAccountNumber(resultSet.getLong("ACCOUNT_NUMBER"));
				account.setFirstName(resultSet.getString("FIRST_NAME"));
				account.setLastName(resultSet.getString("LAST_NAME"));
				account.setBalance(resultSet.getLong("BALANCE"));
				return account;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	@Override
	public boolean update(Account account) {

		String query = "UPDATE ACCOUNTS SET BALANCE=? WHERE ACCOUNT_NUMBER=?";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, account.getBalance());
			ps.setLong(2, account.getAccountNumber());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean remove(long accountNumber) {

		String query = "DELETE FROM ACCOUNTS WHERE ACCOUNT_NUMBER=?";
		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, accountNumber);
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
