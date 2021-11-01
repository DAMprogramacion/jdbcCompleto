package jdbcResulset.modelo;

import java.util.ArrayList;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.ZoneId;

import completo.Ayudante;
import jdbcResulset.conexion.Conexion;
import jdbcResulset.conexion.ConexionDS;

public class EstudianteDAOSQL implements EstudianteDAO {

	private Connection conexion = null;

	public EstudianteDAOSQL() throws FileNotFoundException, SQLException, IOException {
		//conexion = Conexion.getConnection();
		conexion = ConexionDS.getConnection(); //con DataSource

	}

	@Override
	public List<Estudiante> obtenerTodosLosEstudiantes() throws SQLException {
		List<Estudiante> lista = new ArrayList();
		//Estudiante estudiante = new Estudiante(); error definir aquí el objeto Estudiante
		String sentencia = "SELECT * FROM estudiante; ";
		Statement statement = conexion.createStatement();
		ResultSet resulset = statement.executeQuery(sentencia);
		while (resulset.next()) {
			Estudiante estudiante = new Estudiante();
			estudiante.setId(resulset.getInt(1));
			estudiante.setNombreEstudiante(resulset.getString(2));
			estudiante.setApellidosEstudiantes(resulset.getString(3));
			estudiante.setFechaNacimiento(Ayudante.convertToLocalDateViaMilisecond(resulset.getDate(4)));
			lista.add(estudiante);
		}
		return lista;
	}

	@Override
	public boolean borrarEstudiantePorId(int id) throws SQLException {
		String sentencia = "DELETE FROM estudiante WHERE id=?; ";
		PreparedStatement preparedStatement = conexion.prepareStatement(sentencia);
		preparedStatement.setInt(1, id);
		int filas = preparedStatement.executeUpdate();
		return filas != 0;
	}

	@Override
	public List<String> obtenerTodasLasNotas() throws SQLException {
		// TODO Auto-generated method stub
		List<String> datos = new ArrayList<>();
		String sentencia = "SELECT * FROM `ver notas` ;";
		Statement statement = conexion.createStatement();
		ResultSet resulset = statement.executeQuery(sentencia);
		while (resulset.next()) {
			StringBuilder builder = new StringBuilder();
			builder.append(resulset.getString(1));
			builder.append(',');
			builder.append(resulset.getString(2));
			builder.append(',');
			builder.append(resulset.getString(3));
			builder.append(',');
			builder.append(resulset.getInt(4));
			datos.add(builder.toString());
			
		}
		return datos;
	}

	

}
