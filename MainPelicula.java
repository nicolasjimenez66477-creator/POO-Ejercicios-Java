public class MainPelicula {
    public static void main(String[] args) {
        Pelicula p1 = new Pelicula("Matrix", 1999, "R", 3, 0);

        System.out.println(p1);
        p1.alquilar(15); 
        p1.alquilar(18); 
        p1.alquilar(19); 
        System.out.println(p1);
        p1.devolver();
        System.out.println(p1);
    }
}

