package co.edu.poli.actividad3.model;

import java.io.Serializable;

/**
* Clase abstracta que representa una obra de arte.
* 
* <p>Contiene los atributos basicos que comparten todas las obras de arte,
* como serial, nombre, peso y anio de creacion.</p>
* 
* <p>Esta clase implementa la interfaz {@link Serializable} para permitir
* guardar y recuperar las instancias desde archivos binarios.</p>
* 
* @author Sebastian
*/
public abstract class ObraDeArte implements Serializable {

   private static final long serialVersionUID = 1L;

   /** Identificador unico de la obra */
   private int serial;

   /** Nombre de la obra */
   private String nombre;

   /** Peso en kilogramos */
   private double peso;

   /** Anio de creacion */
   private int anioCreacion;

   /**
    * Constructor para inicializar los campos basicos de una obra de arte.
    * 
    * @param serial identificador unico
    * @param nombre nombre de la obra
    * @param peso peso en kilogramos
    * @param anioCreacion anio de creacion de la obra
    */
   public ObraDeArte(int serial, String nombre, double peso, int anioCreacion) {
       this.serial = serial;
       this.nombre = nombre;
       this.peso = peso;
       this.anioCreacion = anioCreacion;
   }

   // ===================== Getters y Setters =====================

   /** @return identificador unico de la obra */
   public int getSerial() {
       return serial;
   }

   /** @param serial nuevo identificador unico */
   public void setSerial(int serial) {
       this.serial = serial;
   }

   /** @return nombre de la obra */
   public String getNombre() {
       return nombre;
   }

   /** @param nombre nuevo nombre de la obra */
   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   /** @return peso en kilogramos */
   public double getPeso() {
       return peso;
   }

   /** @param peso nuevo peso en kilogramos */
   public void setPeso(double peso) {
       this.peso = peso;
   }

   /** @return anio de creacion */
   public int getAnioCreacion() {
       return anioCreacion;
   }

   /** @param anioCreacion nuevo anio de creacion */
   public void setAnioCreacion(int anioCreacion) {
       this.anioCreacion = anioCreacion;
   }

   // ===================== Abstract =====================

   /**
    * Metodo abstracto que debe ser implementado por cada subclase
    * para listar la informacion especifica de la obra de arte.
    * 
    * @return cadena con la informacion de la obra
    */
   public abstract String listar();

   // ===================== toString =====================

   /**
    * Representacion en cadena de la obra de arte.
    * Incluye los atributos basicos.
    * 
    * @return cadena con la informacion de la obra
    */
   @Override
   public String toString() {
       return String.format("ObraDeArte [serial=%d, nombre=%s, peso=%.2f, anio=%d]",
               serial, nombre, peso, anioCreacion);
   }
}