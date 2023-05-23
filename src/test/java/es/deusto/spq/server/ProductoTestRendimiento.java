package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class ProductoTestRendimiento {
	
    private Producto producto;
	 @Before
	    public void setUp() {
	        producto = new Producto(0, "nombre", "tipo", "marca", "tamanyo", 0.0, 0, "ruta");
	    }
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetRuta() {
	    assertEquals("ruta", producto.getRuta());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetRuta() {
		producto.setRuta("newruta");
	    assertEquals("newruta", producto.getRuta());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetCod() {
	    assertEquals(0, producto.getCod());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetCod() {
		producto.setCod(1);
	    assertEquals(1, producto.getCod());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetNombre() {
	    assertEquals("nombre", producto.getNombre());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetNombre() {
		producto.setNombre("newnombre");
	    assertEquals("newnombre", producto.getNombre());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetTipo() {
	    assertEquals("tipo", producto.getTipo());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTipo() {
		producto.setTipo("newtipo");
	    assertEquals("newtipo", producto.getTipo());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetMarca() {
	    assertEquals("marca", producto.getMarca());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetMarca() {
		producto.setMarca("newmarca");
	    assertEquals("newmarca", producto.getMarca());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetTamanyo() {
	    assertEquals("tamanyo", producto.getTamanyo());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetTamanyo() {
		producto.setTamanyo("newtamanyo");
	    assertEquals("newtamanyo", producto.getTamanyo());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetPrecio() {
	    assertEquals(0.0, producto.getPrecio(),0.001);
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetPrecio() {
		producto.setPrecio(1.1);
	    assertEquals(1.1, producto.getPrecio(), 0.001);
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetStock() {
	    assertEquals(0, producto.getStock());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetStock() {
		producto.setStock(1);
	    assertEquals(1, producto.getStock());
	}
}



