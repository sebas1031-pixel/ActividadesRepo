package co.edu.poli.actividad3.model;

/**
* Representa a una persona relacionada con la obra de arte
* (puede ser autor, propietario, etc.).
*/
public class Persona {

   /** Nombre completo de la persona. */
   private String nombre;

   /** Nacionalidad de la persona. */
   private String nacionalidad;

   /**
    * Constructor de Persona.
    *
    * @param nombre nombre completo
    * @param nacionalidad nacionalidad
    */
   public Persona(String nombre, String nacionalidad) {
       this.nombre = nombre;
       this.nacionalidad = nacionalidad;
   }

   /** @return nombre completo de la persona */
   public String getNombre() { return nombre; }

   /** @param nombre nuevo nombre */
   public void setNombre(String nombre) { this.nombre = nombre; }

   /** @return nacionalidad de la persona */
   public String getNacionalidad() { return nacionalidad; }

   /** @param nacionalidad nueva nacionalidad */
   public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }
}
