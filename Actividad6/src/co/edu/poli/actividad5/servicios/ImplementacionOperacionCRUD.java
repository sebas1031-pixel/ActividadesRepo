package co.edu.poli.actividad5.servicios;

import java.util.Arrays;
import co.edu.poli.actividad3.model.ObraDeArte;

/**
 * Implementación del CRUD usando un ARREGLO subyacente que
 * se redimensiona automáticamente cuando no hay posiciones null.
 *
 * Reglas:
 * - create: inserta en el primer null (izq → der). Si no hay, crecer y reintentar.
 * - readId/update/delete: por ID (serial).
 * - Validaciones robustas en todas las operaciones.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

    /** Arreglo subyacente (puede contener nulls). */
    private ObraDeArte[] data;

    /**
     * Construye el arreglo con un tamaño inicial.
     * @param tam tamaño inicial (mínimo 1)
     */
    public ImplementacionOperacionCRUD(int tam) {
        if (tam < 1) throw new IllegalArgumentException("tamaño inicial < 1");
        this.data = new ObraDeArte[tam];
    }

    @Override
    public synchronized String create(ObraDeArte o) {
        if (o == null) return "ERROR: Obra null";
        if (o.getSerial() <= 0) return "ERROR: serial inválido";
        if (existsId(o.getSerial())) return "ERROR: ya existe obra con serial " + o.getSerial();

        // buscar primer null
        int pos = firstNullIndex();
        if (pos == -1) {
            // no hay null → crecer
            grow();
            pos = firstNullIndex(); // debe existir tras el grow
            if (pos == -1) return "ERROR: no se pudo crecer la colección";
        }
        data[pos] = o;
        return "OK: agregada en posición " + pos;
    }

    @Override
    public synchronized ObraDeArte[] readAll() {
        return data; // se permite ver nulls y tamaño actual
    }

    @Override
    public synchronized ObraDeArte readId(int serial) {
        if (serial <= 0) return null;
        for (ObraDeArte obra : data) {
            if (obra != null && obra.getSerial() == serial) return obra;
        }
        return null;
    }

    @Override
    public synchronized String update(int serial, ObraDeArte nueva) {
        if (serial <= 0) return "ERROR: serial inválido";
        if (nueva == null) return "ERROR: obra nueva null";
        if (nueva.getSerial() != serial) {
            return "ERROR: el serial de la nueva obra (" + nueva.getSerial() + ") no coincide con " + serial;
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].getSerial() == serial) {
                data[i] = nueva;
                return "OK: actualizada en posición " + i;
            }
        }
        return "ERROR: no existe obra con serial " + serial;
    }

    @Override
    public synchronized ObraDeArte delete(int serial) {
        if (serial <= 0) return null;
        for (int i = 0; i < data.length; i++) {
            ObraDeArte o = data[i];
            if (o != null && o.getSerial() == serial) {
                data[i] = null;
                return o;
            }
        }
        return null;
    }

    // ------------- utilidades internas -------------

    /** @return true si existe una obra con ese ID. */
    private boolean existsId(int serial) {
        return readId(serial) != null;
    }

    /** @return índice del primer null, o -1 si no hay. */
    private int firstNullIndex() {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) return i;
        }
        return -1;
    }

    /** Crece el arreglo (x2) conservando el orden (nulls incluidos). */
    private void grow() {
        int newSize = Math.max(1, data.length * 2);
        data = Arrays.copyOf(data, newSize);
    }

}
