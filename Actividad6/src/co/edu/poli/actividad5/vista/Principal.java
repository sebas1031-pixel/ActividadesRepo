package co.edu.poli.actividad5.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad5.servicios.*;


/** Clase de arranque: ejecuta el flujo CRUD en consola. */
public class Principal {

    /** Constructor por defecto sin comportamiento adicional. */
    public Principal() { }

    /**
     * Ejecuta las operaciones CRUD en orden:
     * CREATE -> READ ALL -> READ ID -> UPDATE -> READ ALL -> DELETE -> READ ALL.
     * @param args argumentos de linea de comandos
     */
    public static void main(String[] args) {

        OperacionCRUD crud = new ImplementacionOperacionCRUD(); // tamano inicial 3

        // === CREATE ===
        System.out.println("=== CREATE ===");
        ObraDeArte e1 = new Escultura(1, "David", 500.0, 1504, "Marmol", 517.0);
        ObraDeArte p1 = new Pintura(2, "La Noche Estrellada", 50.0, 1889, "Lienzo", "Oleo");
        ObraDeArte o1 = new PinturaAlOleo(3, "Mona Lisa", 45.0, 1503, "Lienzo", "Oleo", true, 15);
        System.out.println(crud.create(e1));
        System.out.println(crud.create(p1));
        System.out.println(crud.create(o1));

        // === READ ALL ===
        System.out.println("\n=== READ ALL ===");
        for (ObraDeArte o : crud.readAll()) System.out.println(o);

        // === READ ID ===
        System.out.println("\n=== READ ID ===");
        System.out.println(crud.readId(2));

        // === UPDATE ===
        System.out.println("\n=== UPDATE ===");
        ObraDeArte p2 = new Pintura(2, "La Noche Estrellada (Restaurada)", 55.0, 1889, "Lienzo", "Oleo");
        System.out.println(crud.update(2, p2));
        for (ObraDeArte o : crud.readAll()) System.out.println(o);

        // === DELETE ===
        System.out.println("\n=== DELETE ===");
        System.out.println("Eliminada: " + crud.delete(1));
        for (ObraDeArte o : crud.readAll()) System.out.println(o);
    }
}