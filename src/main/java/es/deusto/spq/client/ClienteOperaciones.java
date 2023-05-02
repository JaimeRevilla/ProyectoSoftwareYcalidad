package es.deusto.spq.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.pojo.UserData;
import es.deusto.spq.windows.VentanaInicial;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClienteOperaciones {

	protected static final Logger logger = LogManager.getLogger();

	private static final String USER = "dipina";
	private static final String PASSWORD = "dipina";
	private static final String MAIL = "dipina";
	
	private Client client;
	private static WebTarget webTarget;

	public ClienteOperaciones(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest/resource", hostname, port));
	}
	public static boolean registerUser(String login, String password, String email) {
		WebTarget registerUserWebTarget = webTarget.path("register");
		//Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);
		
		UserData userData = new UserData();
		userData.setNombre(login);
		userData.setContrasenia(password);
		userData.setEmail(email);
		//Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		Response response = registerUserWebTarget.request(MediaType.APPLICATION_JSON).post(Entity.entity(userData, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			logger.error("Error connecting with the server. Code: {}", response.getStatus());
			return false;
		} else {
			logger.info("User correctly registered");
			return true;
		}
	}
	
	public boolean logUser(String name, String password) {
        WebTarget registerUserWebTarget = webTarget.path("login");
        Invocation.Builder invocationBuilder = registerUserWebTarget.request(MediaType.APPLICATION_JSON);

        UserData userData = new UserData();
        userData.setNombre(name);
        userData.setContrasenia(password);
        Response response = invocationBuilder.post(Entity.entity(userData, MediaType.APPLICATION_JSON));
        if (response.getStatus() != Status.OK.getStatusCode()) {
            logger.error("Error connecting with the server. Code: {}", response.getStatus());
            return false;
        } else {
        	logger.info("User correctly logged");
        	return  true;
//            GestorAgenda mgt = new GestorAgenda();
//            mgt.lanza();
        }
    }

//	public void sayMessage(String login, String password, String message) {
//		WebTarget sayHelloWebTarget = webTarget.path("sayMessage");
//		Invocation.Builder invocationBuilder = sayHelloWebTarget.request(MediaType.APPLICATION_JSON);
//
//		DirectMessage directMessage = new DirectMessage();
//		UserData userData = new UserData();
//		userData.setNombre(login);
//		userData.setContrasenia(password);
// 
//		directMessage.setUserData(userData);
//
//		MessageData messageData = new MessageData();
//		messageData.setMessage(message);
//		directMessage.setMessageData(messageData);
//
//		Response response = invocationBuilder.post(Entity.entity(directMessage, MediaType.APPLICATION_JSON));
//		if (response.getStatus() != Status.OK.getStatusCode()) {
//			logger.error("Error connecting with the server. Code: {}",response.getStatus());
//		} else {
//			String responseMessage = response.readEntity(String.class);
//			logger.info("* Message coming from the server: '{}'", responseMessage);
//		}
//	}

	public static void main(String[] args) {
		if (args.length != 2) {
			logger.info("Use: java Client.Client [host] [port]");
			System.exit(0);
		}

		String hostname = args[0];
		String port = args[1];

		ClienteOperaciones clienteOP = new ClienteOperaciones(hostname, port);
		new VentanaInicial(clienteOP);
		ClienteOperaciones.registerUser(USER, PASSWORD, MAIL);
//		exampleClient.sayMessage(USER, PASSWORD, "This is a test!...");
//	 
	}
	
	
}
