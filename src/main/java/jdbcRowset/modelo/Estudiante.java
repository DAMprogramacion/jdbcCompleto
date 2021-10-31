package jdbcRowset.modelo;

import java.time.LocalDate;

public class Estudiante {
	private int id;
	private String nombreEstudiante;
	private String apellidosEstudiantes;
	private LocalDate fechaNacimiento;
	public Estudiante() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreEstudiante() {
		return nombreEstudiante;
	}
	public void setNombreEstudiante(String nombreEstudiante) {
		this.nombreEstudiante = nombreEstudiante;
	}
	public String getApellidosEstudiantes() {
		return apellidosEstudiantes;
	}
	public void setApellidosEstudiantes(String apellidosEstudiantes) {
		this.apellidosEstudiantes = apellidosEstudiantes;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	@Override
	public String toString() {
		return String.format("Estudiante [id=%s, nombreEstudiante=%s, apellidosEstudiantes=%s, fechaNacimiento=%s]", id,
				nombreEstudiante, apellidosEstudiantes, fechaNacimiento);
	}
	
	
	
}
