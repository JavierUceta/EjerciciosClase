package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import db.DB;
import modelos.Viaje;

public class DAOViaje {

	
	public ArrayList<Viaje> buscar(String destino){
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		
		String sql="select * from viajes where destino like ?";
		
		try(Connection con=DB.getConexion(); PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setString(1,"%"+destino+"%");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Viaje viaje=new Viaje(rs.getInt("id"),rs.getString("destino"),rs.getInt("duracion"),rs.getInt("precio"));
				lista.add(viaje);
			}
			rs.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	
	public ArrayList<Viaje> listar(){
		
		ArrayList<Viaje> lista=new ArrayList<Viaje>();
		String sql="select * from viajes order by id";
		
		try(Connection con=DB.getConexion(); PreparedStatement ps=con.prepareStatement(sql);){
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Viaje viaje =new Viaje(rs.getInt("id"),rs.getString("destino"),rs.getInt("duracion"),rs.getInt("precio"));
				lista.add(viaje);
			}
			rs.close();
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}
		return lista;
	}
	
	public Viaje getViaje(int id){
		Viaje viaje=null;
		String sql="select destino from viajes where id=?";
		try(Connection con=DB.getConexion(); PreparedStatement ps=con.prepareStatement(sql);){
			
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()){
				viaje=new Viaje(id,rs.getString("destino"),rs.getInt("duracion"),rs.getDouble("precio"));
			}
		}catch(SQLException sqle){
			sqle.printStackTrace();
		}		
		return viaje;
	}
}
