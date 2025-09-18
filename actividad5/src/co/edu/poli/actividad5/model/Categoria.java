package co.edu.poli.actividad5.model;

public class Categoria {
	 private String nombre;
	    private String descripcion;
	    private int id;

	    public Categoria(int id, String nombre, String descripcion) {
	        this.id = id;
	        this.nombre = nombre;
	        this.descripcion = descripcion;
	    }

	    public String getNombre() { return nombre; }

}
