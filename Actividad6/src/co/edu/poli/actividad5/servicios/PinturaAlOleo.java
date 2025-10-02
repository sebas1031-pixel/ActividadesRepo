package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad3.model.Pintura;

/** Especializacion de Pintura para obras al oleo. */
public class PinturaAlOleo extends Pintura {
    private boolean barnizada;
    private int tiempoSecado;

    /**
     * Crea una pintura al oleo.
     * @param serial id unico
     * @param nombre nombre de la obra
     * @param peso peso en kg
     * @param anioCreacion anio de creacion
     * @param lienzo tipo de lienzo
     * @param tecnica tecnica usada
     * @param barnizada indica si tiene barniz
     * @param tiempoSecado dias de secado
     */
    public PinturaAlOleo(int serial, String nombre, double peso, int anioCreacion,
                         String lienzo, String tecnica, boolean barnizada, int tiempoSecado) {
        super(serial, nombre, peso, anioCreacion, lienzo, tecnica);
        this.barnizada = barnizada;
        this.tiempoSecado = tiempoSecado;
    }

    @Override
    public String listar() {
        return super.listar() + String.format(" [oleo: barnizada=%s, secado=%d dias]",
                barnizada ? "si" : "no", tiempoSecado);
    }
}