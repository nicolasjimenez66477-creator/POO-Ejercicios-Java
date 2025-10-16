public class Producto {
    private String codigo;
    private String nombre;
    private int stock;
    private double precioUnitario;
    private boolean activo;

    public Producto() {
        this.codigo = "Sin código";
        this.nombre = "Sin nombre";
        this.stock = 0;
        this.precioUnitario = 0.0;
        this.activo = true;
    }
    public Producto(String codigo, String nombre, int stock, double precioUnitario, boolean activo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = Math.max(0, stock); 
        this.precioUnitario = Math.max(0, precioUnitario); 
        this.activo = activo;
    }

    public void ingresar(int cantidad) {
        if (!activo) {
            System.out.println("El producto está descontinuado. No se puede ingresar stock.");
            return;
        }
        if (cantidad > 0) {
            stock += cantidad;
        } else {
            System.out.println("La cantidad debe ser mayor a 0.");
        }
    }


    public void vender(int cantidad) {
        if (!activo) {
            System.out.println("El producto está descontinuado. No se puede vender.");
            return;
        }
        if (cantidad > 0 && cantidad <= stock) {
            stock -= cantidad;
        } else if (cantidad > stock) {
            System.out.println("Stock insuficiente. No se puede realizar la venta.");
        } else {
            System.out.println("Cantidad inválida.");
        }
    }

    public void descontinuar() {
        activo = false;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getStock() {
        return stock;
    }

    public String getPrecioUnitario() {
        return String.format("$%.2f", precioUnitario);
    }

    public boolean isActivo() {
        return activo;
    }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " | stock: " + stock + " | " + getPrecioUnitario();
    }
}

