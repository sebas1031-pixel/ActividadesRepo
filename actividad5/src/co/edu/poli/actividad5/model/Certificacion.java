package co.edu.poli.actividad5.model;

public class Certificacion {
	private String obra;
    private String anioCreacion; // como en el diagrama
    private int serial;
    private String firmante;
    private boolean autenticidad;
    private double medidor;
    private String autor;

    public Certificacion(String obra, String anioCreacion, int serial, String firmante,
                         boolean autenticidad, double medidor, String autor) {
        this.obra = obra;
        this.anioCreacion = anioCreacion;
        this.serial = serial;
        this.firmante = firmante;
        this.autenticidad = autenticidad;
        this.medidor = medidor;
        this.autor = autor;
    }

    public boolean isAutenticidad() { return autenticidad; }

}
