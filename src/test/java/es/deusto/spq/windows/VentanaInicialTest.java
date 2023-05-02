package es.deusto.spq.windows;

import org.junit.Test;

import es.deusto.spq.client.ClienteOperaciones;

public class VentanaInicialTest {
	@Test
	public void testVentanaInicialTest() {
		ClienteOperaciones excliente = new ClienteOperaciones(null, null);				
		VentanaInicial ventanaInicial = new VentanaInicial(excliente);
	}
}
