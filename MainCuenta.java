public class MainCuenta {
    public static void main(String[] args) {
        
        Cuenta c1 = new Cuenta("Isa García", "123-4", 1_000_000, true);

        System.out.println(c1);
       
        c1.depositar(250_000);
        System.out.println(c1);

        c1.retirar(500_000);
        System.out.println(c1);

        c1.bloquear();
        c1.depositar(100_000);
        System.out.println(c1);

        c1.activar();
        c1.depositar(100_000);
        System.out.println(c1);
    }
}

