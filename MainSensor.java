public class MainSensor {
    public static void main(String[] args) {
        Sensor s1 = new Sensor("S-01", 10.0, 30.0);

        s1.actualizarLectura(25.5); 
        s1.activar();
        s1.actualizarLectura(31.4);
        s1.mostrarInfo(); 
    }
}

