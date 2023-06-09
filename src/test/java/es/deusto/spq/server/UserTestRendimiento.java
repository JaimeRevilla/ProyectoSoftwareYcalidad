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
public class UserTestRendimiento {
	
    private Usuario usuario;
	 @Before
	    public void setUp() {
		 usuario = new Usuario("nombre", "dni", "email", "domicilio", "contrasenia", 0);
	    }
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetDni() {
	    assertEquals("dni", usuario.getDni());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetDni() {
		usuario.setDni("newdni");
	    assertEquals("newdni", usuario.getDni());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetEmail() {
	    assertEquals("email", usuario.getEmail());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetEmail() {
		usuario.setEmail("newemail");
	    assertEquals("newemail", usuario.getEmail());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetNombre() {
	    assertEquals("nombre", usuario.getNombre());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetNombre() {
		usuario.setNombre("newnombre");
	    assertEquals("newnombre", usuario.getNombre());
	}

	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetDomicilio() {
	    assertEquals("domicilio", usuario.getDomicilio());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetDomicilio() {
		usuario.setDomicilio("newdomicilio");
	    assertEquals("newdomicilio", usuario.getDomicilio());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetContrasenia() {
	    assertEquals("contrasenia", usuario.getContrasenia());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetContrasenia() {
		usuario.setContrasenia("newcontrasenia");
	    assertEquals("newcontrasenia", usuario.getContrasenia());
	}
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testGetPermisos() {
	    assertEquals(0, usuario.isPermisos());
	}
	
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testSetPermisos() {
		usuario.setPermisos(1);
	    assertEquals(1, usuario.isPermisos());
	}
	
}