package co.edu.poli.actividad3.model;

/**
 * Representa un país asociado a una persona u obra de arte.
 * Contiene información básica como nombre, idioma y prefijo telefónico.
 */
public class Pais {

    /** Nombre del país (ej: Colombia). */
    private String nombre;

    /** Idioma principal del país (ej: Español). */
    private String idioma;

    /** Prefijo telefónico internacional del país (ej: +57). */
    private String prefijo;

    /**
     * Constructor de Pais.
     *
     * @param nombre  nombre del país
     * @param idioma  idioma oficial
     * @param prefijo prefijo telefónico internacional
     */
    public Pais(String nombre, String idioma, String prefijo) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.prefijo = prefijo;
    }

    /** @return nombre del país */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre del país */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return idioma principal */
    public String getIdioma() { return idioma; }

    /** @param idioma nuevo idioma */
    public void setIdioma(String idioma) { this.idioma = idioma; }

    /** @return prefijo telefónico */
    public String getPrefijo() { return prefijo; }

    /** @param prefijo nuevo prefijo telefónico */
    public void setPrefijo(String prefijo) { this.prefijo = prefijo; }

    /**
     * Representación en cadena del país (solo muestra el nombre).
     *
     * @return nombre del país
     */
    @Override
    public String toString() { return nombre; }


}
