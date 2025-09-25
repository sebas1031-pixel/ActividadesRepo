package co.edu.poli.actividad3.model;


/**
 * Clase final que representa la certificación de autenticidad de la obra.
 * Al ser final, no puede ser heredada.
 */
public final class Certificacion {

    /** Nombre del organismo certificador. */
    private String entidad;

    /** Año en el que se emitió la certificación. */
    private int anio;

    /**
     * Constructor de Certificacion.
     *
     * @param entidad entidad certificadora
     * @param anio año de emisión
     */
    public Certificacion(String entidad, int anio) {
        this.entidad = entidad;
        this.anio = anio;
    }

    /** @return entidad certificadora */
    public String getEntidad() { return entidad; }

    /** @param entidad nueva entidad certificadora */
    public void setEntidad(String entidad) { this.entidad = entidad; }

    /** @return año de emisión */
    public int getAnio() { return anio; }

    /** @param anio nuevo año */
    public void setAnio(int anio) { this.anio = anio; }
}
