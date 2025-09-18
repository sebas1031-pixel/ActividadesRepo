package co.edu.poli.actividad5.model;

public class ObraDeArte {
	private Persona persona;
    private String obra;
    private double peso;
    private int anioCreacion;
    private Localizacion localizacion;
    private int serial;
    private Categoria categoria;
    private String tecnicaArtistica;
    private String evaluacion;
    private Certificacion certificacion;
    private int valoracionDeVisualizacion;
    private int determinacionAnioCreacion;

    public ObraDeArte(Persona persona,
                      String obra,
                      double peso,
                      int anioCreacion,
                      Localizacion localizacion,
                      int serial,
                      Categoria categoria,
                      String tecnicaArtistica,
                      String evaluacion,
                      Certificacion certificacion,
                      int valoracionDeVisualizacion,
                      int determinacionAnioCreacion) {
        this.persona = persona;
        this.obra = obra;
        this.peso = peso;
        this.anioCreacion = anioCreacion;
        this.localizacion = localizacion;
        this.serial = serial;
        this.categoria = categoria;
        this.tecnicaArtistica = tecnicaArtistica;
        this.evaluacion = evaluacion;
        this.certificacion = certificacion;
        this.valoracionDeVisualizacion = valoracionDeVisualizacion;
        this.determinacionAnioCreacion = determinacionAnioCreacion;
    }

    /** Valor base a partir de atributos (heurística simple). */
    public double calcularValorBase() {
        double estado = this.valoracionDeVisualizacion * 100.0;
        double originalidad = Math.max(0, (2025 - this.anioCreacion)) * 50.0;
        if (certificacion != null && certificacion.isAutenticidad()) originalidad *= 1.15;
        return estado + originalidad;
    }

    // ---- SOBRECARGA (OVERLOADING) ----

    /** 1) Sin parámetros: USD por defecto. */
    public double calcularValorPromedio() {
        return calcularValorPromedio("USD");
    }

    /** 2) Con moneda (USD/EUR/COP). */
    public double calcularValorPromedio(String moneda) {
        double base = calcularValorBase();
        String m = (moneda == null ? "USD" : moneda.trim().toUpperCase());
        switch (m) {
            case "EUR": return base * 0.92;
            case "COP": return base * 4000;
            case "USD":
            default:    return base;
        }
    }

    /** 3) Con tasa personalizada (p. ej., 3900 COP por USD). */
    public double calcularValorPromedio(double tasaPersonalizada) {
        return calcularValorBase() * Math.max(0, tasaPersonalizada);
    }

    /** Versión base; las subclases la sobrescriben. */
    public String listar() {
        return String.format(
            "[%d] %s — %s (%d) — Técnica: %s — Peso: %.2f kg — Cat: %s — Ubicación: %s",
            serial, obra,
            persona != null ? persona.getNombre() : "N/D",
            anioCreacion,
            tecnicaArtistica != null ? tecnicaArtistica : "N/D",
            peso,
            categoria != null ? categoria.getNombre() : "N/D",
            localizacion != null ? localizacion.toString() : "N/D"
        );
    }

    // Getter mínimo usado en Principal
    public String getObra() { return obra; }

}
