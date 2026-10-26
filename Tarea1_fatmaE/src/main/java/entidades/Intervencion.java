package entidades;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Intervencion extends Cita {

	// atributos
	private Long idI;
	private LocalTime duracion;

	// constructor
	public Intervencion() {
	}

	// ***
	public Intervencion(Long id, LocalDateTime fechaHora, String anotaciones, Tratamiento tratamiento, Long idI,
			LocalTime duracion) {
		super(id, fechaHora, anotaciones, tratamiento);
		this.idI = idI;
		this.duracion = duracion;
	}

	// getters y setters
	public Long getIdI() {
		return idI;
	}

	public void setIdI(Long idI) {
		this.idI = idI;
	}

	public LocalTime getDuracion() {
		return duracion;
	}

	public void setDuracion(LocalTime duracion) {
		this.duracion = duracion;
	}

	// método
	@Override
	public String toString() {
		return "Intervencion [idI=" + idI + ", duracion=" + duracion + "]";
	}

	// Método mostrar
	public void mostrarIntervencion() {
		super.mostrarCita();
		System.out.println("IdI: " + idI);
		System.out.println("Duración: " + duracion);
	}

}
