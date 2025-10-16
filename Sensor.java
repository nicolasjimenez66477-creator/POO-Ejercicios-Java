public class Sensor {
    private String id;
    private double ultimaLecturaC;
    private double umbralAlto;
    private double umbralBajo;
    private boolean activo;

    
    public Sensor() {
        this.id = "";
        this.ultimaLecturaC = 0.0;
        this.umbralBajo = 0.0;
        this.umbralAlto = 100.0;
        this.activo = false;
    }

    
    public Sensor(String id, double umbralBajo, double umbralAlto) {
        this.id = id;
        if (umbralBajo < umbralAlto) {
            this.umbralBajo = umbralBajo;
            this.umbralAlto = umbralAlto;
        } else {
            System.out.println("Error: el umbral bajo debe ser menor que el umbral alto.");
            this.umbralBajo = 0.0;
            this.umbralAlto = 100.0;
        }
        this.ultimaLecturaC = 0.0;
        this.activo = false;
    }

    
    public void activar() {
        activo = true;
        System.out.println("Sensor activado.");
    }

    public void desactivar() {
        activo = false;
        System.out.println("Sensor desactivado.");
    }

    
    public void actualizarLectura(double nuevaLectura) {
        if (activo) {
            this.ultimaLecturaC = nuevaLectura;
        } else {
            System.out.println("No se puede actualizar la lectura: el sensor está inactivo.");
        }
    }

    
    public boolean enAlarma() {
        return (ultimaLecturaC < umbralBajo || ultimaLecturaC > umbralAlto);
    }

    
    public void mostrarInfo() {
        System.out.println(id + " | " + String.format("%.1f°C", ultimaLecturaC) + " | Alarma: " + enAlarma() + ".");
    }
}

