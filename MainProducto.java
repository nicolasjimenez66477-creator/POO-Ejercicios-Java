public class MainProducto {
    public static void main(String[] args) {
        Producto p1 = new Producto("P01", "Teclado", 20, 59.90, true);

        p1.vender(2);
        p1.ingresar(5);
        p1.descontinuar();
        p1.vender(1);

        System.out.println(p1);
    }
}
