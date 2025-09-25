package co.edu.poli.actividad3.model;
/**
 * Subclase concreta que representa una escultura.
 */
public class Escultura extends ObraDeArte {

    private String material;
    private double altura;

    public Escultura(int serial, String nombre, double peso, int anioCreacion,
                     String material, double altura) {
        super(serial, nombre, peso, anioCreacion);
        if (altura < 0) throw new IllegalArgumentException("altura negativa");
        this.material = material;
        this.altura = altura;
    }

    @Override
    public String listar() {
        return String.format("[Escultura] %s — material=%s, altura=%.1f cm, id=%d",
                getNombre(), material, altura, getSerial());
    }
}
