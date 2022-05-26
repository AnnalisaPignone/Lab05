package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.anagrammi.model.Parola;


public class DizionarioDAO {
	
	public List<Parola> getTutteLeParole(){
		
		final String sql = "SELECT nome FROM parola"; 
		List <Parola> parole= new ArrayList<Parola>(); 
		
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				String parola=rs.getString("nome");
				
				parole.add(new Parola(parola)); 
			}
			
			conn.close();
			
			return parole;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
		
		
	}

}

