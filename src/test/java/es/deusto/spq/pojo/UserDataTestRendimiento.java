package es.deusto.spq.pojo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;

@PerformanceTest
public class UserDataTestRendimiento {

    UserData userData;
    
    @Before
    public void setUp() {
        userData = new UserData();
        userData.setLogin("test-login");
        userData.setContrasenia("passwd");
        userData.setDni("dni");
    }

    @Test
    public void testGetLogin() {
        assertEquals("test-login", userData.getLogin());
    }

    @Test
    public void testGetPassword() {
        assertEquals("passwd", userData.getContrasenia());
    }

    @Test
    public void testToString() {
        assertEquals("[login=test-login, password=passwd]", userData.toString());
    }
    @Test
    public void testGetDni() {
    	assertEquals("dni", userData.getDni());
    }
    @Test
    public void testSetDni() {
    	userData.setDni("newDni");
    	assertEquals("newDni", userData.getDni());
    }
    


        @Test
        public void testUserDataConstructor() {
            String nombre = "Juan Perez";
            String dni = "12345678A";
            String contrasenia = "123456";
            String email = null;
            UserData userData = new UserData(nombre, dni, null, contrasenia);
            assertNotNull(userData);
            assertEquals(nombre, userData.getNombre());
            assertEquals(dni, userData.getDni());
            assertEquals(email, userData.getEmail());
            assertEquals(contrasenia, userData.getContrasenia());
        }

}


