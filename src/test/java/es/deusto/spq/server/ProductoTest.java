package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class ProductoTest {
	
    private Producto producto;
	 @Before
	    public void setUp() {
	        producto = new Producto(0, "nombre", "tipo", "marca", "tamanyo", 0.0, 0, "ruta");
	    }
	@Test
	public void testGetRuta() {
	    assertEquals("ruta", producto.getRuta());
	}
	
	@Test
	public void testSetRuta() {
		producto.setRuta("newruta");
	    assertEquals("newruta", producto.getRuta());
	}
	@Test
	public void testGetCod() {
	    assertEquals(0, producto.getCod());
	}
	
	@Test
	public void testSetCod() {
		producto.setCod(1);
	    assertEquals(1, producto.getCod());
	}
	@Test
	public void testGetNombre() {
	    assertEquals("nombre", producto.getNombre());
	}
	
	@Test
	public void testSetNombre() {
		producto.setNombre("newnombre");
	    assertEquals("newnombre", producto.getNombre());
	}
	@Test
	public void testGetTipo() {
	    assertEquals("tipo", producto.getTipo());
	}
	
	@Test
	public void testSetTipo() {
		producto.setTipo("newtipo");
	    assertEquals("newtipo", producto.getTipo());
	}
	@Test
	public void testGetMarca() {
	    assertEquals("marca", producto.getMarca());
	}
	
	@Test
	public void testSetMarca() {
		producto.setMarca("newmarca");
	    assertEquals("newmarca", producto.getMarca());
	}
	@Test
	public void testGetTamanyo() {
	    assertEquals("tamanyo", producto.getTamanyo());
	}
	
	@Test
	public void testSetTamanyo() {
		producto.setTamanyo("newtamanyo");
	    assertEquals("newtamanyo", producto.getTamanyo());
	}
	@Test
	public void testGetPrecio() {
	    assertEquals(0.0, producto.getPrecio(),0.001);
	}
	
	@Test
	public void testSetPrecio() {
		producto.setPrecio(1.1);
	    assertEquals(1.1, producto.getPrecio(), 0.001);
	}
	@Test
	public void testGetStock() {
	    assertEquals(0, producto.getStock());
	}
	
	@Test
	public void testSetStock() {
		producto.setStock(1);
	    assertEquals(1, producto.getStock());
	}
}
