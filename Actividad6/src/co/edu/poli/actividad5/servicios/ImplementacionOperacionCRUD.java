package co.edu.poli.actividad5.servicios;

import java.util.Arrays;
import co.edu.poli.actividad3.model.ObraDeArte;

/**
 * Implementacion del CRUD usando un arreglo que puede crecer.
 * Reglas:
 * - create: inserta en el primer null; si no hay, el arreglo crece en 1.
 * - readId/update/delete: operan por el serial.
 */
public class ImplementacionOperacionCRUD implements OperacionCRUD {

    /** Arreglo subyacente (puede contener posiciones null). */
    private ObraDeArte[] data;

    /** Constructor: tamano inicial 3. */
    public ImplementacionOperacionCRUD() {
        this.data = new ObraDeArte[3];
    }

    /** {@inheritDoc} */
    @Override
    public String create(ObraDeArte o) {
        if (o == null) return "ERROR: obra nula";
        if (o.getSerial() <= 0) return "ERROR: serial invalido";
        // Validar duplicado
        for (ObraDeArte x : data) {
            if (x != null && x.getSerial() == o.getSerial()) {
                return "ERROR: ya existe obra con serial " + o.getSerial();
            }
        }
        // Primer null
        for (int i = 0; i < data.length; i++) {
            if (data[i] == null) {
                data[i] = o;
                return "OK: agregada en posicion " + i;
            }
        }
        // Crecer + insertar al final
        data = Arrays.copyOf(data, data.length + 1);
        data[data.length - 1] = o;
        return "OK: agregada en posicion " + (data.length - 1) + " (se amplio arreglo)";
    }

    /** {@inheritDoc} */
    @Override
    public ObraDeArte[] readAll() { return data; }

    /** {@inheritDoc} */
    @Override
    public ObraDeArte readId(int serial) {
        if (serial <= 0) return null;
        for (ObraDeArte x : data) {
            if (x != null && x.getSerial() == serial) return x;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public String update(int serial, ObraDeArte nueva) {
        if (serial <= 0) return "ERROR: serial invalido";
        if (nueva == null) return "ERROR: obra nueva nula";
        if (nueva.getSerial() != serial) {
            return "ERROR: serial de nueva no coincide";
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].getSerial() == serial) {
                data[i] = nueva;
                return "OK: actualizada en posicion " + i;
            }
        }
        return "ERROR: no existe obra con serial " + serial;
    }

    /** {@inheritDoc} */
    @Override
    public ObraDeArte delete(int serial) {
        if (serial <= 0) return null;
        for (int i = 0; i < data.length; i++) {
            ObraDeArte x = data[i];
            if (x != null && x.getSerial() == serial) {
                data[i] = null;
                return x;
            }
        }
        return null;
    }
}