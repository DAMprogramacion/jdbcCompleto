package jdbcResulset.modelo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

public class TestModelo {

	public static void main(String[] args) throws FileNotFoundException, SQLException, IOException {
		// TODO Auto-generated method stub
		new EstudianteDAOSQL().obtenerTodosLosEstudiantes().forEach(System.out::println);
		System.out.println("Borrando estudiante: " + new EstudianteDAOSQL().borrarEstudiantePorId(3));
		new EstudianteDAOSQL().obtenerTodasLasNotas().forEach(System.out::println);
		System.out.println("Ejecuntando procedure: " + new EstudianteDAOSQL().subirNota(10));
	}

}
