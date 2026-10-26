package entidades;

import java.time.LocalDateTime;

public class Cita {
	//
	protected Long id;
	protected LocalDateTime fechaHora;
	protected String anotaciones;
	protected Tratamiento tratamiento;

	// constructor
	public Cita() {
	}

	public Cita(Long id, LocalDateTime fechaHora, String anotaciones, Tratamiento tratamiento) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.anotaciones = anotaciones;
		this.tratamiento = tratamiento;
	}
	
	// getters y setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(LocalDateTime fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getAnotaciones() {
		return anotaciones;
	}

	public void setAnotaciones(String anotaciones) {
		this.anotaciones = anotaciones;
	}

	public Tratamiento getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(Tratamiento tratamiento) {
		this.tratamiento = tratamiento;
	}

	// método

	@Override
	public String toString() {
		return "Cita [id=" + id + ", fechaHora=" + fechaHora + ", anotaciones=" + anotaciones + "]";
	}
	public void mostrarCita() {
		System.out.println("Cita : ");
		System.out.println("id: " + id);
		System.out.println("fecha y hora: " + fechaHora);
		System.out.println("anotaciones: " + anotaciones);
	}

}
