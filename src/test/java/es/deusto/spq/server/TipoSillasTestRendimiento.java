package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
@PerformanceTest
public class TipoSillasTestRendimiento {
	@Test
	@JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
	public void Test() {
		assertEquals(5, TipoSillas.values().length);
	}
}