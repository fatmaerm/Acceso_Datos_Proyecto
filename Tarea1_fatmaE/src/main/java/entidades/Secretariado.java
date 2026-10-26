package entidades;

public class Secretariado extends Empleado {
	
	// atributos
	private int numAnios; 

    // constructor
	public Secretariado() {}
	
	
	public Secretariado(Long id, String nombre, String apellidos, String telefono, String email, String nifNie,
			String direccion) {
		super(id, nombre, apellidos, telefono, email, nifNie, direccion);
	}
	


    // getters y setters

    
	public int getNumAnios() {
		return numAnios;
	}
	public void setNumAnios(int numAnios) {
		this.numAnios = numAnios;
	}

	
	
	// Método
 
	@Override
	public String toString() {
		return "Secretariado [numAnios=" + numAnios + "]";
	}



	




	
	
}
