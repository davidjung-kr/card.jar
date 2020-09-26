package unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import card.Verify;

public class VerifyFeature {

	@Test
	public void test() {
		assertTrue(Verify.CardNumber());
	}

}
