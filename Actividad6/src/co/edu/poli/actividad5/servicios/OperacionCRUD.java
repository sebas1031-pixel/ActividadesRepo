package co.edu.poli.actividad5.servicios;

import co.edu.poli.actividad3.model.ObraDeArte;

/**
 * Interfaz CRUD sobre una colección subyacente de tipo arreglo.
 * Las operaciones se realizan por el ID (serial) de la obra.
 */
public interface OperacionCRUD {

    /**
     * Inserta en el PRIMER null de izquierda a derecha.
     * Si no hay null, la implementación DEBE redimensionar para permitir
     * la "agregación infinita" y luego insertar.
     *
     * Validaciones mínimas:
     * - o != null
     * - o.getSerial() > 0
     * - no debe existir otra obra con el mismo serial
     *
     * @param o obra a insertar
     * @return mensaje de estado (éxito o descripción del problema)
     */
    String create(ObraDeArte o);

    /**
     * @return arreglo actual (puede contener nulls).
     */
    ObraDeArte[] readAll();

    /**
     * Busca una obra por ID.
     *
     * @param serial ID de la obra
     * @return la obra si existe, o null si no
     */
    ObraDeArte readId(int serial);

    /**
     * Reemplaza la obra cuyo ID sea 'serial' por 'nueva'.
     * La 'nueva' DEBE tener el mismo serial, de lo contrario se rechaza.
     *
     * @param serial ID a modificar
     * @param nueva nueva instancia
     * @return mensaje de estado
     */
    String update(int serial, ObraDeArte nueva);

    /**
     * Elimina una obra por ID: pone null en su posición y retorna el objeto eliminado.
     *
     * @param serial ID a eliminar
     * @return la obra eliminada, o null si no existe
     */
    ObraDeArte delete(int serial);

}
