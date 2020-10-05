package unit;

import card.Card;
import card.CardIin;
import card.Verify;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardObjInitialization {

	@Test
	public void testCardObjInitialization() {
		Card masterCard = new Card(CardIin.MASTER);
		System.out.println(masterCard.getCardNumber());
		String cardNumber = masterCard.getCardNumber();
		assertEquals(16, cardNumber.length());
		assertEquals(true, Verify.modulus10(cardNumber));
	}
}