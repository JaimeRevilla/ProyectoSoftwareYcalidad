package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CarritoTest {
	private Carrito carrito;
	 @Before
	    public void setUp() {
		 carrito = new Carrito("dni", 0, "nombre", "tipo", "marca", "tamanyo", 0, 0.0);
	    }
	@Test
	public void testGetDni() {
	    assertEquals("dni", carrito.getDni());
	}
	
	@Test
	public void testSetDni() {
		carrito.setDni("newdni");
	    assertEquals("newdni", carrito.getDni());
	}
	@Test
	public void testGetCod() {
	    assertEquals(0, carrito.getCod());
	}
	
	@Test
	public void testSetCod() {
		carrito.setCod(1);
	    assertEquals(1, carrito.getCod());
	}
	@Test
	public void testGetNombre() {
	    assertEquals("nombre", carrito.getNom());
	}
	
	@Test
	public void testSetNombre() {
		carrito.setNom("newnombre");
	    assertEquals("newnombre", carrito.getNom());
	}
	@Test
	public void testGetTipo() {
	    assertEquals("tipo", carrito.getTipo());
	}
	
	@Test
	public void testSetTipo() {
		carrito.setTipo("newtipo");
	    assertEquals("newtipo", carrito.getTipo());
	}
	@Test
	public void testGetMarca() {
	    assertEquals("marca", carrito.getMarca());
	}
	
	@Test
	public void testSetMarca() {
		carrito.setMarca("newmarca");
	    assertEquals("newmarca", carrito.getMarca());
	}
	@Test
	public void testGetTamanyo() {
	    assertEquals("tamanyo", carrito.getTamanyo());
	}
	
	@Test
	public void testSetTamanyo() {
		carrito.setTamanyo("newtamanyo");
	    assertEquals("newtamanyo", carrito.getTamanyo());
	}
	@Test
	public void testGetPrecio() {
	    assertEquals(0.0, carrito.getPrecio(),0.001);
	}
	
	@Test
	public void testSetPrecio() {
		carrito.setPrecio(1.1);
	    assertEquals(1.1, carrito.getPrecio(), 0.001);
	}
	@Test
	public void testGetCantidad() {
	    assertEquals(0, carrito.getCantidad());
	}
	
	@Test
	public void testSetCantidad() {
		carrito.setCantidad(1);
	    assertEquals(1, carrito.getCantidad());
	}
}
