public class Estudiante {
    
    private String id;
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;

    
    public Estudiante() {
        this.id = "";
        this.nombre = "";
        this.nota1 = this.nota2 = this.nota3 = 0.0;
    }

    
    public Estudiante(String id, String nombre, double nota1, double nota2, double nota3) {
        this.id = id;
        this.nombre = nombre;
        setNota1(nota1);
        setNota2(nota2);
        setNota3(nota3);
    }


    public void setNota1(double nota1) {
        if (nota1 >= 0.0 && nota1 <= 5.0) this.nota1 = nota1;
        else System.out.println("Nota 1 fuera de rango (0.0 - 5.0)");
    }

    public void setNota2(double nota2) {
        if (nota2 >= 0.0 && nota2 <= 5.0) this.nota2 = nota2;
        else System.out.println("Nota 2 fuera de rango (0.0 - 5.0)");
    }

    public void setNota3(double nota3) {
        if (nota3 >= 0.0 && nota3 <= 5.0) this.nota3 = nota3;
        else System.out.println("Nota 3 fuera de rango (0.0 - 5.0)");
    }

    
    public double getPromedio() {
        double promedio = (nota1 + nota2 + nota3) / 3.0;
        return Math.round(promedio * 10.0) / 10.0; 
    }

    public boolean aprobado() {
        return getPromedio() >= 3.0;
    }

    
    public void mostrarInfo() {
        System.out.println("ID: " + id + " | Prom: " + getPromedio() + " | " +
                           (aprobado() ? "Aprobado." : "Reprobado."));
    }
}
