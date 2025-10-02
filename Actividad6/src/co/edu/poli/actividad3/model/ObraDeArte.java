package co.edu.poli.actividad3.model;

/**
 * Super superclase para obras del museo.
 * Contiene los campos comunes y contratos de comportamiento.
 */
public abstract class ObraDeArte {

    private final int serial;
    private String nombre;
    private double peso;
    private int anioCreacion;

    /**
     * Crea una obra de arte base.
     * @param serial identificador unico
     * @param nombre nombre de la obra
     * @param peso peso en kilogramos
     * @param anioCreacion anio de creacion
     */
    public ObraDeArte(int serial, String nombre, double peso, int anioCreacion) {
        this.serial = serial;
        this.nombre = nombre;
        this.peso = peso;
        this.anioCreacion = anioCreacion;
    }

    /** Devuelve el serial unico de la obra.
     *  @return identificador unico (serial) de la obra
     */
    public int getSerial() { return serial; }

    /** Devuelve el nombre de la obra.
     *  @return nombre de la obra
     */
    public String getNombre() { return nombre; }

    /** Cambia el nombre de la obra.
     *  @param nombre nuevo nombre
     */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** Devuelve el peso en kilogramos.
     *  @return peso en kilogramos
     */
    public double getPeso() { return peso; }

    /** Cambia el peso de la obra.
     *  @param peso nuevo peso en kg
     */
    public void setPeso(double peso) { this.peso = peso; }

    /** Devuelve el anio de creacion.
     *  @return anio de creacion
     */
    public int getAnioCreacion() { return anioCreacion; }

    /** Cambia el anio de creacion.
     *  @param anioCreacion nuevo anio
     */
    public void setAnioCreacion(int anioCreacion) { this.anioCreacion = anioCreacion; }

    /** Lista la informacion relevante de la obra.
     *  @return cadena con la informacion resumida
     */
    public abstract String listar();

    /** Genera una etiqueta simple para vitrina.
     *  @return texto con nombre y anio
     */
    public final String etiquetaMuseo() {
        return nombre + " (" + anioCreacion + ")";
    }

    @Override public String toString() { return listar(); }
}