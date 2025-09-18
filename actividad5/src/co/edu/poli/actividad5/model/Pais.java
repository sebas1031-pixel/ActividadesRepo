package co.edu.poli.actividad5.model;

public class Pais {
	 private String nombre;
	    private String idioma;
	    private String prefijo;

	    public Pais(String nombre, String idioma, String prefijo) {
	        this.nombre = nombre;
	        this.idioma = idioma;
	        this.prefijo = prefijo;
	    }

	    @Override public String toString() { return nombre; }

}
