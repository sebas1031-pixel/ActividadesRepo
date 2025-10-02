package co.edu.poli.actividad3.model;

/** Representa a una persona (autor, artista, etc). */
public class Persona {
    private String nombre;
    private String nacionalidad;

    /**
     * Crea una persona.
     * @param nombre nombre completo
     * @param nacionalidad nacionalidad de la persona
     */
    public Persona(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /** Devuelve el nombre completo de la persona.
     *  @return nombre completo de la persona
     */
    public String getNombre() { return nombre; }

    /** Cambia el nombre de la persona.
     *  @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** Devuelve la nacionalidad de la persona.
     *  @return nacionalidad de la persona
     */
    public String getNacionalidad() { return nacionalidad; }

    /** Cambia la nacionalidad de la persona.
     *  @param nacionalidad nueva nacionalidad
     */
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    @Override public String toString() { return nombre + " - " + nacionalidad; }
}