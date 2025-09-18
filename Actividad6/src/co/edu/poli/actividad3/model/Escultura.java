package co.edu.poli.actividad3.model;
public class Escultura extends ObraDeArte{
	   private String material;     // mármol, bronce, madera, etc.
	    private double altura;       // cm
	    private double pesoEscultura; // kg

	    public Escultura(Persona persona, String obra, double peso, int anioCreacion, Localizacion localizacion,
	                     int serial, Categoria categoria, String tecnicaArtistica, String evaluacion,
	                     Certificacion certificacion, int valoracionDeVisualizacion, int determinacionAnioCreacion,
	                     String material, double altura, double pesoEscultura) {
	        super(persona, obra, peso, anioCreacion, localizacion, serial, categoria,
	              tecnicaArtistica, evaluacion, certificacion,
	              valoracionDeVisualizacion, determinacionAnioCreacion);
	        this.material = material;
	        this.altura = Math.max(0, altura);
	        this.pesoEscultura = Math.max(0, pesoEscultura);
	    }

	    public void mostrarMaterial() {
	        System.out.println("Escultura — material: " + material);
	    }

	    @Override
	    public String listar() {
	        return super.listar() + String.format(
	            " — [Escultura: material=%s, altura=%.1f cm, peso=%.2f kg]",
	            material, altura, pesoEscultura
	        );
	    }
}
