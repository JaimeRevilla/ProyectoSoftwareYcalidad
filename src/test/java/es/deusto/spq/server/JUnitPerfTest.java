package es.deusto.spq.server;

public @interface JUnitPerfTest {

	int durationMs();

	int threads();

}
