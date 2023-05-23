package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class CamasTestRendimiento {
	@Test
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void getCamasTest() {
		Camas camas= new Camas(0, null, null, null, null, 0, 0, null, null);
		TipoCamas tipocamas = TipoCamas.LITERA;
		camas.setTipoCamas(tipocamas);
		assertEquals(tipocamas, camas.getTipoCamas());
		
	}
}