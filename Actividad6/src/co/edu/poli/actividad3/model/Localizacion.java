package co.edu.poli.actividad3.model;

/**
 * Representa la localizacion fisica de la obra dentro del museo.
 */
public class Localizacion {
    private String sala;
    private int piso;

    /**
     * Crea una localizacion con sala y piso.
     * @param sala sala o seccion
     * @param piso piso del museo
     */
    public Localizacion(String sala, int piso) {
        this.sala = sala;
        this.piso = piso;
    }

    /** Devuelve la sala o seccion de la obra.
     *  @return sala de la obra
     */
    public String getSala() { return sala; }

    /** Cambia la sala de la obra.
     *  @param sala nueva sala
     */
    public void setSala(String sala) { this.sala = sala; }

    /** Devuelve el piso donde esta ubicada la obra.
     *  @return piso donde esta ubicada
     */
    public int getPiso() { return piso; }

    /** Cambia el piso de la obra.
     *  @param piso nuevo piso
     */
    public void setPiso(int piso) { this.piso = piso; }

    @Override public String toString() {
        return "Sala: " + sala + ", piso: " + piso;
    }
}