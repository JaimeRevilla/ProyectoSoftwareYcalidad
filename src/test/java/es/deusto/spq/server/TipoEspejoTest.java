package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoEspejoTest {
	@Test
	public void Test() {
		assertEquals(4, TipoEspejo.values().length);
	}
}