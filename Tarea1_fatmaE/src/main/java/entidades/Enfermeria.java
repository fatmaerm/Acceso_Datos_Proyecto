package entidades;

public class Enfermeria extends Empleado{

	
	
	// atributos 
	private Categoria categoria;

	
	// constructor 
	public Enfermeria() {
		super();
	}

	public Enfermeria(Categoria categoria) {
		super();
		this.categoria = categoria;
	}


	// getters y setters
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	
	
	
	
	
}
