package model.dao;

import model.entity.Card;
import model.logic.Util;

import java.sql.*;
import java.util.ArrayList;

public class CardRepository extends Util implements Dao<Card> {

	@Override
	public boolean createIfNotExists(){

		try (Connection connection = getConnection();
			 Statement stmt = connection.createStatement()) {

			stmt.execute("CREATE TABLE IF NOT EXISTS CARDS(card_number bigint auto_increment," +
															"account_number bigint not null);");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean add(Card card){

		String query = "INSERT INTO CARDS (ACCOUNT_NUMBER) VALUES(?)";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, card.getAccountID());

			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public ArrayList<Card> getAll(long accountNumber){

		ArrayList<Card> cards = new ArrayList<Card>();

		String query = "SELECT * FROM CARDS WHERE ACCOUNT_NUMBER=?";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, accountNumber);

			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				cards.add(new Card());
				cards.get(cards.size() - 1).setCardNumber(resultSet.getLong("CARD_NUMBER"));
				cards.get(cards.size() - 1).setAccountID(resultSet.getLong("ACCOUNT_NUMBER"));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return cards;
	}

	@Override
	public Card getByAccountNumber(long accountNumber){
		return null;
	}

	@Override
	public boolean update(Card card){ return false;}

	@Override
	public boolean remove(long accountNumber) {

		String query = "DELETEFROM CARDS WHERE ACCOUNT_NUMBER=?";

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

	public boolean removeCard(Card card) throws SQLDataException {

		String query = "DELETE FROM CARDS WHERE CARD_NUMBER=?";

		try (Connection connection = getConnection();
			 PreparedStatement ps = connection.prepareStatement(query)) {

			ps.setLong(1, card.getCardNumber());
			ps.executeUpdate();

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
