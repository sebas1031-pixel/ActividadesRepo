package co.edu.poli.actividad3.model;


/** Clase final que representa la certificacion de autenticidad de la obra. */
public final class Certificacion {
    private String entidad;
    private int anio;

    /**
     * Crea una certificacion.
     * @param entidad entidad certificadora
     * @param anio anio de emision
     */
    public Certificacion(String entidad, int anio) {
        this.entidad = entidad;
        this.anio = anio;
    }

    /** Devuelve la entidad certificadora.
     *  @return entidad certificadora
     */
    public String getEntidad() { return entidad; }

    /** Actualiza la entidad certificadora.
     *  @param entidad nueva entidad certificadora
     */
    public void setEntidad(String entidad) { this.entidad = entidad; }

    /** Devuelve el anio de emision.
     *  @return anio de emision
     */
    public int getAnio() { return anio; }

    /** Actualiza el anio de emision.
     *  @param anio nuevo anio
     */
    public void setAnio(int anio) { this.anio = anio; }

    @Override public String toString() { return entidad + " (" + anio + ")"; }
}