package co.edu.poli.actividad3.model;
/** Subclase que representa esculturas. */
public class Escultura extends ObraDeArte {
    private String material;
    private double altura;

    /**
     * Crea una escultura.
     * @param serial id unico
     * @param nombre nombre de la obra
     * @param peso peso en kg
     * @param anioCreacion anio de creacion
     * @param material material principal
     * @param altura altura en cm
     */
    public Escultura(int serial, String nombre, double peso, int anioCreacion,
                     String material, double altura) {
        super(serial, nombre, peso, anioCreacion);
        this.material = material;
        this.altura = altura;
    }

    @Override
    public String listar() {
        return String.format("[Escultura] %s - material=%s, altura=%.1f cm, id=%d",
                getNombre(), material, altura, getSerial());
    }
}