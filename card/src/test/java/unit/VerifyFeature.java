package unit;

import static org.junit.Assert.*;

import org.junit.Test;

import card.Verify;

public class VerifyFeature {

	@Test
	public void test() {
		assertEquals(true,	Verify.modulus10("4916854683763796"));
		assertEquals(true,	Verify.modulus10("5111111111111118"));
		assertEquals(false,	Verify.modulus10("1234987645670987"));
	}

}
