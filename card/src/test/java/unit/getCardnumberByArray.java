package unit;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import card.Card;

public class getCardnumberByArray {
	@Test
	public void testGetCardnumberByArray() {
		Card fakeCard = new Card();
		String cardNumber = fakeCard.getCardNumber();
		assertNotNull(cardNumber);
	}
}