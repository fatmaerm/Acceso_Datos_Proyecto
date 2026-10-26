package entidades;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Tratamiento implements Comparable <Tratamiento> {

	// atributos
	private Long id;
	private String nombre;
	private LocalDate fechaIni = LocalDate.now();
	private boolean consentimiento = false;

	// private Long idpaciente; // CARGA LIGERA

	private Paciente paciente; // CARGA PESADA
	private List<Cita> citas = new ArrayList<>();

	// constructor
	public Tratamiento() {}

	public Tratamiento(Long id, String nombre, LocalDate fechaIni, boolean consentimiento, Paciente paciente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaIni = fechaIni;
		this.consentimiento = consentimiento;
		this.paciente = paciente;

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

	public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public boolean isConsentimiento() {
		return consentimiento;
	}

	public void setConsentimiento(boolean consentimiento) {
		this.consentimiento = consentimiento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	// Método
	@Override
	public String toString() {
		return "Tratamiento [id=" + id + ", nombre=" + nombre + ", fechaIni=" + fechaIni + ", consentimiento="
				+ consentimiento + "]";
	}

	public void mostrarTratamiento() {
		System.out.println("Tratamiento: ");
		System.out.println("id: " + id);
		System.out.println("nombre: " + nombre);
		System.out.println("fecha inicio: " + fechaIni);
		System.out.println("consentimiento: " + consentimiento);
		for (Cita cita : citas) {
			cita.mostrarCita();
		}
	}

	@Override
	public int compareTo(Tratamiento o) {
		// TODO Auto-generated method stub
		return id.compareTo(o.getId());
	}

}
