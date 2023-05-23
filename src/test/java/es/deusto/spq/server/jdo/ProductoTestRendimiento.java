package es.deusto.spq.server.jdo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
import es.deusto.spq.server.JUnitPerfTest;
import es.deusto.spq.server.JUnitPerfTestRequirement;
@PerformanceTest
public class ProductoTestRendimiento {
	
    private Producto producto;
	 @Before
	    public void setUp() {
	        producto = new Producto(0, "nombre", "tipo", "marca", "tamanyo", 0.0, 0, "ruta");
	    }
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetRuta() {
	    assertEquals("ruta", producto.getRuta());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetRuta() {
		producto.setRuta("newruta");
	    assertEquals("newruta", producto.getRuta());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetCod() {
	    assertEquals(0, producto.getCod());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetCod() {
		producto.setCod(1);
	    assertEquals(1, producto.getCod());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetNombre() {
	    assertEquals("nombre", producto.getNombre());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetNombre() {
		producto.setNombre("newnombre");
	    assertEquals("newnombre", producto.getNombre());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetTipo() {
	    assertEquals("tipo", producto.getTipo());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTipo() {
		producto.setTipo("newtipo");
	    assertEquals("newtipo", producto.getTipo());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetMarca() {
	    assertEquals("marca", producto.getMarca());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetMarca() {
		producto.setMarca("newmarca");
	    assertEquals("newmarca", producto.getMarca());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetTamanyo() {
	    assertEquals("tamanyo", producto.getTamanyo());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTamanyo() {
		producto.setTamanyo("newtamanyo");
	    assertEquals("newtamanyo", producto.getTamanyo());
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetPrecio() {
	    assertEquals(0.0, producto.getPrecio(),0.001);
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetPrecio() {
		producto.setPrecio(1.1);
	    assertEquals(1.1, producto.getPrecio(), 0.001);
	}
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetStock() {
	    assertEquals(0, producto.getStock());
	}
	
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetStock() {
		producto.setStock(1);
	    assertEquals(1, producto.getStock());
	}
}
