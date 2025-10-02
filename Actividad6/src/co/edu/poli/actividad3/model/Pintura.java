package co.edu.poli.actividad3.model;

/** Subclase que representa pinturas. */
public class Pintura extends ObraDeArte {
    private String lienzo;
    private String tecnica;

    /**
     * Crea una pintura.
     * @param serial id unico
     * @param nombre nombre de la obra
     * @param peso peso en kg
     * @param anioCreacion anio de creacion
     * @param lienzo tipo de lienzo
     * @param tecnica tecnica utilizada
     */
    public Pintura(int serial, String nombre, double peso, int anioCreacion,
                   String lienzo, String tecnica) {
        super(serial, nombre, peso, anioCreacion);
        this.lienzo = lienzo;
        this.tecnica = tecnica;
    }

    @Override
    public String listar() {
        return String.format("[Pintura] %s - lienzo=%s, tecnica=%s, id=%d",
                getNombre(), lienzo, tecnica, getSerial());
    }
}