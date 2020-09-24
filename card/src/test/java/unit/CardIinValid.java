package unit;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import card.CardIin;

public class CardIinValid {

	@Test
	public void testCardIinValid() {
		CardIin iin = CardIin.AMEX;
		assertNotNull(iin);
		assertTrue(iin.haveIinCode(34));
	}

}
