package jdbcResulset.conexion;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionDS {
	private static BasicDataSource ds = null;

	public synchronized static Connection getConnection() throws SQLException, IOException {

		Connection conn = null;
		if (ds == null) {
			Properties props = new Properties();
			InputStream is = ConexionDS.class.getClassLoader().getResourceAsStream("db.properties");
			
				props.load(is);
				ds = new BasicDataSource();
				ds.setDriverClassName(props.getProperty("MYSQL_DB_DRIVER_CLASS"));
				ds.setUrl(props.getProperty("MYSQL_DB_URL"));
				ds.setUsername(props.getProperty("MYSQL_DB_USERNAME"));
				ds.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
				ds.setInitialSize(10); // The initial number of connections that
				// are created when the pool is started.
				ds.setMaxTotal(20); // The maximum number of active connections
				// that can be allocated from this pool
			
		}
		conn = ds.getConnection();
		return conn;
	}
}
