package entidades;

public class Sesion {
	   // atributos
		private String usuario;
		private String nombre;
		private Perfil perfil= Perfil.INVITADO;
		
		//Constructor
		public Sesion() {}
		
		public Sesion(String usuario, String nombre, Perfil perfil) {
			super();
			this.usuario = usuario;
			this.nombre = nombre;
			this.perfil = perfil;
		}
		
		//getters y setters 
		public String getUsuario() {
			return usuario;
		}

		public void setUsuario(String usuario) {
			this.usuario = usuario;
		}
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public Perfil getPerfil() {
			return perfil;
		}

		public void setPerfil(Perfil perfil) {
			this.perfil = perfil;
		}
		
		//metodo
		public void mostrarSesion() {
			System.out.println("Usuario: " + usuario);
			System.out.println("Nombre: " + nombre);
			System.out.println("Perfil: " + perfil);
		}
		
		 public void cerrarSesion() {
		        this.usuario = null;
		        this.nombre = null;
		        this.perfil = Perfil.INVITADO;
	   }
}
