package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EspejoTest {
	private Espejo espejo;
	private boolean marco = false;
	
	private boolean nuevomarco = true;

	@Before
	public void setUp() throws Exception {
		espejo = new Espejo(0, null, null, null, null, 0, 0, null, null, marco);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testEspejo() {
		assertNotNull(espejo);
	}
	
	
	@Test
	public void getMarco() {
		assertEquals(marco, espejo.isMarco());
	}
					
		
	@Test	
	public void setMarco() {
		espejo.setMarco(nuevomarco);
		assertEquals(nuevomarco, espejo.isMarco());
	}
	@Test
	public void getTipoEspejoTest() {
		Espejo espejo = new Espejo(0, null, null, null, null, 0, 0, null, null, marco);
		TipoEspejo tipoespejo = TipoEspejo.RECTANGULAR;
		espejo.setTipoEspejo(tipoespejo);
		assertEquals(tipoespejo, espejo.getTipoEspejo());
		
	}

}
