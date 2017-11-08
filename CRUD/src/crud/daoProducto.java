package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.spi.DirStateFactory;

public class daoProducto {

    Conexion cx;
    Producto p;

    public daoProducto() {
        cx = new Conexion();
    }

    public boolean create(Producto p) {
        try {
            String sql = ("INSERT INTO producto(Nombre,Precio,Cantidad,Proveedor) VALUES (?,?,?,?)");
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getCantidad());
            ps.setInt(3, p.getPrecio());
            ps.setString(4, p.getProveedor());
            ps.execute();
            ps.close();
            ps = null;
            cx.cerrar();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ArrayList<Producto> read() {
        ArrayList<Producto> lista = new ArrayList<Producto>();
        String sql = "SELECT * FROM Producto";
        try {
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("Nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setProveedor(rs.getString("proveedor"));
                lista.add(p);

            }
            ps.close();
            ps = null;
            cx.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(daoProducto.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Fallo metodo read");
        }
        return lista;

    }

    public boolean delete(int id) {
        try {
            String sql = "DELETE FROM Producto WHERE idproductos=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            ps.close();
            ps = null;
            cx.cerrar();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public boolean update(Producto p) {
        try {
            String sql = "UPDATE producto SET nombre=?,precio=?,cantidad=?,proveedor=? WHERE idproducto=?";
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setString(1, p.getNombre());
            ps.setInt(2, p.getPrecio());
            ps.setInt(3, p.getCantidad());
            ps.setString(4, p.getProveedor());
            ps.setInt(5, p.getIdproducto());
            ps.execute();
            ps.close();
            ps = null;
            cx.cerrar();
            return true;
        } catch (SQLException ex) {
            return false;
        }

    }

    public Producto read(int id) {
        Producto p = new Producto();
        String sql = "SELECT * FROM Producto WHERE idproducto=?";
        try {
            PreparedStatement ps = cx.conectar().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                p.setIdproducto(rs.getInt("idproducto"));
                p.setNombre(rs.getString("Nombre"));
                p.setPrecio(rs.getInt("precio"));
                p.setCantidad(rs.getInt("cantidad"));
                p.setProveedor(rs.getString("proveedor"));

            }
            ps.close();
            ps = null;
            cx.cerrar();
        } catch (SQLException ex) {
            System.out.println("Fallo metodo read producto");
        }
        return p;
    }

}
