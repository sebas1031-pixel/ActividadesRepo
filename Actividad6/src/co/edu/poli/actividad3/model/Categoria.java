package co.edu.poli.actividad3.model;

/** Categoria de clasificacion de una obra. */
public class Categoria {
    private String nombre;

    /** Crea una categoria.
     *  @param nombre nombre inicial
     */
    public Categoria(String nombre) { this.nombre = nombre; }

    /** Devuelve el nombre de la categoria.
     *  @return nombre de la categoria
     */
    public String getNombre() { return nombre; }

    /** Actualiza el nombre de la categoria.
     *  @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override public String toString() { return nombre; }
}
