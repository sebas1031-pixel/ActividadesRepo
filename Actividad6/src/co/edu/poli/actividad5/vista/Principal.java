package co.edu.poli.actividad5.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad5.servicios.*;


/**
 * Clase de prueba que invoca todas las operaciones CRUD sobre el arreglo de obras.
 */
public class Principal {

    public static void main(String[] args) {

        // ====== Crear CRUD con capacidad inicial 3 ======
        OperacionCRUD crud = new ImplementacionOperacionCRUD(3);

        // ====== Crear algunos objetos ======
        ObraDeArte e1 = new Escultura(5001, "El Pensador", 450.0, 1904, "bronce", 180.0);
        ObraDeArte p1 = new Pintura(6001, "Girasoles", 5.5, 1888, "lino", "óleo");
        ObraDeArte o1 = new PinturaAlOleo(7001, "Guernica", 7.0, 1937, "lino", "óleo", false, 21);
        ObraDeArte p2 = new Pintura(6002, "Las Meninas", 6.2, 1656, "lino", "óleo");

        // ====== CREATE ======
        System.out.println("=== CREATE ===");
        System.out.println(crud.create(e1)); // posición 0
        System.out.println(crud.create(p1)); // posición 1
        System.out.println(crud.create(o1)); // posición 2
        System.out.println(crud.create(p2)); // debería crecer arreglo -> posición 3

        // Duplicado
        System.out.println(crud.create(new Pintura(6001, "Copia Girasoles", 5.0, 1888, "algodón", "óleo")));

        // ====== READ ALL ======
        System.out.println("\n=== READ ALL ===");
        imprimirTabla(crud);

        // ====== READ ID ======
        System.out.println("\n=== READ ID ===");
        System.out.println("Buscar 7001 -> " +
                (crud.readId(7001) != null ? crud.readId(7001).listar() : "No existe"));
        System.out.println("Buscar 9999 -> " +
                (crud.readId(9999) != null ? crud.readId(9999).listar() : "No existe"));

        // ====== UPDATE ======
        System.out.println("\n=== UPDATE ===");
        // OK
        ObraDeArte o1Nuevo = new PinturaAlOleo(7001, "Guernica (restaurada)", 7.1, 1937, "lino", "óleo", true, 18);
        System.out.println(crud.update(7001, o1Nuevo));

        // Serial distinto
        ObraDeArte otra = new Pintura(8888, "Obra con serial distinto", 3.0, 2000, "algodón", "acrílico");
        System.out.println(crud.update(7001, otra));

        // Serial inexistente
        System.out.println(crud.update(1234, new Pintura(1234, "Nueva", 1.0, 2020, "lino", "pastel")));

        // Mostrar estado tras update
        System.out.println("\nEstado tras UPDATE:");
        imprimirTabla(crud);

        // ====== DELETE ======
        System.out.println("\n=== DELETE ===");
        System.out.println("Eliminar 5001 -> " +
                (crud.delete(5001) != null ? "OK (borrada)" : "No existe"));
        System.out.println("Eliminar 9999 -> " +
                (crud.delete(9999) != null ? "OK (borrada)" : "No existe"));

        // Mostrar estado final
        System.out.println("\nEstado FINAL:");
        imprimirTabla(crud);

        // ====== EXTRA: método final y polimorfismo ======
        System.out.println("\n=== EXTRA ===");
        ObraDeArte obra = crud.readId(7001);
        if (obra != null) {
            System.out.println("etiquetaMuseo() -> " + obra.etiquetaMuseo());
            System.out.println("listar()        -> " + obra.listar());
        }
    }

    /** Imprime el arreglo completo con índices */
    private static void imprimirTabla(OperacionCRUD crud) {
        ObraDeArte[] arr = crud.readAll();
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%02d] %s%n", i, (arr[i] == null ? "null" : arr[i].listar()));
        }
    }
}
