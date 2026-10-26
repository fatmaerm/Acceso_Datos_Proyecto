package entidades;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Paciente {

	// atributos
	private Long id;
	private String nombreP;
	private LocalDate fechaNac;
	private String telefono;
	private String email;
	private String direccion;
	private String nifNie;

	private Historial historial;

//	private Set<Long>idTratamientos; //CARGA LIGERA 
	private Set<Tratamiento> tratamientos = new TreeSet<>(); // CARGA PESADA
	private Set<Alergia> alergias = new HashSet<>();;

	// constructor
	public Paciente() {
	}

	public Paciente(Long id, String nombreP, LocalDate fechaNac, String telefono, String email, String direccion,
			String nifNie, Historial historial) {
		super();
		this.id = id;
		this.nombreP = nombreP;
		this.fechaNac = fechaNac;
		this.telefono = telefono;
		this.email = email;
		this.direccion = direccion;
		this.nifNie = nifNie;
		this.historial = historial;

	}

	// getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreP() {
		return nombreP;
	}

	public void setNombreP(String nombreP) {
		this.nombreP = nombreP;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNifNie() {
		return nifNie;
	}

	public void setNifNie(String nifNie) {
		this.nifNie = nifNie;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Set<Tratamiento> getTratamientos() {
		return tratamientos;
	}

	public void setTratamientos(Set<Tratamiento> tratamientos) {
		this.tratamientos = tratamientos;
	}

	public Set<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(Set<Alergia> alergias) {
		this.alergias = alergias;
	}

	// Método

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nombreP=" + nombreP + ", fechaNac=" + fechaNac + ", telefono=" + telefono
				+ ", email=" + email + ", direccion=" + direccion + ", nifNie=" + nifNie + "]";
	}

	public void mostrarPaciente() {
		System.out.println("Paciente: ");
		System.out.println("id: " + id);
		System.out.println("nombre: " + nombreP);
		System.out.println("fecha nacimiento: " + fechaNac);
		System.out.println("teléfono: " + telefono);
		System.out.println("email: " + email);
		System.out.println("dirección: " + direccion);
		System.out.println("NIF/NIE: " + nifNie);
		System.out.println("Historial:");
		historial.mostrarHistorial();
		System.out.println("Tratamientos: ");
		for (Tratamiento t : tratamientos) {
			t.mostrarTratamiento();
		}
	}

}
