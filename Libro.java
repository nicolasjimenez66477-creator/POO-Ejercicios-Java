public class Libro {
    
    private String titulo;
    private String autor;
    private int ejemplaresTotales;
    private int ejemplaresPrestados;

    
    public Libro() {
        this.titulo = "Sin título";
        this.autor = "Desconocido";
        this.ejemplaresTotales = 1;
        this.ejemplaresPrestados = 0;
    }

    public Libro(String titulo, String autor, int ejemplaresTotales, int ejemplaresPrestados) {
        this.titulo = titulo;
        this.autor = autor;
        if (ejemplaresTotales < 0 || ejemplaresPrestados < 0 || ejemplaresPrestados > ejemplaresTotales) {
            throw new IllegalArgumentException("Los valores de ejemplares no son válidos.");
        }
        this.ejemplaresTotales = ejemplaresTotales;
        this.ejemplaresPrestados = ejemplaresPrestados;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getEjemplaresTotales() {
        return ejemplaresTotales;
    }

    public void setEjemplaresTotales(int ejemplaresTotales) {
        if (ejemplaresTotales >= ejemplaresPrestados) {
            this.ejemplaresTotales = ejemplaresTotales;
        }
    }

    public int getEjemplaresPrestados() {
        return ejemplaresPrestados;
    }

    public void setEjemplaresPrestados(int ejemplaresPrestados) {
        if (ejemplaresPrestados >= 0 && ejemplaresPrestados <= ejemplaresTotales) {
            this.ejemplaresPrestados = ejemplaresPrestados;
        }
    }

    
    public boolean prestar() {
        if (ejemplaresPrestados < ejemplaresTotales) {
            ejemplaresPrestados++;
            return true;
        } else {
            return false;
        }
    }

    
    public boolean devolver() {
        if (ejemplaresPrestados > 0) {
            ejemplaresPrestados--;
            return true;
        } else {
            return false;
        }
    }

    
    public int disponibles() {
        return ejemplaresTotales - ejemplaresPrestados;
    }

    
    @Override
    public String toString() {
        return titulo + " - disp: " + disponibles() + "/" + ejemplaresTotales;
    }
}
