package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import com.github.noconnor.junitperf.JUnitPerfRule;
import com.github.noconnor.junitperf.JUnitPerfTest;
import com.github.noconnor.junitperf.JUnitPerfTestRequirement;
import com.github.noconnor.junitperf.reporting.providers.HtmlReportGenerator;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class BanioTestRendimiento {

	@Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getBanioTest() {
		Banio banio = new Banio(0, null, null, null, null, 0, 0, null, null);
		TipoBanio tipobanio = TipoBanio.DUCHA;
		banio.setTipoBanio(tipobanio);
		assertEquals(tipobanio, banio.getTipoBanio());
		
	}
}
