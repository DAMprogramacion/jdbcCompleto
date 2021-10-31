package jdbcResulset.conexion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	private static Connection conexion = null;
	public synchronized static Connection getConnection() throws SQLException, FileNotFoundException, IOException {
		try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
			Properties props = new Properties();
			props.load(input);
			conexion = DriverManager.getConnection(props.getProperty("MYSQL_DB_URL"),
					props.getProperty("MYSQL_DB_USERNAME"), props.getProperty("MYSQL_DB_PASSWORD"));
		}
		return conexion;
	}
}
