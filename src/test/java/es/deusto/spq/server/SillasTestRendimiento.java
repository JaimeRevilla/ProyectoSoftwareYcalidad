package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class SillasTestRendimiento {
	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getSillasTest() {
		Sillas sillas= new Sillas(0, null, null, null, null, 0, 0, null, null);
		TipoSillas tiposillas = TipoSillas.OFICINA;
		sillas.setTipoSillas(tiposillas);
		assertEquals(tiposillas, sillas.getTipoSillas());
		
	}
}
