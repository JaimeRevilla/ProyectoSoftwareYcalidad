package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SillasTest {
	@Test
	public void getSillasTest() {
		Sillas sillas= new Sillas(0, null, null, null, null, 0, 0, null, null);
		TipoSillas tiposillas = TipoSillas.OFICINA;
		sillas.setTipoSillas(tiposillas);
		assertEquals(tiposillas, sillas.getTipoSillas());
		
	}
}
