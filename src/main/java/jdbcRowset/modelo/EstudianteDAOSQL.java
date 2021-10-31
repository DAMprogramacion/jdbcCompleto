package jdbcRowset.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.JdbcRowSet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import completo.Ayudante;
import jdbcRowset.conexion.Conexion;


public class EstudianteDAOSQL implements EstudianteDAO {

	private  JdbcRowSet jdbcRs = null;

	public EstudianteDAOSQL() throws FileNotFoundException, SQLException, IOException {
		JdbcRowSet jdbcRs = Conexion.getConnection();
	}

	@Override
	public List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException {
		List<Estudiante> lista = new ArrayList();
		Estudiante estudiante = new Estudiante();
		String sentencia = "SELECT * FROM estudiante; ";
		jdbcRs.setCommand(sentencia);
		jdbcRs.execute();
		while (jdbcRs.next()) {
			estudiante.setId(jdbcRs.getInt(1));
			estudiante.setNombreEstudiante(jdbcRs.getString(2));
			estudiante.setApellidosEstudiantes(jdbcRs.getString(3));
			estudiante.setFechaNacimiento(Ayudante.convertToLocalDateViaMilisecond(jdbcRs.getDate(4)));
			lista.add(estudiante);
		}
		return lista;
	}

	@Override
	public boolean borrarEstudiantePorId(int id) throws SQLException {
		boolean borrado = false;
		String sentencia = "SELECT * FROM estudiante; ";
		jdbcRs.setCommand(sentencia);
		jdbcRs.execute();
		while (jdbcRs.next()) {
			if (jdbcRs.getInt(1) == id) {
				borrado = true;
				jdbcRs.deleteRow();
				break;
			}
		}
		return borrado;
	}

	@Override
	public List<String> obtenerTodasLasNotas() throws SQLException {
		// TODO Auto-generated method stub
		List<String> datos = new ArrayList<>();
		String sentencia = "SELECT * FROM `ver notas` ;";
		jdbcRs.setCommand(sentencia);
		jdbcRs.execute();
		while (jdbcRs.next()) {
			StringBuilder builder = new StringBuilder();
			builder.append(jdbcRs.getString(1));
			builder.append(',');
			builder.append(jdbcRs.getString(2));
			builder.append(',');
			builder.append(jdbcRs.getString(3));
			builder.append(',');
			builder.append(jdbcRs.getInt(4));
			datos.add(builder.toString());
			
		}
		return datos;
	}

	

}
