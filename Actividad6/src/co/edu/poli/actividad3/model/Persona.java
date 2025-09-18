package co.edu.poli.actividad3.model;

public class Persona {
	private double altura;      // m
    private int cedula;
    private String nacionalidad;
    private String nombre;
    private double peso;        // kg
    private int edad;

    public Persona(String nombre, int cedula, String nacionalidad, double altura, double peso, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.nacionalidad = nacionalidad;
        this.altura = Math.max(0, altura);
        this.peso = Math.max(0, peso);
        this.edad = Math.max(0, edad);
    }

    public String getNombre() { return nombre; }

}
