package entidades;

import java.io.Serializable;

public class Medicamento implements Serializable{

	// atributos
	private Long id;
	private String nombre;
	private String principioActivo;
	private double dosisMax;

	// constructor

	public Medicamento() {
	}

	public Medicamento(Long id, String nombre, String principioActivo, double dosisMax) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.principioActivo = principioActivo;
		this.dosisMax = dosisMax;
	}

	// getter y setters

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

	public String getPrincipioActivo() {
		return principioActivo;
	}

	public void setPrincipioActivo(String principioActivo) {
		this.principioActivo = principioActivo;
	}

	public double getDosisMax() {
		return dosisMax;
	}

	public void setDosisMax(double dosisMax) {
		this.dosisMax = dosisMax;
	}

	// Método
	@Override
	public String toString() {
		return "Medicamento [id=" + id + ", nombre=" + nombre + ", principioActivo=" + principioActivo + ", dosisMax="
				+ dosisMax + "]";
	}

	public void mostrarMedicamento() {
		System.out.println("  Medicamento:");
		System.out.println("id: " + id);
		System.out.println("nombre: " + nombre);
		System.out.println("principio activo: " + principioActivo);
		System.out.println("dosis máxima: " + dosisMax);
	}

}
