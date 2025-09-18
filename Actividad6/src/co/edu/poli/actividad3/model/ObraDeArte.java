package co.edu.poli.actividad3.model;

public abstract class ObraDeArte {

    private Persona persona;
    private String obra;
    private double peso;
    private int anioCreacion;
    private Localizacion localizacion;

    // ATRIBUTO QUE NO SE PUEDE CAMBIAR (final)
    private final int serial; // <- NO modificable luego de construido

    private Categoria categoria;
    private String tecnicaArtistica;
    private String evaluacion;
    private Certificacion certificacion;
    private int valoracionDeVisualizacion;
    private int determinacionAnioCreacion;

    // === MODIFICADOR static (ejemplo) ===
    private static int CONTADOR_OBRAS = 0;

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
        this.serial = serial; // final: se define solo aquí
        this.categoria = categoria;
        this.tecnicaArtistica = tecnicaArtistica;
        this.evaluacion = evaluacion;
        this.certificacion = certificacion;
        this.valoracionDeVisualizacion = valoracionDeVisualizacion;
        this.determinacionAnioCreacion = determinacionAnioCreacion;
        CONTADOR_OBRAS++; // static counter
    }

    /** Valor base a partir de atributos (heurística simple). */
    public double calcularValorBase() {
        double estado = this.valoracionDeVisualizacion * 100.0;
        double originalidad = Math.max(0, (2025 - this.anioCreacion)) * 50.0;
        if (certificacion != null && certificacion.isAutenticidad()) originalidad *= 1.15;
        return estado + originalidad;
    }

    // ---- SOBRECARGA (OVERLOADING) ----
    public double calcularValorPromedio() { return calcularValorPromedio("USD"); }
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
    public double calcularValorPromedio(double tasaPersonalizada) {
        return calcularValorBase() * Math.max(0, tasaPersonalizada);
    }

    /** Versión base; las subclases la sobrescriben para evidenciar overriding. */
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

    // MÉTODO QUE NO SE PUEDE SOBRESCRIBIR (final)
    public final String etiquetaMuseo() {
        return "MUSEO-POLI-" + serial;
    }

    // toString para trazas rápidas (opcional)
    @Override
    public String toString() {
        return listar();
    }

    // Getters mínimos
    public String getObra() { return obra; }
    public int getSerial() { return serial; }

    // Static getter (ejemplo de static)
    public static int getContadorObras() { return CONTADOR_OBRAS; }
}
