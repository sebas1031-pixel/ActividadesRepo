package co.edu.poli.actividad5.model;

public class Pintura extends ObraDeArte{
	private String lienzo;   // lino, algodón, etc.
    private String tecnicas; // "óleo", "acrílico", ...

    public Pintura(Persona persona, String obra, double peso, int anioCreacion, Localizacion localizacion,
                   int serial, Categoria categoria, String tecnicaArtistica, String evaluacion,
                   Certificacion certificacion, int valoracionDeVisualizacion, int determinacionAnioCreacion,
                   String lienzo, String tecnicas) {
        super(persona, obra, peso, anioCreacion, localizacion, serial, categoria,
              tecnicaArtistica, evaluacion, certificacion,
              valoracionDeVisualizacion, determinacionAnioCreacion);
        this.lienzo = lienzo;
        this.tecnicas = tecnicas;
    }

    /** Sobrescritura: agrega bonificaciones según técnica/lienzo. */
    @Override
    public double calcularValorBase() {
        double base = super.calcularValorBase();
        if (tecnicas != null && tecnicas.toLowerCase().contains("óleo")) base += 300.0;
        if (lienzo != null && lienzo.toLowerCase().contains("lino"))  base += 200.0;
        return base;
    }

    /** Método propio del diagrama. */
    public void describirPintura() {
        System.out.println("Pintura — lienzo: " + lienzo + ", técnica(s): " + tecnicas);
    }

    @Override
    public String listar() {
        return super.listar() + String.format(" — [Pintura: lienzo=%s, técnicas=%s]", lienzo, tecnicas);
    }

}
