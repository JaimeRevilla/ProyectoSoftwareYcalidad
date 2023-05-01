package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TelevisionesTest {
	@Test
	public void getTelevisionesTest() {
		Televisiones televisiones= new Televisiones(0, null, null, null, null, 0, 0, null, null);
		TipoTV tipotv = TipoTV.CURVA;
		televisiones.setTipoTV(tipotv);
		assertEquals(tipotv, televisiones.getTipoTV());
		
	}
}
