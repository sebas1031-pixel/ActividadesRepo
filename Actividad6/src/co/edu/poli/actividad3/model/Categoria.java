package co.edu.poli.actividad3.model;

/**
 * Representa una categoría de obra de arte (pintura, escultura, etc.).
 */
public class Categoria {

    /** Nombre de la categoría. */
    private String nombre;

    /**
     * Constructor de Categoria.
     *
     * @param nombre nombre de la categoría
     */
    public Categoria(String nombre) {
        this.nombre = nombre;
    }

    /** @return nombre de la categoría */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre */
    public void setNombre(String nombre) { this.nombre = nombre; }

}
