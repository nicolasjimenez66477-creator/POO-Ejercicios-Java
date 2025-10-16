import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reserva {
    private String huesped;
    private LocalDate ingreso;
    private LocalDate salida;
    private double tarifaNoche;
    private boolean confirmada;


    public Reserva() {
        this.huesped = "";
        this.ingreso = LocalDate.now();
        this.salida = ingreso.plusDays(1);
        this.tarifaNoche = 0.0;
        this.confirmada = false;
    }

    
    public Reserva(String huesped, LocalDate ingreso, LocalDate salida, double tarifaNoche) {
        this.huesped = huesped;
        setIngreso(ingreso);
        setSalida(salida);
        setTarifaNoche(tarifaNoche);
        this.confirmada = false;
    }

    
    public void setIngreso(LocalDate ingreso) {
        if (ingreso != null) {
            this.ingreso = ingreso;
        } else {
            System.out.println("Fecha de ingreso inválida. Se asigna la fecha actual.");
            this.ingreso = LocalDate.now();
        }
    }

    public void setSalida(LocalDate salida) {
        if (salida != null && salida.isAfter(this.ingreso)) {
            this.salida = salida;
        } else {
            System.out.println("La fecha de salida debe ser posterior a la de ingreso.");
            this.salida = this.ingreso.plusDays(1);
        }
    }

    public void setTarifaNoche(double tarifaNoche) {
        if (tarifaNoche >= 0) {
            this.tarifaNoche = tarifaNoche;
        } else {
            System.out.println("La tarifa por noche no puede ser negativa.");
            this.tarifaNoche = 0.0;
        }
    }

    
    public long noches() {
        return ChronoUnit.DAYS.between(ingreso, salida);
    }

    public double total() {
        return Math.round(noches() * tarifaNoche * 100.0) / 100.0;
    }

    public void confirmar() {
        if (!confirmada) {
            confirmada = true;
            System.out.println("Reserva confirmada para " + huesped + ".");
        } else {
            System.out.println("La reserva ya estaba confirmada.");
        }
    }

    public void cancelar() {
        long horasAntes = ChronoUnit.HOURS.between(LocalDate.now().atStartOfDay(), ingreso.atStartOfDay());
        if (!confirmada || horasAntes >= 48) {
            confirmada = false;
            System.out.println("Reserva cancelada.");
        } else {
            System.out.println("No se puede cancelar una reserva confirmada a menos de 48 horas del ingreso.");
        }
    }

    public void mostrarInfo() {
        System.out.println(noches() + " noches | $" + total() + " | Confirmada: " + confirmada);
    }
}


