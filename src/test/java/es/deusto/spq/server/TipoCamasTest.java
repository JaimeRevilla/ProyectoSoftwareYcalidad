package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoCamasTest {
	@Test
	public void Test() {
		assertEquals(4, TipoCamas.values().length);
	}
}