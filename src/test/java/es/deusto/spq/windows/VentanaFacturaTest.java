package es.deusto.spq.windows;

import java.util.ArrayList;

import org.junit.Test;

import es.deusto.spq.server.Carrito;

public class VentanaFacturaTest {
	@Test
	public void testVentanaFactura() {
		ArrayList<Carrito> alcarrito = new ArrayList<>();
		VentanaFactura ventanaFactura = new VentanaFactura(alcarrito);
	}
}
