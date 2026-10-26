package entidades;

import java.time.LocalDateTime;

public class Revision extends Cita {

	// atributos

	private Long idR;

	// constructores

	public Revision() {
	}

	public Revision(Long id, LocalDateTime fechaHora, String anotaciones, Tratamiento tratamiento, Long idR) {
		super(id, fechaHora, anotaciones, tratamiento);
		this.idR = idR;
	}
	// getters y setters

	public Long getIdR() {
		return idR;
	}

	public void setIdR(Long idR) {
		this.idR = idR;
	}

	// método
	@Override
	public String toString() {
		return "Revision [idR=" + idR + "]";
	}

	public void mostrarRevision() {
		super.mostrarCita();
		System.out.println("IdR: " + idR);

	}
}
