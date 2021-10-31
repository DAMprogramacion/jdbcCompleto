package jdbcResulset.conexion;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			System.out.println(Conexion.getConnection());
			System.out.println(Conexion.getConnection());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
