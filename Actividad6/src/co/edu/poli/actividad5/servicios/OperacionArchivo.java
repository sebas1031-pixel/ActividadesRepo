package co.edu.poli.actividad5.servicios;

/**
 * Operaciones sobre archivo binario del arreglo de obras.
 */
public interface OperacionArchivo {
    /**
     * Serializa el arreglo actual a la ruta dada.
     * @param ruta path del archivo .dat
     * @return mensaje de resultado (OK/ERROR).
     */
    String serializar(String ruta);

    /**
     * Deserializa desde la ruta dada y carga el arreglo en memoria.
     * @param ruta path del archivo .dat
     * @return mensaje de resultado (OK/ERROR).
     */
    String deserializar(String ruta);
}