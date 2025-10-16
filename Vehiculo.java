public class Vehiculo {
    private String placa;
    private String marca;
    private double capacidadTanqueLitros;
    private double combustibleActual;
    private double kmPorLitro;

    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.capacidadTanqueLitros = 0.0;
        this.combustibleActual = 0.0;
        this.kmPorLitro = 0.0;
    }
    public Vehiculo(String placa, String marca, double capacidadTanqueLitros,
                    double combustibleActual, double kmPorLitro) {
        this.placa = placa;
        this.marca = marca;

        if (capacidadTanqueLitros > 0 && kmPorLitro > 0) {
            this.capacidadTanqueLitros = capacidadTanqueLitros;
            this.kmPorLitro = kmPorLitro;
        } else {
            throw new IllegalArgumentException("capacidadTanqueLitros y kmPorLitro deben ser > 0");
        }

        if (combustibleActual < 0) {
            this.combustibleActual = 0.0;
        } else if (combustibleActual > capacidadTanqueLitros) {
            this.combustibleActual = capacidadTanqueLitros;
        } else {
            this.combustibleActual = combustibleActual;
        }
    }

    
    public void setCombustibleActual(double litros) {
        if (litros < 0) {
            System.out.println("No se permiten valores negativos para combustible.");
            return;
        }
        if (litros > capacidadTanqueLitros) {
            combustibleActual = capacidadTanqueLitros;
        } else {
            combustibleActual = litros;
        }
    }

    public void setKmPorLitro(double kmPorLitro) {
        if (kmPorLitro <= 0) {
            System.out.println("El rendimiento (km/l) debe ser mayor que 0.");
            return;
        }
        this.kmPorLitro = kmPorLitro;
    }

   
    public void recargar(double litros) {
        if (litros <= 0) {
            System.out.println("No se puede recargar con una cantidad negativa o cero.");
            return;
        }
        if (combustibleActual + litros <= capacidadTanqueLitros) {
            combustibleActual += litros;
        } else {
            combustibleActual = capacidadTanqueLitros;
            System.out.println("Tanque lleno: la recarga se detuvo al alcanzar la capacidad máxima.");
        }
    }

    public void conducir(double km) {
        if (km <= 0) {
            System.out.println("La distancia debe ser positiva.");
            return;
        }
        double consumoNecesario = km / kmPorLitro;
        if (consumoNecesario <= combustibleActual) {
            combustibleActual -= consumoNecesario;
            System.out.println("Has conducido " + km + " km.");
        } else {
            System.out.println("Combustible insuficiente para recorrer esa distancia.");
        }
    }

    public double autonomia() {
        double autonomia = combustibleActual * kmPorLitro;
        return Math.round(autonomia * 10.0) / 10.0;
    }

    public void mostrarInfo() {
        System.out.println(placa + " | Autonomía: " + autonomia() + " km.");
    }
}

