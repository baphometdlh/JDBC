package ejercicios;

import java.io.*;
import java.sql.*;

public class OfficialLanguagesReport {

	public static void main(String[] args){
		
        String url = "jdbc:mysql://localhost:3306/word";
        String user = "birt";
        String password = "birt";
		

    	String consulta="select country.Name, countrylanguage.language, countrylanguage.Percentage  "
    			+ "from country join countrylanguage on country.code=countrylanguage.CountryCode where country.Continent=?;";
    	
    	try {
    		
    		System.out.println("Intorduce el nombre del continente para ver sus idiomas oficiales:");
        	String continente = Consola.readString();
        	Connection miConexion = DriverManager.getConnection(url, user, password);  
        	PreparedStatement stmt = miConexion.prepareStatement(consulta);
        	stmt.setString(1, continente);
        	
        	try(ResultSet resultado = stmt.executeQuery()){
            	while(resultado.next()) {
            		String pais = resultado.getString("country.Name");
            		String idioma = resultado.getString("countrylanguage.language");
            		double porcent = resultado.getDouble("countrylanguage.Percentage");
            		System.out.println(pais + idioma + porcent);
            	}
        	}        	

        	
        	miConexion.close();
        	
    	}catch(Exception e) {
    		
    		
    	}finally {
    		
    	}
    	


    	
	}
	
}
