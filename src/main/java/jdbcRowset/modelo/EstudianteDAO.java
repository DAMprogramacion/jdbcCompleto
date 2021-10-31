package jdbcRowset.modelo;

import java.sql.SQLException;
import java.util.List;

public interface EstudianteDAO {

		
	List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException;
	boolean borrarEstudiantePorId(int id) throws SQLException;
	List<String> obtenerTodasLasNotas() throws SQLException;
	
}
