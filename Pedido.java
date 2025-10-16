public class Pedido {
    
    private String id;
    private int unidades;
    private double precioUnitario;
    private double costoEnvio;
    private boolean pagado;

    
    public Pedido() {
        this.id = "P-000";
        this.unidades = 1;
        this.precioUnitario = 0.0;
        this.costoEnvio = 0.0;
        this.pagado = false;
    }

    
    public Pedido(String id, int unidades, double precioUnitario, double costoEnvio) {
        this.id = id;
        this.unidades = (unidades >= 1) ? unidades : 1;
        this.precioUnitario = (precioUnitario >= 0) ? precioUnitario : 0.0;
        this.costoEnvio = (costoEnvio >= 0) ? costoEnvio : 0.0;
        this.pagado = false;
    }

    
    public double total() {
        return Math.round((unidades * precioUnitario + costoEnvio) * 100.0) / 100.0;
    }

    
    public boolean pagar() {
        if (!pagado && total() > 0) {
            pagado = true;
            return true;
        }
        return false;
    }

    
    public boolean cancelar() {
        if (!pagado) {
            unidades = 0;
            precioUnitario = 0;
            costoEnvio = 0;
            return true;
        }
        return false;
    }

    
    public String getId() { return id; }
    public int getUnidades() { return unidades; }
    public double getPrecioUnitario() { return precioUnitario; }
    public double getCostoEnvio() { return costoEnvio; }
    public boolean isPagado() { return pagado; }

    
    public void setUnidades(int unidades) {
        if (unidades >= 1 && !pagado) this.unidades = unidades;
    }

    public void setPrecioUnitario(double precioUnitario) {
        if (precioUnitario >= 0 && !pagado) this.precioUnitario = precioUnitario;
    }

    public void setCostoEnvio(double costoEnvio) {
        if (costoEnvio >= 0 && !pagado) this.costoEnvio = costoEnvio;
    }

    @Override
    public String toString() {
        return "Pedido " + id + " | Total: $" + String.format("%.2f", total()) + " | Pagado: " + pagado;
    }
}
