package unit;

import card.Card;
import static org.junit.Assert.*;

import org.junit.Test;

public class CardObjInitialization {

	@Test
	public void testCardObjInitialization() {
		Card fakeCard = new Card();
		assertNotNull(fakeCard);
	}

}
