package unit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import card.CardIin;

public class CardIinValid {

	@Test
	public void testCardIinValid() {
		CardIin iinAmex			= CardIin.AMEX;
		CardIin iinVisa			= CardIin.VISA;
		CardIin iinMaestro		= CardIin.MAESTRO;
		CardIin iinCirrus		= CardIin.CIRRUS;
		CardIin iinMaster		= CardIin.MASTER;
		CardIin iinUnionpay 	= CardIin.UNIONPAY;
		CardIin iinJcb			= CardIin.JCB;
		CardIin iinDinersclub	= CardIin.DINERSCLUB;
		CardIin iinDiscover 	= CardIin.DISCOVER;
		
		assertNotNull(iinAmex);
		assertNotNull(iinVisa);
		assertNotNull(iinVisa);
		assertNotNull(iinJcb);
		assertNotNull(iinMaestro);
		assertNotNull(iinCirrus);
		assertNotNull(iinMaster);
		assertNotNull(iinDinersclub);
		assertNotNull(iinUnionpay);
		assertNotNull(iinDiscover);
		
		assertTrue(iinAmex		.getLength() == 15);
		assertTrue(iinVisa		.getLength() == 16);
		assertTrue(iinMaestro	.getLength() == 16);
		assertTrue(iinCirrus	.getLength() == 16);
		assertTrue(iinMaestro	.getLength() == 16);
		assertTrue(iinMaster	.getLength() == 16);
		assertTrue(iinUnionpay	.getLength() == 16);
		assertTrue(iinJcb		.getLength() == 16);
		assertTrue(iinDinersclub.getLength() == 16);
		assertTrue(iinDiscover	.getLength() == 16);
		
		assertFalse(iinVisa		.haveIinCode(""));
		assertFalse(iinVisa		.haveIinCode("4"));
		assertFalse(iinVisa		.haveIinCode("34"));
		assertTrue (iinVisa		.haveIinCode("4645096810229894"));
		assertTrue (iinUnionpay	.haveIinCode("6240459398569917"));
	}
}