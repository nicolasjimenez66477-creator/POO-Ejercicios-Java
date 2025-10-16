import java.time.LocalDate;

public class MainReserve {
    public static void main(String[] args) {
        
        LocalDate ingreso = LocalDate.of(2025, 10, 20);
        LocalDate salida = LocalDate.of(2025, 10, 23);

        Reserva r1 = new Reserva("Carlos Pérez", ingreso, salida, 180.0);

        r1.mostrarInfo();     
        r1.confirmar();       
        r1.mostrarInfo();    
        r1.cancelar();        
    }
}


