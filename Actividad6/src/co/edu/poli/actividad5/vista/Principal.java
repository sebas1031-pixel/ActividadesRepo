package co.edu.poli.actividad5.vista;

import co.edu.poli.actividad3.model.*;
import co.edu.poli.actividad5.servicios.*;


public class Principal {
    // MÉTODO POLIMÓRFICO (recibe supersuperclase) 
    public static void imprimirBasico(ObraDeArte o) {
        System.out.println("[Etiqueta] " + o.etiquetaMuseo()); // final method
        System.out.println(o.listar()); // overriding polimórfico
    }

    // MÉTODO POLIMÓRFICO (retorna supersuperclase)
    public static ObraDeArte buscarPorSerial(ObraDeArte[] arr, int serial) {
        if (arr == null) return null;
        for (ObraDeArte o : arr) {
            if (o != null && o.getSerial() == serial) return o;
        }
        return null;
    }

    public static void main(String[] args) {
        // Atributo final: ver ObraDeArte.serial
        // Método final: ver ObraDeArte.etiquetaMuseo()
        // Clase final: ver co.edu.poli.actividad3.model.Certificacion

        // Datos
        Pais co = new Pais("Colombia", "Español", "+57");
        Localizacion loc1 = new Localizacion(co, "Bogotá", "Sala 1", true);
        Localizacion loc2 = new Localizacion(co, "Bogotá", "Sala 2", false);
        Localizacion loc3 = new Localizacion(co, "Bogotá", "Sala 3", true);

        Persona autorX   = new Persona("Autor X", 123456789, "Colombiana", 1.78, 75, 45);
        Persona vanGogh  = new Persona("Van Gogh", 987654321, "Neerlandesa", 1.70, 65, 37);
        Persona picasso  = new Persona("P. Picasso", 111222333, "Española", 1.73, 70, 91);

        Categoria catPint = new Categoria(1, "Pintura", "Obras pictóricas");
        Categoria catEsc  = new Categoria(2, "Escultura", "Obras escultóricas");

        Certificacion certEsc = new Certificacion("Las Meninas", "1656", 1001, "Museo del Prado", true, 9.5, "Velázquez");
        Certificacion certPint = new Certificacion("Girasoles", "1888", 1002, "Van Gogh Museum", true, 9.1, "Van Gogh");
        Certificacion certOleo = new Certificacion("Guernica", "1937", 1003, "Museo Reina Sofía", true, 9.7, "Pablo Picasso");

        ObraDeArte escultura = new Escultura(
                autorX, "Las Meninas", 40.0, 1656, loc1,
                5001, catEsc, "—", "Restaurada 1990", certEsc, 8, 0,
                "mármol", 180.0, 120.0
        );

        ObraDeArte pintura = new Pintura(
                vanGogh, "Girasoles", 5.5, 1888, loc2,
                6001, catPint, "óleo", "Excelente estado", certPint, 10, 0,
                "lino", "óleo"
        );

        ObraDeArte oleo = new PinturaAlOleo(
                picasso, "Guernica", 7.0, 1937, loc3,
                7001, catPint, "óleo", "Obra icónica", certOleo, 10, 0,
                "lino", "óleo", false, 21, null
        );

        // Arreglo de supersuperclase 
        ObraDeArte[] inventario = new ObraDeArte[5];
        inventario[0] = escultura;     // subclase A
        inventario[1] = pintura;       // subclase B
        inventario[2] = oleo;          // sub-subclase 

        System.out.println("--- OVERRIDING ---");
        for (ObraDeArte o : inventario) {
            if (o != null) {
                System.out.println(o.listar());
            }
        }

        // Se invoca los 2 métodos polimórficos
        System.out.println("\n--- POLIMORFISMO PARÁMETRO ---"); //Recibe ObraDeArte PARÁMETRO
        imprimirBasico(oleo);

        System.out.println("\n--- POLIMORFISMO RETORNO ---"); //Retorna ObraDeArte SUPERCLASE
        ObraDeArte hallada = buscarPorSerial(inventario, 6001); // retorna supersuperclase
        System.out.println(hallada != null ? "Encontrada: " + hallada.listar() : "No encontrada");

        // Sobrecarga (evidencia breve)
        System.out.println("\n--- OVERLOADING (calcularValorPromedio) ---");
        System.out.printf("pintura sin args (USD) = %.2f%n", pintura.calcularValorPromedio());
        System.out.printf("pintura a EUR          = %.2f%n", pintura.calcularValorPromedio("EUR"));
        System.out.printf("escultura tasa 3900    = %.2f%n", escultura.calcularValorPromedio(3900));

        // Mostrar uso de método final y static
        System.out.println("\n--- FINAL / STATIC ---");
        System.out.println("Etiqueta de oleo (final): " + oleo.etiquetaMuseo());
        System.out.println("Total de obras creadas (static): " + ObraDeArte.getContadorObras());
    }

}
