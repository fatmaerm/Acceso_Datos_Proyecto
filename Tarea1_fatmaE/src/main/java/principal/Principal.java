package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;
import java.util.Scanner;

import entidades.Alergia;
import entidades.Medicamento;
import entidades.Perfil;
import entidades.Sesion;

public class Principal {

    static Scanner sc = new Scanner(System.in);
    static Sesion sesion = new Sesion(); 
    public static  ArrayList<Alergia> lista = new ArrayList<>();
    static int opcion ;
    static int op2;
    public static File carpeta = new File("ficheros");
    public static void main(String[] args) {
      

        do {
           
            if (sesion.getPerfil() == Perfil.INVITADO) {
                
                // --- MENU INVITADO ---
                System.out.println("--- MENU INVITADO ---");
                System.out.println("1. Login");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");
                opcion = sc.nextInt();

                sc.nextLine(); 
                
                switch (opcion) {
                    case 1:
                        hacerLogin();
                        break;
                    case 0:
                        System.out.println("Saliendo...");
                        break;
                    default:
                        System.out.println("Opcion incorrecta.");
                }
                
            } else {
            
                // --- SUBMENU ---
                System.out.println("--- SESION INICIADA ---");
                System.out.println("Bienvenido: " + sesion.getNombre() );

                do {
                    mostrarOpciones(); 

                    System.out.print("Elige una opcion: ");
                    op2 = sc.nextInt();
                    sc.nextLine(); 

                    switch (op2) {
                        case 1:
                            sesion.cerrarSesion(); 
                            System.out.println("Has cerrado sesion correctamente");
                            break;
                        case 2:
                            altaEmpleado();
                            break;
                        case 3:
                            verAlergias();
                            break;
                        case 4:
                            nuevaAlergia();
                            break;
                        case 5:
                            editarAlergia();
                            break;
                        default:
                            System.out.println("Opción incorrecta");
                    }
                } while (op2 != 1); 
            }
        } while (opcion != 0);
    }
    
    
    // ==================================== MÉTODOS =====================================
    
    
    // -------------------- SUBMENU ------------------------
    static void mostrarOpciones() {
      
        switch (sesion.getPerfil()) {
            case SECRETARIADO: {
                System.out.println("2. Alta de empleado");
                break;}
            case ENFERMERIA: {
                System.out.println("3. Ver alergias");
                System.out.println("4. Nueva alergia");
                System.out.println("5. Editar alergia");
                break;}
            case ADMINISTRADOR: {
                System.out.println("2. Alta de empleado");
                System.out.println("3. Ver alergias");
                System.out.println("4. Nueva alergia");
                System.out.println("5. Editar alergia");
                break;}
        }
    }
    
    
    // -------------------- LOGIN ----------------------
    static void hacerLogin() {
    	String usu ;
        String contr ;
    	do {
        System.out.print("Usuario: ");
          usu = sc.next();
        System.out.print("Contraseña: ");
          contr = sc.next();
    	}
        while (usu.equals("") || contr.equals("")) ;

        // comprobamos que sea admin
    	try {
            Properties prop = new Properties();
            prop.load(new FileReader("application.properties"));
            
            String adminU = prop.getProperty("admin.usuario");
            String adminP = prop.getProperty("admin.contrasenia");

            if (usu.equalsIgnoreCase(adminU) && contr.equalsIgnoreCase(adminP)) {
                sesion = new Sesion(usu,"admin", Perfil.ADMINISTRADOR);
                System.out.println("¡Bienvenido Admin!");
                return;
            }
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
        }
    	

        // Comprobamos que sea uno de los usuarios
        try {
            Path ruta = Path.of("credenciales.txt");
            if (Files.exists(ruta)) {
                try (BufferedReader br = Files.newBufferedReader(ruta)) {
                	
                    String linea;
                    while ((linea = br.readLine()) != null) {
                    	
                        String[] partes = linea.split("\\|");
                        
                        if (partes.length == 4 && partes[0].equals(usu) && partes[1].equals(contr)) {
                        	
                            
                            Perfil p = Perfil.valueOf(partes[3].toUpperCase());
                            sesion = new Sesion(usu, partes[2], p);
                            System.out.println(" Bienvenido : " + partes[2]);
                            return; 
                            
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error leyendo las credenciales.");
        }

        
        System.out.println("Usuario o contraseña son incorrectos.");
    }
    
    
 // ----------------------- ALTA EMPLEADO -------------------
    static void altaEmpleado() {
    	
        System.out.println("--- ALTA DE EMPLEADO ---");
        
        if (sesion.getPerfil() == Perfil.ENFERMERIA) {
            System.out.println("No tienes permisos");
            return;
        }
        // pedimos los datos 
        String usu;
        String contr;
        String nombre;
        String apellidos; 
        int p;
        Perfil perfil = Perfil.ENFERMERIA;
        do {
        System.out.print("Introduzca el nombre: ");
         nombre = sc.nextLine();
        System.out.print("Introduzca los apellidos: ");
        apellidos = sc.nextLine();
        System.out.print("Introduzca el teléfono: ");
        String telefono= sc.next();
        System.out.print("Introduzca el email: ");
        String email = sc.next();
        System.out.print("Introduzca el nifNie: ");
        String nifNie = sc.next();
        sc.nextLine(); 
        System.out.print("Introduzca la dirección: ");
        String direccion = sc.nextLine();
        System.out.print("Introduzca el usuario: ");
        usu = sc.next();
        System.out.print("Introduzca la contraseña: ");
        contr = sc.next();
        sc.nextLine();
        System.out.print("Introduzca el perfil: ");
        System.out.println("1.Secretario");
        System.out.println("2.Enfermero");
         p= sc.nextInt(); 
        if(p==1) {
        	System.out.println("introduzca los años de experiencia: ");
        	int anEx= sc.nextInt(); 
        	perfil = Perfil.SECRETARIADO;
        }
        else if(p==2) {
        	System.out.println("introduzca la categoría: A - B o C");
        	 char categoria = sc.next().charAt(0);
        	 perfil = Perfil.ENFERMERIA;
        } else {
            System.out.println("Opción incorrecta, debe ser 1 o 2");
        }
        sc.nextLine(); 

        } while (usu.isEmpty() || contr.isEmpty() || p != 1 && p != 2);
        
        
        
        // leemos el fichero de credenciales y lo escribimos
        Path ruta = Path.of("credenciales.txt");
        
       
        boolean existe = false;

        try (BufferedReader br = Files.newBufferedReader(ruta)) {
        	
        	 String linea; 
             while((linea = br.readLine())!=null){
             	String[] partes = linea.split("\\|");
             	String userC= partes[0];
		           
		          if(userC.equalsIgnoreCase(usu)) {
		        	  existe = true;
		        	  break; 
             	}
            }
        	
        } catch (Exception e) {
        	System.out.println("Error:  " + e.getMessage());  
        }
        if (existe) {
            System.out.println("El usuario ya existe ");
        } else {
        	
        	System.out.print("¿Seguro que quieres dar de alta a este empleado? (s/n): ");
        	if (!sc.nextLine().equalsIgnoreCase("s")) {
        	    System.out.println("Alta cancelada.");
        	    return;
        	}
            try (BufferedWriter bw = Files.newBufferedWriter(ruta, StandardOpenOption.APPEND)) {
            	
    			bw.write(usu + "|" + contr + "|" + nombre + " " + apellidos + "|" + perfil);
    			bw.newLine();
    			System.out.println("El empleado se ha guardado correctamente");
            	
            } catch (Exception e) {
            	System.out.println("Error:  " + e.getMessage());
            }    
        }
    }

    
    // **************************** CU3 ************************************
 
    // -----------------------  VER ALERGIAS ----------------
    static void verAlergias() {
    	// recorrer todo los fichero y voy 
        System.out.println("--- LISTA DE ALERGIAS ---");
        
        File[] ficheros = carpeta.listFiles();
        
        // comprobamos que el alrgias existe
        if (ficheros == null || ficheros.length == 0) {
            System.out.println("No hay alergias registradas");
            return;
        }
                
        for (int i = 0; i < ficheros.length; i++) {
            if (ficheros[i].getName().endsWith(".dat")) { 
                try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ficheros[i].toPath()))) {
                    while (true) {
                        try {
                            Alergia a = (Alergia) ois.readObject();
                            lista.add(a);
                        } catch (EOFException e) {
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        }
   
        // ordenamos por id
        Collections.sort(lista,(a,b) -> a.getId().compareTo(b.getId()) );
        
        // mostramos las alergias
        for (Alergia a : lista) {
        	System.out.println("\n Alergia: " + a.getId());
            a.mostrarAlergia();
        }
    }
    // ---------------------- NUEVA ALERGIA --------------------------
    static void nuevaAlergia() {
        System.out.println("--- NUEVA ALERGIA ---");
        
        System.out.print("Introduzca el nombre de la alergia: ");
        String nombre = sc.nextLine();
        System.out.print("Introduzca el nombre del medicamento: ");
        String nomMed = sc.nextLine();
        System.out.print("Introduzca el principio activo: ");
        String principio = sc.nextLine();
        double dosis;
        do {
            System.out.print("Introduzca la dosis máxima: ");
            dosis = sc.nextDouble();
            sc.nextLine();      
        } while (dosis <= 0);
        
        
        System.out.print("¿Seguro que quieres guardar esta alergia? (s/n): ");
        if (!sc.nextLine().equalsIgnoreCase("s")) {
            System.out.println("Guardado cancelado.");
            return;
        }      
        
        long maxId = 0;
        File[] ficheros = carpeta.listFiles();
        if (ficheros != null) {
            for (int i = 0; i < ficheros.length; i++) {
                String nombreFichero = ficheros[i].getName();
                String numero = nombreFichero.substring(8, nombreFichero.length() - 4);
                
                if (!numero.isEmpty()) {
                    long id = Long.parseLong(numero);
                    if (id> maxId) {
                        maxId = id;
                    }
                }
            }
        }

        long nuevoId = maxId + 1;
        // guardamos el medicamento y la alergia
        Medicamento medic = new Medicamento(nuevoId, nomMed, principio, dosis);
        Alergia nuevaAlergia = new Alergia(nuevoId, nombre, medic, null);

        Path ruta = Path.of("ficheros", "alergia_" + nuevoId + ".dat");
        
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
            oos.writeObject(nuevaAlergia);
            oos.flush();
            System.out.println("Alergia guardada :  id : " + nuevoId );
        } catch (Exception e) {
            System.out.println("Error: "  +  e.getMessage());
        }
    }
    
    //------------------------- EDITAR ALERGIA ----------------------------
    static void editarAlergia() {
        System.out.println("--- EDITAR ALERGIA ---");
        
        try {
        	// pedimos el id de la alergia a editar
            System.out.print("introduzca el id de la alergia a editar: ");
            long id = sc.nextLong();
            sc.nextLine();  
            
            Path ruta = Path.of("ficheros", "alergia_" + id + ".dat");

            if (!Files.exists(ruta)) {
                System.out.println("No existe ninguna alergia con ese id");
                return;
            }

            // Leemos 
            Alergia a;
            try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(ruta))) {
                a = (Alergia) ois.readObject();
            }

            System.out.println("Datos actuales:");
            a.mostrarAlergia();

            // Pedimos los nuevos datos 
            System.out.print("Introduzca el nuevo nombre");
            String n = sc.nextLine();
            if (!n.equals("")) {  a.setNombre(n);  }

            System.out.print("Introduzca el nuevo medicamento");
            String m = sc.nextLine();
            if (!m.equals("")) {a.getMedicamento().setNombre(m);}

            System.out.print(" Introduzca la nueva dosis");
            double d = sc.nextDouble();
            sc.nextLine();
            if (d != 0) { a.getMedicamento().setDosisMax(d); }
            
            // Guardamos los nuevos datos 
            try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(ruta))) {
                oos.writeObject(a);
                oos.flush();
            } catch (Exception e) {
                System.out.println("Error : " + e.getMessage());
            }
            
            System.out.println("La alergia ha sido actualizada");

        } catch (Exception e) {
            System.out.println("No hay alergias registradas o hubo un error");
        }
    }
}   