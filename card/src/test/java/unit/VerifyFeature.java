package unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import card.Verify;

public class VerifyFeature {

	@Test
	public void test() {
		assertTrue(Verify.modulus10("4916854683763796"));
		assertTrue(Verify.modulus10("5111111111111118"));
		assertFalse(Verify.modulus10("1234987645670987"));
	}

}
