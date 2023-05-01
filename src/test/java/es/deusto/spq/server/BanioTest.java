package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BanioTest {

	@Test
	public void getBanioTest() {
		Banio banio = new Banio(0, null, null, null, null, 0, 0, null, null);
		TipoBanio tipobanio = TipoBanio.DUCHA;
		banio.setTipoBanio(tipobanio);
		assertEquals(tipobanio, banio.getTipoBanio());
		
	}
}
