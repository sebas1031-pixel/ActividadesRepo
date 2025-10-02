package co.edu.poli.actividad5.vista;

import java.util.Scanner;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad5.servicios.*;


/**
 * Clase Principal que presenta un menu de consola con 8 opciones:
 * CRUD completo (create, read all, read id, update, delete),
 * mas serializar, deserializar y salir.
 *
 * El programa utiliza ImplementacionOperacionCRUD como servicio
 * para gestionar un arreglo polimorfico de ObraDeArte.
 *
 * Autor: Tu Nombre
 */
public class Principal {

    /** Ruta del archivo binario para serializacion. */
    private static final String RUTA = "obras.dat";

    /**
     * Metodo main que inicia el menu y despacha las opciones.
     * @param args argumentos de linea de comandos
     */
    public static void main(String[] args) {
        ImplementacionOperacionCRUD servicio = new ImplementacionOperacionCRUD();
        Scanner sc = new Scanner(System.in);

        System.out.println("==== Museo - CRUD + Archivo (8 opciones) ====");

        while (true) {
            System.out.println("""
                \n[1] Create (crear objeto)
                [2] Read All (listar todos)
                [3] Read Id (listar por ID)
                [4] Update (modificar por ID)
                [5] Delete (eliminar por ID)
                [6] Serializar (guardar archivo)
                [7] Deserializar (leer archivo)
                [8] Salir
                """);
            System.out.print("Opcion: ");
            int op = leerEntero(sc);

            switch (op) {
                case 1 -> crear(sc, servicio);
                case 2 -> listarTodos(servicio);
                case 3 -> listarUno(sc, servicio);
                case 4 -> modificar(sc, servicio);
                case 5 -> eliminar(sc, servicio);
                case 6 -> System.out.println(servicio.serializar(RUTA));
                case 7 -> System.out.println(servicio.deserializar(RUTA));
                case 8 -> { System.out.println("Chao!"); sc.close(); return; }
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    // =================== CRUD ===================

    /**
     * Crea un objeto segun el tipo indicado por el usuario.
     * Se respetan hasta cinco primitivos digitados.
     *
     * @param sc scanner para leer desde consola
     * @param crud servicio CRUD
     */
    private static void crear(Scanner sc, ImplementacionOperacionCRUD crud) {
        System.out.println("Tipo: 1-Escultura  2-Pintura  3-PinturaAlOleo");
        int t = leerEntero(sc);

        // Comunes: serial(int), peso(double), anio(int) -> 3 primitivos
        System.out.print("serial (int): "); int serial = leerEntero(sc);
        System.out.print("nombre (String): "); String nombre = sc.nextLine().trim();
        System.out.print("peso (double): "); double peso = leerDouble(sc);
        System.out.print("anioCreacion (int): "); int anio = leerEntero(sc);

        switch (t) {
            case 1 -> { // Escultura (+1: altura)
                System.out.print("material (String): "); String mat = sc.nextLine().trim();
                System.out.print("altura (double): "); double alt = leerDouble(sc); // 4to primitivo
                System.out.println(crud.create(new Escultura(serial, nombre, peso, anio, mat, alt)));
            }
            case 2 -> { // Pintura (+0)
                System.out.print("lienzo (String): "); String lienzo = sc.nextLine().trim();
                System.out.print("tecnica (String): "); String tec = sc.nextLine().trim();
                System.out.println(crud.create(new Pintura(serial, nombre, peso, anio, lienzo, tec)));
            }
            case 3 -> { // PinturaAlOleo (+2: boolean,int) -> total 5
                System.out.print("lienzo (String): "); String lienzo = sc.nextLine().trim();
                System.out.print("tecnica (String): "); String tec = sc.nextLine().trim();
                System.out.print("barnizada (true/false): "); boolean barn = leerBoolean(sc); // 4to
                System.out.print("tiempoSecado (int): "); int dias = leerEntero(sc);         // 5to
                Pintura p = new PinturaAlOleo(serial, nombre, peso, anio, lienzo, tec, barn, dias);
                System.out.println(crud.create(p));
            }
            default -> System.out.println("Tipo invalido");
        }
    }

    /**
     * Lista por consola todas las posiciones del arreglo de obras.
     * Puede mostrar null en posiciones vacias.
     *
     * @param crud servicio CRUD
     */
    private static void listarTodos(ImplementacionOperacionCRUD crud) {
        ObraDeArte[] arr = crud.readAll();
        if (arr == null) { System.out.println("(sin datos)"); return; }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("[%d] %s%n", i, arr[i]);
        }
    }

    /**
     * Lista un objeto por su identificador (serial).
     *
     * @param sc scanner de consola
     * @param crud servicio CRUD
     */
    private static void listarUno(Scanner sc, ImplementacionOperacionCRUD crud) {
        System.out.print("ID (serial): "); int id = leerEntero(sc);
        System.out.println(crud.readId(id));
    }

    /**
     * Modifica un objeto existente por su identificador (serial).
     * Para simplificar, se reemplaza por una instancia de Pintura
     * con valores digitados por el usuario.
     *
     * @param sc scanner
     * @param crud servicio CRUD
     */
    private static void modificar(Scanner sc, ImplementacionOperacionCRUD crud) {
        System.out.print("ID a modificar: "); int id = leerEntero(sc);
        ObraDeArte actual = crud.readId(id);
        if (actual == null) { System.out.println("No existe " + id); return; }

        System.out.print("nuevo nombre: "); String nombre = sc.nextLine().trim();
        System.out.print("nuevo peso (double): "); double peso = leerDouble(sc);
        System.out.print("nuevo anio (int): "); int anio = leerEntero(sc);

        ObraDeArte nueva = new Pintura(id, nombre, peso, anio, "Lienzo", "Mixta");
        System.out.println(crud.update(id, nueva));
    }

    /**
     * Elimina un objeto por su identificador (serial).
     *
     * @param sc scanner
     * @param crud servicio CRUD
     */
    private static void eliminar(Scanner sc, ImplementacionOperacionCRUD crud) {
        System.out.print("ID a eliminar: "); int id = leerEntero(sc);
        System.out.println("Eliminada: " + crud.delete(id));
    }

    // =================== util de lectura ===================

    /**
     * Lee un entero desde consola, reintentando hasta que sea valido.
     * @param sc scanner
     * @return entero valido
     */
    private static int leerEntero(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try { return Integer.parseInt(s); } catch (Exception e) { System.out.print("int invalido: "); }
        }
    }

    /**
     * Lee un double desde consola, reintentando hasta que sea valido.
     * @param sc scanner
     * @return double valido
     */
    private static double leerDouble(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim();
            try { return Double.parseDouble(s); } catch (Exception e) { System.out.print("double invalido: "); }
        }
    }

    /**
     * Lee un boolean desde consola. Acepta true/false, t/f, si/no.
     * @param sc scanner
     * @return true o false segun el texto ingresado
     */
    private static boolean leerBoolean(Scanner sc) {
        while (true) {
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("true") || s.equals("t") || s.equals("si")) return true;
            if (s.equals("false") || s.equals("f") || s.equals("no")) return false;
            System.out.print("boolean (true/false): ");
        }
    }
}