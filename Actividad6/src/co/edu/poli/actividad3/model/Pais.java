package co.edu.poli.actividad3.model;

/** Representa un pais de origen de una persona o una obra. */
public class Pais {
    private String nombre;
    private String idioma;
    private String prefijo;

    /**
     * Crea un pais con nombre, idioma y prefijo telefonico.
     * @param nombre nombre del pais
     * @param idioma idioma principal
     * @param prefijo prefijo telefonico
     */
    public Pais(String nombre, String idioma, String prefijo) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.prefijo = prefijo;
    }

    /** Devuelve el nombre del pais.
     *  @return nombre del pais
     */
    public String getNombre() { return nombre; }

    /** Actualiza el nombre del pais.
     *  @param nombre nuevo nombre del pais
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** Devuelve el idioma principal.
     *  @return idioma principal
     */
    public String getIdioma() { return idioma; }

    /** Actualiza el idioma.
     *  @param idioma nuevo idioma
     */
    public void setIdioma(String idioma) { this.idioma = idioma; }

    /** Devuelve el prefijo telefonico.
     *  @return prefijo telefonico
     */
    public String getPrefijo() { return prefijo; }

    /** Actualiza el prefijo telefonico.
     *  @param prefijo nuevo prefijo telefonico
     */
    public void setPrefijo(String prefijo) { this.prefijo = prefijo; }

    @Override public String toString() { return nombre; }
}