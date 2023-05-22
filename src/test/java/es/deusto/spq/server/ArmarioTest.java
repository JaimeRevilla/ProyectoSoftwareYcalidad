package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class ArmarioTest {
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
	public void testArmario() {
		assertNotNull(armarios);
		assertEquals(numEstanterias, armarios.getNumEstanterias());
		
	}
	
	//get
	@Test
	public void getNumEstanterias() {
		assertEquals(numEstanterias, armarios.getNumEstanterias());
	}
	
	//set
	@Test
	public void setNumEstanterias() {
		armarios.setNumEstanterias(nuevonumEstanterias);
		assertEquals(nuevonumEstanterias, armarios.getNumEstanterias());
	}
	@Test
	public void getTipoArmarioTest() {
		Armarios armarios = new Armarios(nuevonumEstanterias, null, null, null, null, nuevonumEstanterias, numEstanterias, null, null, nuevonumEstanterias);
		TipoArmario tipoarmario = TipoArmario.ROBLE;
		armarios.setTipoArmario(tipoarmario);
		assertEquals(tipoarmario, armarios.getTipoArmario());
		
	}

}
