package entidades;

public class HistorialAlergia {
	// atributos
	private Long id;
	private Historial historial;
	private Alergia alergia;

	// constructor
	public HistorialAlergia() {
	}

	public HistorialAlergia(Long id, Historial historial, Alergia alergia) {
		super();
		this.id = id;
		this.historial = historial;
		this.alergia = alergia;
	}

	// getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Historial getHistorial() {
		return historial;
	}

	public void setHistorial(Historial historial) {
		this.historial = historial;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}

	// Método
	@Override
	public String toString() {
		return "HistorialAlergia [id=" + id + "]";
	}

	public void mostrarHistorialAlergia() {
		System.out.println("HistorialAlergia:");
		historial.mostrarHistorial();
		alergia.mostrarAlergia();
	}

}
