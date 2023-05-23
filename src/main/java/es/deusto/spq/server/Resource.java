package es.deusto.spq.server;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.Transaction;

import es.deusto.spq.server.jdo.User;
import es.deusto.spq.pojo.DirectMessage;
import es.deusto.spq.pojo.MessageData;
import es.deusto.spq.pojo.UserData;
import es.deusto.spq.server.jdo.Message;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Path("/resource")
@Produces(MediaType.APPLICATION_JSON)
public class Resource {

	protected static final Logger logger = LogManager.getLogger();

	private int cont = 0;
	private PersistenceManager pm=null;
	private Transaction tx=null;
	

	public Resource() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		this.pm = pmf.getPersistenceManager();
		this.tx = pm.currentTransaction();
	}

	@POST
	@Path("/sayMessage")
//	public Response sayMessage(DirectMessage directMessage) {
//		User user = null;
//		try{
//			tx.begin();
//			logger.info("Creating query ...");
//			
//			try (Query<?> q = pm.newQuery("SELECT FROM " + User.class.getName() + " WHERE login == \"" + directMessage.getUserData().getNombre() + "\" &&  password == \"" + directMessage.getUserData().getContrasenia() + "\"")) {
//				q.setUnique(true);
//				user = (User)q.execute();
//				
//				logger.info("User retrieved: {}", user);
//				if (user != null)  {
//					Message message = new Message(directMessage.getMessageData().getMessage());
//					//user.getMessages().add(message);
//					pm.makePersistent(user);					 
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			tx.commit();
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//		}
//		
//		if (user != null) {
//			cont++;
//			logger.info(" * Client number: {}", cont);
//			MessageData messageData = new MessageData();
//			messageData.setMessage(directMessage.getMessageData().getMessage());
//			return Response.ok(messageData).build();
//		} else {
//			return Response.status(Status.BAD_REQUEST).entity("Login details supplied for message delivery are not correct").build();
//		}
//	}
	public Response sayMessage(DirectMessage directMessage) {
		User user = null;
		try {
			tx.begin();
			logger.info("Creating query ...");

			try (Query<?> q = pm.newQuery(User.class)) {
				q.setFilter("this.login == :login && this.password == :password");
				q.setUnique(true);
				user = (User) q.execute(directMessage.getUserData().getLogin(), directMessage.getUserData().getContrasenia());

				logger.info("User retrieved: {}", user);
				if (user != null) {
					Message message = new Message(directMessage.getMessageData().getMessage());
//					user.getMessages().add(message);
					pm.makePersistent(user);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			tx.commit();
		} finally {
			if (tx.isActive()) {
				tx.rollback();
			}
		}

		if (user != null) {
			cont++;
			logger.info(" * Client number: {} ", cont);
			MessageData messageData = new MessageData();
			messageData.setMessage(directMessage.getMessageData().getMessage());
			return Response.ok(messageData).build();
		} else {
			return Response.status(Status.BAD_REQUEST)
				.entity("Login details supplied for message delivery are not correct").build();
		}
	}
//	Añadir atributos a la clase UserData
	@POST
    @Path("/register")
    public Response registerUser(UserData userData) {
        try
        {
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getNombre());
            User user = null;
            try {
                user = pm.getObjectById(User.class, userData.getNombre());
            } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
                logger.info("Exception launched: {}", jonfe.getMessage());
            }
            logger.info("User: {}", user);
            if (user != null) {
                return Response.serverError().build();
            } else {
                logger.info("Creating user: {}", user);
                user = new User(userData.getNombre(), userData.getEmail(), userData.getContrasenia());
                pm.makePersistent(user);
                logger.info("User created: {}", user);
            }
            tx.commit();
            return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }

        }
    }
//	Añadir atributos a la clase UserData
	@POST
    @Path("/login")
    public Response loginUser(UserData userData) {
        try
        {
            tx.begin();
            logger.info("Checking whether the user already exits or not: '{}'", userData.getNombre());
            User user = null;
            try {
                user = pm.getObjectById(User.class, userData.getNombre());
            } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
                logger.info("Exception launched: {}", jonfe.getMessage());
            }
            logger.info("User: {}", user);
            if (user != null) {
                if(!user.getPassword().equals(userData.getContrasenia())) {
                    return Response.serverError().build();
                }
            } else {
                return Response.serverError().build();
            }
            tx.commit();
            return Response.ok().build();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }

        }
    }
	
	
//	@POST
//    @Path("/product")
//    public Response ObtenerProducto(Producto product, String nombre) throws Exception {
//        Producto producto = null;
//		try
//        {
//            tx.begin();
//            logger.info("Checking whether the user already exits or not: '{}'", nombre);
//           
//            try (Query<?> q = pm.newQuery("SELECT FORM"+ Producto.class.getName()+"WHERE NOMBRE == "+ product.getNombre())) {
//                q.setUnique(true);
//                producto = (Producto)q.execute();
//                logger.info("Producto retrieved: {}", producto);
//            } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
//                logger.info("Exception launched: {}", jonfe.getMessage());
//            }
//            tx.commit();
//            return Response.ok().build();
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//
//        }
//    }
//	@POST
//    @Path("/obtenerProducto")
//	public ArrayList<Producto> ObtenerProducto(String nombreP) {
//		Producto producto = null;
//		ArrayList<Producto> al = null;
//		try{
//			tx.begin();
//			logger.info("Creating query ...");
//			
//			try (Query<?> q = pm.newQuery("SELECT FROM " + Producto.class + " WHERE nombre == \"" + nombreP + "\"" )) {
//				q.setUnique(true);
//				producto = (Producto)q.execute();
//				al.add(producto);
//				
//				logger.info("Producto cargado: {}", producto);
//
//
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//			tx.commit();
//			return al;
//
//		} finally {
//			if (tx.isActive()) {
//				tx.rollback();
//			}
//		}
//    }
//	CODIGO QUE ESTABA YA 
//	@POST
//	@Path("/register")
//	public Response registerUser(UserData userData) {
//		try
//        {	
//            tx.begin();
//            logger.info("Checking whether the user already exits or not: '{}'", userData.getLogin());
//			User user = null;
//			try {
//				user = pm.getObjectById(User.class, userData.getLogin());
//			} catch (javax.jdo.JDOObjectNotFoundException jonfe) {
//				logger.info("Exception launched: {}", jonfe.getMessage());
//			}
//			logger.info("User: {}", user);
//			if (user != null) {
//				logger.info("Setting password user: {}", user);
//				user.setPassword(userData.getPassword());
//				logger.info("Password set user: {}", user);
//			} else {
//				logger.info("Creating user: {}", user);
//				user = new User(userData.getLogin(), userData.getPassword());
//				pm.makePersistent(user);					 
//				logger.info("User created: {}", user);
//			}
//			tx.commit();
//			return Response.ok().build();
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//      
//		}
//	}
	
//	@POST
//    @Path("/añadirProducto")
//    public Response añadirProducto(Producto producto) {
////		0;Armario;ROBLE;IKEA;250x58x236 cm;200.5;200;imagenes/armarioRoble.png
////		1;Armario;ABEDUL;IKEA;250x58x236 cm;100.5;200;imagenes/armarioAbedul.png
////		2;Armario;PINO;IKEA;250x58x236 cm;50.5;200;imagenes/armarioPino.png
////		3;Armario;EUCALIPTO;IKEA;250x58x236 cm;25.5;200;imagenes/armarioEucalipto.png
////		4;Armario;HAYA;IKEA;250x58x236 cm;190.9;200;imagenes/armarioHaya.png
////		5;Cama;LITERA;IKEA;140x190 cm;300.2;200;imagenes/camasLitera.png
////		6;Cama;SOFA_CAMA;IKEA;140x190 cm;250.0;200;imagenes/camaSofacama.png
////		7;Cama;ACUATICA;IKEA;140x190 cm;600.9;200;imagenes/camaAcuatica.png
////		8;Cama;ELECTRICA;IKEA;140x190 cm;900.9;200;imagenes/camaElectrica.png
//		try
//        {
//            tx.begin();
//            logger.info("Checking whether the producto already exits or not: '{}'", producto.getNombre());
//            try {
//                producto = pm.getObjectById(Producto.class, producto.getNombre());
//            } catch (javax.jdo.JDOObjectNotFoundException jonfe) {
//                logger.info("Exception launched: {}", jonfe.getMessage());
//            }
//            logger.info("Producto: {}", producto);
//            if (producto != null) {
//                return Response.serverError().build();
//            } else {
//                logger.info("Creating product: {}", producto);
//               producto = new Producto(producto.getCod(), producto.getNombre(),producto.getTipo(), producto.getMarca(), producto.getTamanyo(), producto.getPrecio(), producto.getStock(), producto.getRuta());
//                pm.makePersistent(producto);
//                logger.info("Producto created: {}", producto);
//            }
//            tx.commit();
//            return Response.ok().build();
//        }
//        finally
//        {
//            if (tx.isActive())
//            {
//                tx.rollback();
//            }
//
//        }
//    }

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public Response sayHello() {
		return Response.ok("Hello world!").build();
	}
}
