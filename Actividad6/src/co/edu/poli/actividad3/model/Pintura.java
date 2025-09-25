package co.edu.poli.actividad3.model;

/**
 * Subclase concreta que representa una pintura.
 */
public class Pintura extends ObraDeArte {

    private String lienzo;
    private String tecnica;

    public Pintura(int serial, String nombre, double peso, int anioCreacion,
                   String lienzo, String tecnica) {
        super(serial, nombre, peso, anioCreacion);
        this.lienzo = lienzo;
        this.tecnica = tecnica;
    }

    @Override
    public String listar() {
        return String.format("[Pintura] %s — lienzo=%s, técnica=%s, id=%d",
                getNombre(), lienzo, tecnica, getSerial());
    }
}
