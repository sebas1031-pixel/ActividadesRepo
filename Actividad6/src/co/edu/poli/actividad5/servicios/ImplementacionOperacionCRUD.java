package co.edu.poli.actividad5.servicios;

import java.util.Arrays;
import java.io.*;
import co.edu.poli.actividad3.model.ObraDeArte;

/**
 * Implementacion de las operaciones CRUD y de archivo binario
 * sobre un arreglo de objetos de tipo ObraDeArte.
 *
 * <p>Reglas:</p>
 * <ul>
 *   <li>create: inserta en el primer null (izquierda a derecha). Si no hay null,
 *       el arreglo se amplia automaticamente en 1 posicion.</li>
 *   <li>readId/update/delete: operan por identificador (serial) de la obra.</li>
 *   <li>serializar/deserializar: guarda y carga el arreglo completo a/desde un archivo .dat.</li>
 * </ul>
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD, OperacionArchivo, Serializable {

    private static final long serialVersionUID = 1L;

    /** Arreglo subyacente que almacena las obras. Puede contener nulls. */
    private ObraDeArte[] data;

    /**
     * Crea la implementacion con tamanio inicial 3.
     * Esta es la dimension solicitada por el profesor.
     */
    public ImplementacionOperacionCRUD() {
        this.data = new ObraDeArte[3];
    }

    /** @return el arreglo interno (puede contener nulls). */
    public ObraDeArte[] getData() {
        return data;
    }

    /**
     * Reemplaza el arreglo interno por otro.
     * @param d nuevo arreglo; si es null, se asigna un arreglo de tamanio 3
     */
    public void setData(ObraDeArte[] d) {
        this.data = (d != null ? d : new ObraDeArte[3]);
    }

    // ===================== CRUD =====================

    /**
     * Inserta una obra en el primer espacio null del arreglo.
     * Si no hay espacios null, el arreglo se amplia en 1 posicion y se inserta al final.
     *
     * @param o obra a insertar
     * @return mensaje indicando el resultado de la operacion
     */
    @Override
    public String create(ObraDeArte o) {
        if (o == null) return "ERROR: obra nula";

        // Unicidad simple por serial
        for (ObraDeArte x : data) {
            if (x != null && x.getSerial() == o.getSerial()) {
                return "ERROR: ya existe obra con serial " + o.getSerial();
            }
        }

        // Buscar primer null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = o;
                return "OK: agregada en posicion " + i;
            }
        }

        // No hay null -> ampliar en 1
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = o;
        return "OK: agregada en posicion " + (data.length - 1) + " (arreglo ampliado)";
    }

    /**
     * Retorna el arreglo actual. Puede contener posiciones null.
     * @return arreglo de obras
     */
    @Override
    public ObraDeArte[] readAll() {
        return data;
    }

    /**
     * Busca una obra por su identificador (serial).
     * @param serial identificador a buscar
     * @return obra encontrada o null si no existe
     */
    @Override
    public ObraDeArte readId(int serial) {
        for (ObraDeArte x : data) {
            if (x != null && x.getSerial() == serial) return x;
        }
        return null;
    }

    /**
     * Reemplaza la obra cuyo serial coincide con el indicado.
     * El objeto nuevo debe tener el mismo serial.
     *
     * @param serial identificador de la obra a actualizar
     * @param o nueva instancia a guardar
     * @return mensaje de resultado de la operacion
     */
    @Override
    public String update(int serial, ObraDeArte o) {
        if (o == null) return "ERROR: obra nula";
        if (o.getSerial() != serial) return "ERROR: el serial de la obra nueva no coincide";

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].getSerial() == serial) {
                data[i] = o;
                return "OK: actualizada en posicion " + i;
            }
        }
        return "ERROR: no existe obra con serial " + serial;
    }

    /**
     * Elimina (pone en null) la obra cuyo serial se indica.
     * @param serial identificador a eliminar
     * @return la obra eliminada o null si no existe
     */
    @Override
    public ObraDeArte delete(int serial) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].getSerial() == serial) {
                ObraDeArte old = data[i];
                data[i] = null;
                return old;
            }
        }
        return null;
    }

    // ===================== Archivo =====================

    /**
     * Serializa el arreglo de objetos ObraDeArte y lo guarda en un archivo binario.
     *
     * @param ruta ruta del archivo donde se guardara el arreglo (por ejemplo "obras.dat")
     * @return mensaje indicando si la operacion fue exitosa o fallo
     */
    @Override
    public String serializar(String ruta) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(data);
            oos.flush();
            return "OK: archivo guardado en " + ruta;
        } catch (IOException e) {
            return "ERROR al guardar: " + e.getMessage();
        }
    }

    /**
     * Deserializa un archivo binario y carga el arreglo de objetos ObraDeArte.
     *
     * @param ruta ruta del archivo desde el cual se cargara el arreglo
     * @return mensaje indicando si la operacion fue exitosa o fallo
     */
    @Override
    public String deserializar(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            Object obj = ois.readObject();
            this.data = (ObraDeArte[]) obj;
            return "OK: archivo cargado desde " + ruta;
        } catch (FileNotFoundException e) {
            return "ERROR: no existe el archivo " + ruta;
        } catch (IOException | ClassNotFoundException e) {
            return "ERROR al leer: " + e.getMessage();
        }
    }
}