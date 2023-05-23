package es.deusto.spq.pojo;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.client.PerformanceTest;
import es.deusto.spq.server.JUnitPerfTest;
import es.deusto.spq.server.JUnitPerfTestRequirement;

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
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void testGetLogin() {
        assertEquals("test-login", userData.getLogin());
    }

    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void testGetPassword() {
        assertEquals("passwd", userData.getContrasenia());
    }

    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void testToString() {
        assertEquals("[login=test-login, password=passwd]", userData.toString());
    }
    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void testGetDni() {
    	assertEquals("dni", userData.getDni());
    }
    @Test
	@PerformanceTest
    @JUnitPerfTest(threads = 2, durationMs = 1000)
	@JUnitPerfTestRequirement(meanLatency = 100)
    public void testSetDni() {
    	userData.setDni("newDni");
    	assertEquals("newDni", userData.getDni());
    }
    


        @Test
    	@PerformanceTest
        @JUnitPerfTest(threads = 2, durationMs = 1000)
    	@JUnitPerfTestRequirement(meanLatency = 100)
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


