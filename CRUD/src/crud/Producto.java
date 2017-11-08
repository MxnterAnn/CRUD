
package crud;

public class Producto {

    int idproducto, Precio, Cantidad;
    String Nombre, Proveedor;
    
   
    public Producto() {
        System.out.println("Se creo producto");
    }

    public Producto(int idproducto, int Precio, int Cantidad, String Nombre, String Proveedor) {
        this.idproducto = idproducto;
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.Proveedor = Proveedor;
    }

    public Producto(int Precio, int Cantidad, String Nombre, String Proveedor) {
        this.Precio = Precio;
        this.Cantidad = Cantidad;
        this.Nombre = Nombre;
        this.Proveedor = Proveedor;
    }

    
    public int getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(int idproducto) {
        this.idproducto = idproducto;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }
    
   
    

}
