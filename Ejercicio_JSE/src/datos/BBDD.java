package datos;

//-----Importamos paquetes propios
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BBDD {
	
//-----Variable donde almacenaremos la conexión
	private static Connection conexion;
	
//-----Método donde cargamos Driver y realizamos la conexion con la BBDD
	public static void enlace(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306/archivo","root","");
			//-----Instalamos el archivo "*.jar"
		}catch(ClassNotFoundException cnfe){
			System.out.println("Lo sentimos, no se pudo conectar con la base de datos, por favor revisé su conexión.");
		}catch(SQLException sqle){
			System.out.println("Base de datos inexistente o no se puede conectar. Por favor contacte con el administrador de la base de datos.");
		}
	}
	
//-----Método para cerrar el enlace a la BBDD
	public static void cerrarEnlace(){
		try{conexion.close();
		}catch(SQLException sqle){ 
			System.out.println("Lo sentimos, se perdío la conexión, no se pudo cerrar el enlace con la BBDD.");
			}
	}
	
//-----Método de almacenamiento de conexion para insertarlo en las otras clases
	public static Connection getConexion(){
		return conexion;
	}
}
