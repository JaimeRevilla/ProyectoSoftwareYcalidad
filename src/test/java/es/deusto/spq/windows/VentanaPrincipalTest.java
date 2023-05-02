package es.deusto.spq.windows;

import org.junit.Test;

import es.deusto.spq.client.ClienteOperaciones;

public class VentanaPrincipalTest {
	@Test
	public void testVentanaPrincipal() {
		ClienteOperaciones exclient = new ClienteOperaciones(null, null);
		VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(exclient);
	}
}
