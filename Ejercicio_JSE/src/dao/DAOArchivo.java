package dao;

//-----Importamos paquetes propios
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//-----Importamos las clases
import datos.BBDD;
import modelos.Libros;


public class DAOArchivo {
	
	public static final int OK=0;
	public static final int ERROR=1;
	public static final int NO_EXISTE=2;
	
	
	
	
//-----Variable donde almacenaremos la conexión y la igualamos al método que llama a dicha conexión
		private Connection conexion=BBDD.getConexion();

	
//-----------------------------------------MÉTODOS-----------------------------------------
//-----Método para crear una entrada en la BBDD
	public boolean create(Libros libro){
		
		//Variable donde almacenamos las instrucciones SQL para la BBDD
		String sql="insert into libros (isbn,titulo,autor,paginas) values (?,?,?,?)";
		
		try{
			PreparedStatement ps=conexion.prepareStatement(sql);
			ps.setInt(1,libro.getIsbn());
			ps.setString(2,libro.getTitulo());
			ps.setString(3,libro.getAutor());
			ps.setInt(4,libro.getPaginas());
			ps.executeUpdate();
			ps.close();
			return true;
			}catch(SQLException sqle){
				System.out.println("Lo sentimos, hubo un problema al insertar los datos en la BBDD");
				return false;
				}
		}

//-----Método para borrar una entrada en la BBDD mediante la PRIMARY KEY
	public int delete(int isbn){
		int resultado=OK;
		
		//Variable donde almacenamos las instrucciones SQL para la BBDD
		String sql="delete from libros where isbn=?";
		
		try(PreparedStatement ps=conexion.prepareStatement(sql)){
			ps.setInt(1,isbn);
			int numeroBorrado=ps.executeUpdate();
			if(numeroBorrado>0){
				resultado=OK;
			}else{
				resultado=NO_EXISTE;
			}
			}catch(SQLException sqle){
				resultado=ERROR;
			}
		return resultado;
		}

//-----Método para buscar una entrada en la BBDD
	public Libros read(String titulo){
		
		//Llamada al constructor de la clase Libros declarando e inicializando el objeto donde almacenaremos los datos de registro para la BBDD
		Libros libro=null;
		
		//Variable donde almacenamos las instrucciones SQL para la BBDD
		String sql="select isbn,titulo, autor,paginas from libros where titulo like ?";
		
		try{
			PreparedStatement ps=conexion.prepareStatement(sql);
			ps.setString(1,"%"+titulo+"%");
			ResultSet result=ps.executeQuery();
			if(result.next()){
				libro=new Libros(result.getInt("isbn"),result.getString("titulo") , result.getString("autor"), result.getInt("paginas"));
				}
			result.close();
			}catch(SQLException sqle){
				System.out.println("Lo sentimos, no se pueden mostrar los datos deseados");
				}
		return libro;
		}

	
//-----Método para listar las entradas de la BBDD	
	public ArrayList<Libros> listar(){
		
		//Declaramos el ArrayList
		ArrayList<Libros> libros=new ArrayList<Libros>();
		
		//Variable donde almacenamos las instrucciones SQL para la BBDD
		String sql="select * from libros order by titulo";
		
		try{
			PreparedStatement ps=conexion.prepareStatement(sql);
			ResultSet result=ps.executeQuery();
			while(result.next()){
				Libros libro=new Libros(result.getInt("isbn"),result.getString("titulo"),result.getString("autor"), result.getInt("paginas"));
				libros.add(libro);
			}
			result.close();
			}catch(SQLException sqle){
				System.out.println("¡Error! no se pueden mostrar los datos almacenados en la BBDD");
				}
	return libros;
	}
	
}
