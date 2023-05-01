package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoSillasTest {
	@Test
	public void Test() {
		assertEquals(5, TipoSillas.values().length);
	}
}