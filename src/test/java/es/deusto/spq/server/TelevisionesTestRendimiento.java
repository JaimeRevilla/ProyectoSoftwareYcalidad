package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest

public class TelevisionesTestRendimiento {
	@Test
	@PerformanceTest
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getTelevisionesTest() {
		Televisiones televisiones= new Televisiones(0, null, null, null, null, 0, 0, null, null);
		TipoTV tipotv = TipoTV.CURVA;
		televisiones.setTipoTV(tipotv);
		assertEquals(tipotv, televisiones.getTipoTV());
		
	}
}