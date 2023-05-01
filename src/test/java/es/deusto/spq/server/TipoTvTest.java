package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TipoTvTest {
	@Test
	public void Test() {
		assertEquals(2, TipoTV.values().length);
	}
}
