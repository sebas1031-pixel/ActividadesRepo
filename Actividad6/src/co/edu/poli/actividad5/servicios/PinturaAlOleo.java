package co.edu.poli.actividad5.servicios;
import co.edu.poli.actividad3.model.Pintura;

/**
 * Subclase concreta de Pintura para la técnica al óleo.
 */
public class PinturaAlOleo extends Pintura {

    private boolean barnizada;
    private int tiempoSecadoDias;

    public PinturaAlOleo(int serial, String nombre, double peso, int anioCreacion,
                         String lienzo, String tecnica,
                         boolean barnizada, int tiempoSecadoDias) {
        super(serial, nombre, peso, anioCreacion, lienzo, tecnica);
        if (tiempoSecadoDias < 0) throw new IllegalArgumentException("tiempo secado negativo");
        this.barnizada = barnizada;
        this.tiempoSecadoDias = tiempoSecadoDias;
    }

    @Override
    public String listar() {
        return String.format("[Óleo] %s — barnizada=%s, secado=%d días, id=%d",
                getNombre(), barnizada ? "sí" : "no", tiempoSecadoDias, getSerial());
    }
}
