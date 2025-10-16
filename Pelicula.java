public class Pelicula {
    private String titulo;
    private int anio;
    private String clasificacion;
    private int copias;
    private int alquiladas;

    public Pelicula() {
        this.titulo = "Sin título";
        this.anio = 2000;
        this.clasificacion = "G";
        this.copias = 1;
        this.alquiladas = 0;
    }

    public Pelicula(String titulo, int anio, String clasificacion, int copias, int alquiladas) {
        this.titulo = titulo;
        this.anio = (anio >= 1900) ? anio : 1900;
        this.clasificacion = clasificacion;
        this.copias = Math.max(0, copias);
        this.alquiladas = Math.min(alquiladas, copias);
    }

    private int edadMinima(String clasificacion) {
        switch (clasificacion.toUpperCase()) {
            case "PG13": return 13;
            case "R": return 17;
            case "G": default: return 0;
        }
    }

    public void alquilar(int edadCliente) {
        if (alquiladas >= copias) {
            System.out.println("No hay copias disponibles.");
            return;
        }
        if (edadCliente < edadMinima(clasificacion)) {
            System.out.println("El cliente no cumple la edad mínima para esta clasificación.");
            return;
        }
        alquiladas++;
        System.out.println("Película alquilada con éxito.");
    }

    public void devolver() {
        if (alquiladas > 0) {
            alquiladas--;
            System.out.println("Película devuelta correctamente.");
        } else {
            System.out.println("No hay películas alquiladas para devolver.");
        }
    }

    @Override
    public String toString() {
        return String.format("%s (%s) | disp: %d/%d", titulo, clasificacion, (copias - alquiladas), copias);
    }
}

