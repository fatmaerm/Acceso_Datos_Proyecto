
package entidades;

import java.io.Serializable;

public class Alergia implements Serializable{

	// atributos
	private Long id;
	private String nombre;
	private Medicamento medicamento;
	private Paciente paciente;

	// constructor
	public Alergia() {
	}

	public Alergia(Long id, String nombre, Medicamento medicamento, Paciente paciente) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.medicamento = medicamento;
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

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	// método

	@Override
	public String toString() {
		return "Alergia [id=" + id + ", nombre=" + nombre + "]";
	}

	//
	public void mostrarAlergia() {
		System.out.println("id: " + id);
		System.out.println("nombre: " + nombre);
		medicamento.mostrarMedicamento();
	}

}
