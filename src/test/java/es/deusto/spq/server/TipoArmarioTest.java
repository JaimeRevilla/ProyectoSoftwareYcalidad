package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoArmarioTest {
	@Test
	public void Test() {
		assertEquals(5, TipoArmario.values().length);
	}
}