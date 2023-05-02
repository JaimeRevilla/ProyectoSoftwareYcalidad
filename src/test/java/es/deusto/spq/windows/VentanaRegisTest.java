package es.deusto.spq.windows;

import org.junit.Test;

import es.deusto.spq.client.ClienteOperaciones;

public class VentanaRegisTest {
	@Test
	public void testVentanaRegis() {
		ClienteOperaciones exclient = new ClienteOperaciones(null, null);
		VentanaRegis ventanaRegis = new VentanaRegis(exclient);
	}
}
