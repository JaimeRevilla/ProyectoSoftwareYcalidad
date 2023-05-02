package es.deusto.spq.windows;

import org.junit.Test;

import es.deusto.spq.client.ClienteOperaciones;

public class VentanaInicioSesionTest {
	@Test
	public void testVentanaInicioSesion() {
		ClienteOperaciones exclient = new ClienteOperaciones(null, null);
		VentanaInicioSesion ventanaInicioSesion = new VentanaInicioSesion(exclient);
	}
}
