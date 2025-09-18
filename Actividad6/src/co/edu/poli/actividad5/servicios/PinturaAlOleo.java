package co.edu.poli.actividad5.servicios;

import co.edu.poli.actividad3.model.*;

public class PinturaAlOleo extends Pintura{
	 private boolean barnizada;
	    private int tiempoSecado;     // días
	    private String tipoLienzo;    // lino, algodón, etc.

	    public PinturaAlOleo(Persona persona, String obra, double peso, int anioCreacion, Localizacion localizacion,
	                         int serial, Categoria categoria, String tecnicaArtistica, String evaluacion,
	                         Certificacion certificacion, int valoracionDeVisualizacion, int determinacionAnioCreacion,
	                         String lienzo, String tecnicas,
	                         boolean barnizada, int tiempoSecado, String tipoLienzo) {
	        super(persona, obra, peso, anioCreacion, localizacion, serial,
	              categoria, tecnicaArtistica, evaluacion,
	              certificacion, valoracionDeVisualizacion, determinacionAnioCreacion,
	              lienzo, tecnicas);
	        this.barnizada = barnizada;
	        this.tiempoSecado = Math.max(0, tiempoSecado);
	        this.tipoLienzo = tipoLienzo;
	    }

	    public void aplicarBarniz() {
	        this.barnizada = true;
	        System.out.println("Barniz aplicado a la pintura al óleo.");
	    }

	    @Override
	    public String listar() {
	        return super.listar() + String.format(" — [Óleo: barnizada=%s, secado=%d días, tipoLienzo=%s]",
	                barnizada ? "sí" : "no", tiempoSecado, tipoLienzo);
	    }


}
