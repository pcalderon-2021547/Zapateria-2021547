
package Modelo;

public class Proveedor {
    
     private int codigoProveedor;
    private String nombreProveedor;
    private String apellidoProveedor;
    private String emailProveedor;
   private Producto producto;

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getApellidoProveedor() {
        return apellidoProveedor;
    }

    public void setApellidoProveedor(String apellidoProveedor) {
        this.apellidoProveedor = apellidoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoProveedor=" + codigoProveedor + ", nombreProveedor=" + nombreProveedor + ", apellidoProveedor=" + apellidoProveedor + ", emailProveedor=" + emailProveedor + ", producto=" + producto + '}';
    }
    
}
