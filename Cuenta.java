public class Cuenta {
 private String titular;

    private String numero;
    private double saldo;
    private boolean activa;


    public Cuenta() {
        this.titular = "Sin titular";
        this.numero = "000-0";
        this.saldo = 0;
        this.activa = true;
    }

    
    public Cuenta(String titular, String numero, double saldo, boolean activa) {
        this.titular = titular;
        this.numero = numero;
        this.saldo = Math.max(0, saldo); 
        this.activa = activa;
    }

    
    public void depositar(double monto) {
        if (!activa) {
            System.out.println("La cuenta está bloqueada. No se puede depositar.");
            return;
        }
        if (monto > 0) {
            saldo += monto;
            System.out.println("Depósito exitoso: $" + monto);
        } else {
            System.out.println("El monto debe ser mayor que 0.");
        }
    }

    
    public void retirar(double monto) {
        if (!activa) {
            System.out.println("La cuenta está bloqueada. No se puede retirar.");
            return;
        }
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
            System.out.println("Retiro exitoso: $" + monto);
        } else {
            System.out.println("No se puede retirar ese monto (saldo insuficiente o valor inválido).");
        }
    }

    
    public void bloquear() {
        activa = false;
        System.out.println("Cuenta bloqueada.");
    }

    
    public void activar() {
        activa = true;
        System.out.println("Cuenta activada.");
    }

    
    public double getSaldo() {
        return saldo;
    }

    
    @Override
    public String toString() {
        return String.format("Cuenta %s | Saldo: %,.2f", numero, saldo);
    }
}
