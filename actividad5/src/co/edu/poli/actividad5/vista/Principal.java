package co.edu.poli.actividad5.vista;

import co.edu.poli.actividad5.model.*;
import co.edu.poli.actividad5.servicios.PinturaAlOleo;

public class Principal {
	 public static void main(String[] args) {
	        // ===== Datos base (sin null) =====
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

	        // ===== (3) Creación e impresión de objetos =====
	        ObraDeArte escultura = new Escultura(
	                autorX, "Las Meninas", 40.0, 1656, loc1,
	                5001, catEsc, "—", "Restaurada 1990", certEsc, 8, 0,
	                "mármol", 180.0, 120.0
	        );

	        Pintura pintura = new Pintura(
	                vanGogh, "Girasoles", 5.5, 1888, loc2,
	                6001, catPint, "óleo", "Excelente estado", certPint, 10, 0,
	                "lino", "óleo"
	        );

	        PinturaAlOleo oleo = new PinturaAlOleo(
	                picasso, "Guernica", 7.0, 1937, loc3,
	                7001, catPint, "óleo", "Obra icónica", certOleo, 10, 0,
	                "lino", "óleo", false, 21, "lino"
	        );

	        System.out.println("=== (3) CREACIÓN E IMPRESIÓN DE OBJETOS ===");
	        System.out.println(escultura.listar());
	        System.out.println(pintura.listar());
	        System.out.println(oleo.listar());

	        // ===== (4) Evidencia de SOBRESCRITURA =====
	        System.out.println("\n=== (4) SOBRESCRITURA: listar() y calcularValorBase() ===");
	        System.out.println("Escultura.listar() -> " + escultura.listar());
	        System.out.println("Pintura.listar()   -> " + pintura.listar());
	        System.out.println("Oleo.listar()      -> " + oleo.listar());

	        System.out.printf("Escultura.calcularValorBase() = %.2f%n", escultura.calcularValorBase());
	        System.out.printf("Pintura.calcularValorBase()   = %.2f%n", pintura.calcularValorBase());
	        System.out.printf("Oleo.calcularValorBase()      = %.2f%n", oleo.calcularValorBase());

	        // ===== (5) Evidencia de SOBRECARGA =====
	        System.out.println("\n=== (5) SOBRECARGA: calcularValorPromedio() ===");
	        System.out.printf("pintura.calcularValorPromedio() [USD] = %.2f%n",
	                pintura.calcularValorPromedio());           // sin parámetros
	        System.out.printf("pintura.calcularValorPromedio(\"EUR\") = %.2f%n",
	                pintura.calcularValorPromedio("EUR"));      // con String
	        System.out.printf("oleo.calcularValorPromedio(\"COP\")   = %.2f%n",
	                oleo.calcularValorPromedio("COP"));         // con String
	        System.out.printf("escultura.calcularValorPromedio(3900) [COP custom] = %.2f%n",
	                escultura.calcularValorPromedio(3900));     // con double

	        // Métodos específicos
	        System.out.println("\n=== EXTRA: métodos específicos ===");
	        pintura.describirPintura();
	        ((Escultura) escultura).mostrarMaterial();
	        oleo.aplicarBarniz();
	    }

}
