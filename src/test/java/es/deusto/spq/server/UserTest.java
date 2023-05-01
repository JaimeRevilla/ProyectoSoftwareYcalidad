package es.deusto.spq.server;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	
    private Usuario usuario;
	 @Before
	    public void setUp() {
		 usuario = new Usuario("nombre", "dni", "email", "domicilio", "contrasenia", 0);
	    }
	@Test
	public void testGetDni() {
	    assertEquals("dni", usuario.getDni());
	}
	
	@Test
	public void testSetDni() {
		usuario.setDni("newdni");
	    assertEquals("newdni", usuario.getDni());
	}
	@Test
	public void testGetEmail() {
	    assertEquals("email", usuario.getEmail());
	}
	
	@Test
	public void testSetEmail() {
		usuario.setEmail("newemail");
	    assertEquals("newemail", usuario.getEmail());
	}
	@Test
	public void testGetNombre() {
	    assertEquals("nombre", usuario.getNombre());
	}
	@Test
	public void testSetNombre() {
		usuario.setNombre("newnombre");
	    assertEquals("newnombre", usuario.getNombre());
	}

	@Test
	public void testGetDomicilio() {
	    assertEquals("domicilio", usuario.getDomicilio());
	}
	@Test
	public void testSetDomicilio() {
		usuario.setDomicilio("newdomicilio");
	    assertEquals("newdomicilio", usuario.getDomicilio());
	}
	@Test
	public void testGetContrasenia() {
	    assertEquals("contrasenia", usuario.getContrasenia());
	}
	
	@Test
	public void testSetContrasenia() {
		usuario.setContrasenia("newcontrasenia");
	    assertEquals("newcontrasenia", usuario.getContrasenia());
	}
	@Test
	public void testGetPermisos() {
	    assertEquals(0, usuario.isPermisos());
	}
	
	@Test
	public void testSetPermisos() {
		usuario.setPermisos(1);
	    assertEquals(1, usuario.isPermisos());
	}
	
}