package co.edu.poli.actividad5.servicios;

import co.edu.poli.actividad3.model.ObraDeArte;

/** Contrato CRUD sobre un arreglo de obras. */
public interface OperacionCRUD {

    /** Inserta una obra en el primer null; si no hay espacio, el arreglo crece.
     *  @param o obra a insertar
     *  @return mensaje de exito o error
     */
    String create(ObraDeArte o);

    /** Devuelve el arreglo actual de obras (puede contener nulls).
     *  @return arreglo de obras
     */
    ObraDeArte[] readAll();

    /** Busca una obra por su serial.
     *  @param serial identificador
     *  @return obra encontrada o null
     */
    ObraDeArte readId(int serial);

    /** Reemplaza el objeto con ese serial por uno nuevo.
     *  @param serial id a modificar
     *  @param nueva estado nuevo
     *  @return mensaje de exito o error
     */
    String update(int serial, ObraDeArte nueva);

    /** Elimina por serial.
     *  @param serial id a eliminar
     *  @return obra eliminada o null
     */
    ObraDeArte delete(int serial);
}