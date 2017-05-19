package ui;

//-----Importamos paquetes propios
import java.util.ArrayList;
import java.util.Scanner;

//-----Importamos las clases
import datos.BBDD;
import modelos.Libros;
import dao.DAOArchivo;

public class Principal {

//-----------------------------------------MÉTODOS-----------------------------------------
//-----Método para imprimir el menú
	private static void imprimirMenu(){
		System.out.println();
		System.out.println("===========MENÚ===========");
		System.out.println();
		System.out.println("1.- Alta de libro");
		System.out.println("2.- Eliminación de libro");
		System.out.println("3.- Búsqueda de libro");
		System.out.println("4.- Listado de libros");
		System.out.println("==========================");
		System.out.println("5.- Salir");
		System.out.println("==========================");
		
	}
	
//-----Método para dar de alta un libro
	private static void altaLibro(){
			System.out.print("ISBN: ");
			int isbn=teclado.nextInt();
			teclado.nextLine();
			
			System.out.print("Título: ");
			String titulo=teclado.nextLine();
			
			System.out.print("Autor:  ");
			String autor=teclado.nextLine();
			
			System.out.print("Páginas: ");
			int paginas=teclado.nextInt();
			teclado.nextLine();
			
			Libros libro=new Libros(isbn, titulo, autor, paginas);
			DAOArchivo dao=new DAOArchivo();
			if(!dao.create(libro)){
				System.out.println("Fallo en la insercion. ¿El libro introducido ya existe?");
			}
		}

//-----Método para dar de buscar un libro
	private static void buscarLibro(){
		System.out.print("Título: ");
		String titulo=teclado.nextLine();
		
		DAOArchivo dao=new DAOArchivo();
		Libros libro=dao.read(titulo);
		if(libro!=null){
			System.out.println(libro);
		}else{
			System.out.println("El libro introducido no consta en la base de datos.");
		}
	}

//-----Método para eliminar un libro	
	public static void eliminarLibro(){
		System.out.print("ISBN: ");
		int isbn = teclado.nextInt();
		teclado.nextLine();
		
		DAOArchivo dao= new DAOArchivo();
		int resultado=dao.delete(isbn);
		switch(resultado){
		case DAOArchivo.OK:
			System.out.println("El libro indicado se borro correctamente");
			break;
		case DAOArchivo.NO_EXISTE:
			System.out.println("El libro indicado no existe en la base de datos");
			break;
		case DAOArchivo.ERROR:
			System.out.println("Hubo un problema con el enlace a la BBDD");
			break;	
		}
	}

//-----Método para listar los elementos en el ArrayList
	private static void listar(){
		System.out.println("Listado de libros en el archivo: ");
		System.out.println("-----------------------------------\n");
		
		DAOArchivo dao=new DAOArchivo();
		ArrayList<Libros> lon=dao.listar();
		for(Libros libros : lon){
			System.out.println(libros);
		}
	}

//-----Variables generales
	private static Scanner teclado=new Scanner(System.in);
	
//-----------------------------------------INICIO DEL MAIN-----------------------------------------
	public static void main(String[] args) {
		
//-----Inicializamos el método del enlace en el programa importandolo desde su clase
		BBDD.enlace();
		
//-----Variable de estado para controlar el menú
		boolean continuar=true;
		
//-----Bucle de control del menú
		while(continuar){
			imprimirMenu(); //Método para sacar el menú por pantalla
			System.out.println("\n Eliga la opción deseada:");
			String opcion=teclado.nextLine();
			
			opcion=opcion.trim(); // Elimina los espacios, tabuladores y saltos de linea al principio y al final de la cadena
			if(opcion.length()>0){ //Bucle if para el control del menú 
				char opc=opcion.charAt(0); // obtiene el primer caracter de la cadena
				switch(opc){
				case '1':
					altaLibro();
					break;
				case '2':
					eliminarLibro();
					break;
				case '3':
					buscarLibro();
					break;
				case '4':
					listar();
					break;
				case '5':
					System.out.println("Adíos. Gracias por usar nuestra aplicación");
					continuar=false;
					BBDD.cerrarEnlace();//Cerramos el método del enlace, cerrando así el enlace a la BBDD
					break;
				default:
					System.out.println("Introduzca una opción válida por favor.");
				}
			}
		}
		
	}
}

