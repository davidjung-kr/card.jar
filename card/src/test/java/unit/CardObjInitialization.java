package unit;

import card.Card;
import card.CardIin;
import card.Verify;

import static org.junit.Assert.*;

import org.junit.Test;

public class CardObjInitialization {

	@Test
	public void testCardObjInitialization() {
		Card randomCard = new Card();
		assertNotNull(randomCard);
		
		Card visaCard = new Card(CardIin.VISA);
		System.out.println(visaCard.getCardNumber());
		assertTrue(visaCard.getCardNumber().length() == 16);
	}

}
