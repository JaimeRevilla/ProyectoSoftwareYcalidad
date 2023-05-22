package es.deusto.spq.client;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Answers;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import es.deusto.spq.pojo.UserData;
import es.deusto.spq.windows.VentanaInicial;

@PerformanceTest
public class ClienteOperacionesTestRendimiento { 

    @Mock
    private Client client;

    @Mock(answer=Answers.RETURNS_DEEP_STUBS)
    private WebTarget webTarget;

    @Captor
    private ArgumentCaptor<Entity<UserData>> userDataEntityCaptor;

//    @Captor
//    private ArgumentCaptor<Entity<DirectMessage>> directMessageEntityCaptor;

    private ClienteOperaciones exampleClient;
    
    private static final String USER = "dipina";
	private static final String PASSWORD = "dipina";
	private static final String MAIL = "dipina";
	

    @Before
    public void setUp() {
    	MockitoAnnotations.openMocks(this);
        // prepare static mock of ClientBuilder
        try (MockedStatic<ClientBuilder> clientBuilder = Mockito.mockStatic(ClientBuilder.class)) {
            clientBuilder.when(ClientBuilder::newClient).thenReturn(client);
            when(client.target("http://localhost:8080/rest/resource")).thenReturn(webTarget);

            exampleClient = new ClienteOperaciones("localhost", "8080");
        }
    }

    @Test
    public void testRegisterUser() { 
        when(webTarget.path("register")).thenReturn(webTarget);

        Response response = Response.ok().build();
        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
        assertTrue(exampleClient.registerUser("test-login", "passwd", "email"));

        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
        assertEquals(null, userDataEntityCaptor.getValue().getEntity().getLogin());
        assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getContrasenia());
        assertEquals("email", userDataEntityCaptor.getValue().getEntity().getEmail());
    }

    @Test
    public void testRegisterUserWithError() {
        when(webTarget.path("register")).thenReturn(webTarget);

        Response response = Response.serverError().build();
        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
        assertFalse(exampleClient.registerUser("test-login", "passwd", "email"));

        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
        assertEquals(null, userDataEntityCaptor.getValue().getEntity().getLogin());
        assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getContrasenia());
        assertEquals("email", userDataEntityCaptor.getValue().getEntity().getEmail());
    }

    @Test
	public void testLogUser() {
		 when(webTarget.path("login")).thenReturn(webTarget);
		 
		 Response response = Response.ok().build();
		 when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		 assertTrue(exampleClient.logUser("test-login", "passwd"));
		 
		 verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
		 assertEquals(null, userDataEntityCaptor.getValue().getEntity().getLogin());
		 assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getContrasenia());
	}
	
	@Test
    public void testLogUserWithError() {
		when(webTarget.path("login")).thenReturn(webTarget);

        Response response = Response.serverError().build();
        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
		assertFalse(exampleClient.logUser("test-login", "passwd"));
       
        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
        assertEquals(null, userDataEntityCaptor.getValue().getEntity().getLogin());
        assertEquals("passwd", userDataEntityCaptor.getValue().getEntity().getContrasenia());
    }
    
//    @Test
//    public void testSayMessage() {
//        when(webTarget.path("sayMessage")).thenReturn(webTarget);
//
//        Response response = mock(Response.class);
//        when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
//        when(response.readEntity(String.class)).thenReturn("server says hello");
//
//        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
//        assertTrue(exampleClient.sayMessage("test-login", "passwd", "hello world"));
//
//        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(directMessageEntityCaptor.capture());
//        assertEquals("hello world", directMessageEntityCaptor.getValue().getEntity().getMessageData().getMessage());
//        assertEquals("test-login", directMessageEntityCaptor.getValue().getEntity().getUserData().getLogin());
//        assertEquals("passwd", directMessageEntityCaptor.getValue().getEntity().getUserData().getPassword());
//    }
//
//    @Test
//    public void testSayMessageWithError() {
//        when(webTarget.path("sayMessage")).thenReturn(webTarget);
//
//        Response response = Response.serverError().build();
//        when(webTarget.request(MediaType.APPLICATION_JSON).post(any(Entity.class))).thenReturn(response);
//        assertFalse(exampleClient.sayMessage("test-login", "passwd", "hello world"));
//
//        verify(webTarget.request(MediaType.APPLICATION_JSON)).post(directMessageEntityCaptor.capture());
//        assertEquals("hello world", directMessageEntityCaptor.getValue().getEntity().getMessageData().getMessage());
//        assertEquals("test-login", directMessageEntityCaptor.getValue().getEntity().getUserData().getLogin());
//        assertEquals("passwd", directMessageEntityCaptor.getValue().getEntity().getUserData().getPassword());
//    }
//
//	  @Test
//	  public void testMain() {
//	    String hostname = "localhost";
//	    String port = "8080";
//	    ClienteOperaciones clienteOP = new ClienteOperaciones(hostname, port);
//
//	    String user = "test_user";
//	    String password = "test_password";
//	    String mail = "test_mail@example.com";
//
//	    clienteOP = spy(clienteOP);
//	    Response response = mock(Response.class);
//	    when(response.getStatus()).thenReturn(Response.Status.OK.getStatusCode());
//	    assertTrue(ClienteOperaciones.registerUser(user, password, mail));
//	    
//	    verify(webTarget.request(MediaType.APPLICATION_JSON)).post(userDataEntityCaptor.capture());
//	    assertEquals(user, userDataEntityCaptor.getValue().getEntity().getLogin());
//	    assertEquals(password, userDataEntityCaptor.getValue().getEntity().getContrasenia());
//	    assertEquals(mail, userDataEntityCaptor.getValue().getEntity().getEmail());
//	    VentanaInicial loginWindow = new VentanaInicial(null);
////  
//	  }
}




