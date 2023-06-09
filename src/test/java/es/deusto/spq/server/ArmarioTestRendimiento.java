package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class ArmarioTestRendimiento {
	private Armarios armarios;
	private int numEstanterias = 0;
	private int nuevonumEstanterias = 1;
	@Before
	public void setUp() throws Exception {
		armarios = new Armarios(0, null, null, null, null, 0.0, 0, null, TipoArmario.ROBLE, numEstanterias);
	}

	@After
	public void tearDown() throws Exception {
	}
	


	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void testArmario() {
		assertNotNull(armarios);
		assertEquals(numEstanterias, armarios.getNumEstanterias());
		
	}
	
	//get
	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getNumEstanterias() {
		assertEquals(numEstanterias, armarios.getNumEstanterias());
	}
	
	//set
	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void setNumEstanterias() {
		armarios.setNumEstanterias(nuevonumEstanterias);
		assertEquals(nuevonumEstanterias, armarios.getNumEstanterias());
	}
	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getTipoArmarioTest() {
		Armarios armarios = new Armarios(nuevonumEstanterias, null, null, null, null, nuevonumEstanterias, numEstanterias, null, null, nuevonumEstanterias);
		TipoArmario tipoarmario = TipoArmario.ROBLE;
		armarios.setTipoArmario(tipoarmario);
		assertEquals(tipoarmario, armarios.getTipoArmario());
		
	}

}
