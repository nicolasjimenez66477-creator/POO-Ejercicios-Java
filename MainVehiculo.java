public class MainVehiculo {
    public static void main(String[] args) {

        Vehiculo v = new Vehiculo("ABC123", "Toyota", 50.0, 35.0, 7.0);

        v.mostrarInfo(); 

       
        v.recargar(10.0);   
        v.conducir(100.0); 

    
        v.mostrarInfo();
    }
}
