package co.edu.poli.actividad3.model;

public class Localizacion {
	 private Pais pais;
	    private String ciudad;
	    private String sala;
	    private boolean esVitrina;

	    public Localizacion(Pais pais, String ciudad, String sala, boolean esVitrina) {
	        this.pais = pais;
	        this.ciudad = ciudad;
	        this.sala = sala;
	        this.esVitrina = esVitrina;
	    }

	    @Override
	    public String toString() {
	        return (pais != null ? pais.toString() : "N/D") + " - " + ciudad + " - " + sala +
	               (esVitrina ? " (vitrina)" : "");
	    }

}
