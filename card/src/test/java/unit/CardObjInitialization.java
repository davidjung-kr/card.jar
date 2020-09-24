package unit;

import card.Card;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

public class CardObjInitialization {

	@Test
	@BeforeClass
	public void testCardObjInitialization() {
		Card fakeCard = new Card();
		assertNotNull(fakeCard);
	}

}
