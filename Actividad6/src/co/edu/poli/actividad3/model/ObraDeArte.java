package co.edu.poli.actividad3.model;

/**
 * Superclase abstracta de todas las obras de arte.
 */
public abstract class ObraDeArte {

    private final int serial;
    private String nombre;
    private double peso;
    private int anioCreacion;

    /**
     * Constructor simplificado.
     *
     * @param serial ID único (>0)
     * @param nombre título de la obra
     * @param peso   peso en kg (>=0)
     * @param anioCreacion año de creación
     */
    public ObraDeArte(int serial, String nombre, double peso, int anioCreacion) {
        if (serial <= 0) throw new IllegalArgumentException("serial inválido");
        if (peso < 0) throw new IllegalArgumentException("peso negativo");
        this.serial = serial;
        this.nombre = nombre;
        this.peso = peso;
        this.anioCreacion = anioCreacion;
    }

    /** Método abstracto que cada subclase implementa. */
    public abstract String listar();

    // Getters básicos
    public int getSerial() { return serial; }
    public String getNombre() { return nombre; }
    public double getPeso() { return peso; }
    public int getAnioCreacion() { return anioCreacion; }

    // Setters
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setPeso(double peso) {
        if (peso < 0) throw new IllegalArgumentException("peso negativo");
        this.peso = peso;
    }
    public void setAnioCreacion(int anioCreacion) { this.anioCreacion = anioCreacion; }

    /** Método final que no se puede sobrescribir. */
    public final String etiquetaMuseo() {
        return "Obra serial=" + serial + " (" + nombre + ")";
    }

    @Override
    public String toString() { return listar(); }
}
