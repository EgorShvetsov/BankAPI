package model.entity;

import java.util.Objects;

public class Card {

	private long cardNumber;
	private long accountID;

	public Card() {
	}

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getAccountID() {
		return accountID;
	}

	public void setAccountID(long accountID) {
		this.accountID = accountID;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Card card = (Card) o;
		return cardNumber == card.cardNumber && accountID == card.accountID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardNumber, accountID);
	}

	@Override
	public String toString() {
		return "Card{" +
				"cardNumber=" + cardNumber +
				", accountID=" + accountID +
				'}';
	}
}
