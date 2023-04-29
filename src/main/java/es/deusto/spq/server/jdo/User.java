package es.deusto.spq.server.jdo;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class User {
	@PrimaryKey
	String login=null;
	String password=null;
	String email=null;
	
//	@Persistent(mappedBy="user", dependentElement="true")
//	@Join
//	Set<Message> messages = new HashSet<>();

	public User(){
		
	}
	
	public User(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email= email;
	}
	
//	public void addMessage(Message message) {
//		messages.add(message);
//	}
//
//	public void removeMessage(Message message) {
//		messages.remove(message);
//	}

	//Habrá que modificar
	public String getLogin() {
		return this.login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
//	 public Set<Message> getMessages() {return this.messages;}
//	 
//	 public String toString() {
//		StringBuilder messagesStr = new StringBuilder();
//		for (Message message: this.messages) {
//			messagesStr.append(message.toString() + " - ");
//		}
		//Habrá que modificar
//        return "User: login --> " + this.login + ", password -->  " + this.password + ", messages --> [" + messagesStr + "]";
//    }
}
