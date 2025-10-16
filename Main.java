public class Main {
    public static void main(String[] args) {
        
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 5, 3);

    
        System.out.println(libro1);

        if (libro1.prestar()) {
            System.out.println("Se ha prestado un ejemplar.");
        } else {
            System.out.println("No hay ejemplares disponibles para préstamo.");
        }

        
        if (libro1.devolver()) {
            System.out.println("Se ha devuelto un ejemplar.");
        } else {
            System.out.println("No hay ejemplares prestados para devolver.");
        }

        
        System.out.println(libro1);
    }
}
