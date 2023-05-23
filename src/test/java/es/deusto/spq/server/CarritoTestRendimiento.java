package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class CarritoTestRendimiento {
	private Carrito carrito;
	 @Before
	    public void setUp() {
		 carrito = new Carrito("dni", 0, "nombre", "tipo", "marca", "tamanyo", 0, 0.0);
	    }
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetDni() {
	    assertEquals("dni", carrito.getDni());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetDni() {
		carrito.setDni("newdni");
	    assertEquals("newdni", carrito.getDni());
	}
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetCod() {
	    assertEquals(0, carrito.getCod());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetCod() {
		carrito.setCod(1);
	    assertEquals(1, carrito.getCod());
	}
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetNombre() {
	    assertEquals("nombre", carrito.getNom());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetNombre() {
		carrito.setNom("newnombre");
	    assertEquals("newnombre", carrito.getNom());
	}
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetTipo() {
	    assertEquals("tipo", carrito.getTipo());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTipo() {
		carrito.setTipo("newtipo");
	    assertEquals("newtipo", carrito.getTipo());
	}
	@Test
	public void testGetMarca() {
	    assertEquals("marca", carrito.getMarca());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetMarca() {
		carrito.setMarca("newmarca");
	    assertEquals("newmarca", carrito.getMarca());
	}
	@Test
	public void testGetTamanyo() {
	    assertEquals("tamanyo", carrito.getTamanyo());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTamanyo() {
		carrito.setTamanyo("newtamanyo");
	    assertEquals("newtamanyo", carrito.getTamanyo());
	}
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetPrecio() {
	    assertEquals(0.0, carrito.getPrecio(),0.001);
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetPrecio() {
		carrito.setPrecio(1.1);
	    assertEquals(1.1, carrito.getPrecio(), 0.001);
	}
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetCantidad() {
	    assertEquals(0, carrito.getCantidad());
	}
	
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetCantidad() {
		carrito.setCantidad(1);
	    assertEquals(1, carrito.getCantidad());
	}
	
}
