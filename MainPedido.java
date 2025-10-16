public class MainPedido {
    public static void main(String[] args) {
        Pedido pedido1 = new Pedido("P-009", 3, 40.33, 9.00);

        System.out.println(pedido1); 

        pedido1.pagar(); 
        System.out.println("Después de pagar:");
        System.out.println(pedido1);
    }
}