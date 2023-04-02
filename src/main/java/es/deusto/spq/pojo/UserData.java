package es.deusto.spq.pojo;

public class UserData {

	/**
	 * Atributos de la clase Usuario
	 */
	private String nombre;
	private String dni;
	private String email;
	private String contrasenia;
	
	
	/**
	 * Constructor por defecto de la clase Usuario
	 */
	public UserData() {
		
	}
	
	/**
	 * Constructor con parametros de la clase Usuario
	 * @param nombre
	 * @param dni
	 * @param email
	 * @param contrasenia
	 */
	public UserData(String nombre, String dni, String email, String contrasenia) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email; //FALTA :metodo para autorellenar el email 
		this.contrasenia = contrasenia;
	}
	
	/***
	 * Método get del atributo nombre, el atributo nombre es un String
	 * @return
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método set del atributo nombre, el atributo nombre es un String
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Método get del atributo dni, el atributo dni es un String
	 * @return devuelve el dni
	 */
	public String getDni() {
		return dni;
	}
	
	/**
	 * Método set del atributo dni, el atributo dni es un String
	 * @param dni
	 */
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	/**
	 * Método get del atributo email, el atributo email es un String
	 * @return devuelve el email del usuario
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Método set del atributo email, el atributo email es un String
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Método get del atributo contrasenia, el atributo contrasenia es un String
	 * @return devuelve la contrasenia de un usuario
	 */
	public String getContrasenia() {
		return contrasenia;
	}
	
	/**
	 * Método set del atributo contrasenia, el atributo contrasenia es un String
	 * @param contrasenia
	 */
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
    public String toString() {
        return "[Usuario=" + nombre + ", Contrasenia=" + contrasenia + "]";
    }
    
    
    
    
}