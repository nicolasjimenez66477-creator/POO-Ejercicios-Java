public class Paciente {
    private String documento;
    private String nombre;
    private int edad;
    private char nivelTriage; 
    private boolean atendido;

    public Paciente() {
        this.documento = "";
        this.nombre = "";
        this.edad = 0;
        this.nivelTriage = 'E';
        this.atendido = false;
    }


    public Paciente(String documento, String nombre, int edad, char nivelTriage) {
        this.documento = documento;
        this.nombre = nombre;
        setEdad(edad);
        setNivelTriage(nivelTriage);
        this.atendido = false;
    }

    
    public void setEdad(int edad) {
        if (edad >= 0) {
            this.edad = edad;
        } else {
            System.out.println("La edad no puede ser negativa. Se asigna 0.");
            this.edad = 0;
        }
    }

    public void setNivelTriage(char nivelTriage) {
        nivelTriage = Character.toUpperCase(nivelTriage);
        if (nivelTriage >= 'A' && nivelTriage <= 'E') {
            this.nivelTriage = nivelTriage;
        } else {
            System.out.println("Nivel de triage inválido. Se asigna 'E' por defecto.");
            this.nivelTriage = 'E';
        }
    }

    
    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public char getNivelTriage() {
        return nivelTriage;
    }

    public boolean isAtendido() {
        return atendido;
    }

    
    public int prioridad() {
        
        return (nivelTriage - 'A') + 1;
    }

    
    public void marcarAtendido() {
        if (!atendido) {
            atendido = true;
            System.out.println(nombre + " ha sido atendido.");
        } else {
            System.out.println(nombre + " ya estaba atendido.");
        }
    }

    
    public void mostrarInfo() {
        System.out.println("Triage " + nivelTriage +
                " | Prioridad " + prioridad() +
                " | Atendido: " + atendido + ".");
    }
}

