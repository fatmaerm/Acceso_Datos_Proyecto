package entidades;

public class Especialidad {

	// atributos
	
	private Long id; 
	private String nombre;

	
	// constructor 
	
	public Especialidad() {
		
	}


	public Especialidad(Long id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
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
	
	
}
