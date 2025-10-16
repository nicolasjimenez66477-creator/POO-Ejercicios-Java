public class MainPaciente {
    public static void main(String[] args) {
        Paciente p1 = new Paciente("12345678", "Laura Gómez", 35, 'B');
        p1.mostrarInfo();      
        p1.marcarAtendido();   
        p1.mostrarInfo();      
    }
}


