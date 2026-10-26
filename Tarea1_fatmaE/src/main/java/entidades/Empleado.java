package entidades;

public class Empleado {
	
	 // atributos
    protected Long id; 
    protected String nombre; 
    protected String apellidos; 
    protected String telefono; 
    protected String email; 
    protected String nifNie; 
    protected String direccion;
    
     //constructor 
    
    public Empleado () {}
	public Empleado(Long id, String nombre, String apellidos, String telefono, String email, String nifNie,
			String direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.email = email;
		this.nifNie = nifNie;
		this.direccion = direccion;
	}
	
	// getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNifNie() {
		return nifNie;
	}

	public void setNifNie(String nifNie) {
		this.nifNie = nifNie;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	} 
    
    
    public void mostar() {
    	
    	
    	
    }
    
    
}
