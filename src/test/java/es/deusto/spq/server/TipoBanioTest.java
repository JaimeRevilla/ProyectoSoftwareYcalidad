package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoBanioTest {
	@Test
	public void Test() {
		assertEquals(3, TipoBanio.values().length);
	}
}