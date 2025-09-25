package co.edu.poli.actividad3.model;

/**
 * Representa la localización física de la obra dentro del museo.
 */
public class Localizacion {

    /** Sala o sección donde está ubicada la obra. */
    private String sala;

    /** Piso o nivel dentro del museo. */
    private int piso;

    /**
     * Constructor de Localizacion.
     *
     * @param sala sala o sección
     * @param piso piso o nivel
     */
    public Localizacion(String sala, int piso) {
        this.sala = sala;
        this.piso = piso;
    }

    /** @return sala de la obra */
    public String getSala() { return sala; }

    /** @param sala nueva sala */
    public void setSala(String sala) { this.sala = sala; }

    /** @return piso donde está ubicada */
    public int getPiso() { return piso; }

    /** @param piso nuevo piso */
    public void setPiso(int piso) { this.piso = piso; }
}
