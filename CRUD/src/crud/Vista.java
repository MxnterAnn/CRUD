package crud;

import java.awt.Color;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import org.netbeans.lib.awtextra.*;

public class Vista extends JFrame {

    JLabel etidProducto, etiidproducto, etiNombre, etiPrecio, etiCantidad, etiProveedor;
    JTextField txtNombre;
    JButton btnAgregar, btnEliminar, btnGuardar, btnLimpiar, btnPDF;
    JSpinner spiPrecio, spiCantidad;
    JComboBox cboProveedor;
    JTable tblDatos;
    JScrollPane scroll;
    DefaultTableModel model;

    public Vista() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("CRUD");
        this.setSize(500, 650);
        this.getContentPane().setLayout(new AbsoluteLayout());
        this.setLocationRelativeTo(null);

        etidProducto = new JLabel("ID Producto");
        this.getContentPane().add(etidProducto, new AbsoluteConstraints(20, 20, 100, 30));
        etiidproducto = new JLabel("ID");
        this.getContentPane().add(etiidproducto, new AbsoluteConstraints(120, 20, 100, 30));

        etiNombre = new JLabel("Nombre");
        this.getContentPane().add(etiNombre, new AbsoluteConstraints(20, 60, 100, 30));
        txtNombre = new JTextField();
        this.getContentPane().add(txtNombre, new AbsoluteConstraints(120, 60, 100, 30));

        etiCantidad = new JLabel("Cantidad");
        this.getContentPane().add(etiCantidad, new AbsoluteConstraints(20, 100, 100, 30));
        spiCantidad = new JSpinner();
        this.getContentPane().add(spiCantidad, new AbsoluteConstraints(120, 100, 100, 30));

        etiPrecio = new JLabel("Precio");
        this.getContentPane().add(etiPrecio, new AbsoluteConstraints(20, 140, 130, 30));
        spiPrecio = new JSpinner();
        this.getContentPane().add(spiPrecio, new AbsoluteConstraints(120, 140, 100, 30));

        etiProveedor = new JLabel("Proveedor");
        this.getContentPane().add(etiProveedor, new AbsoluteConstraints(20, 200, 100, 30));
        cboProveedor = new JComboBox();
        this.getContentPane().add(cboProveedor, new AbsoluteConstraints(120, 200, 150, 30));
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        modelo.addElement("Bimbo");
        modelo.addElement("Marinela");
        modelo.addElement("Coca & Cola");
        cboProveedor.setModel(modelo);

        btnAgregar = new JButton("Agregar");
        this.getContentPane().add(btnAgregar, new AbsoluteConstraints(300, 20, 100, 30));
        btnEliminar = new JButton("Eliminar");
        this.getContentPane().add(btnEliminar, new AbsoluteConstraints(300, 60, 100, 30));
        btnGuardar = new JButton("Guardar");
        this.getContentPane().add(btnGuardar, new AbsoluteConstraints(300, 100, 100, 30));
        btnLimpiar = new JButton("Limpiar");
        this.getContentPane().add(btnLimpiar, new AbsoluteConstraints(300, 140, 100, 30));
        btnPDF = new JButton("Ver PDF");
        this.getContentPane().add(btnPDF, new AbsoluteConstraints(300, 200, 100, 30));

        tblDatos = new JTable();
        scroll = new JScrollPane();
        model = new DefaultTableModel();

        model.addColumn("IdProducto");
        model.addColumn("Nombre");
        model.addColumn("Precio");
        model.addColumn("Cantidad");
        model.addColumn("Proveedor");
        tblDatos.setModel(model);
        scroll.setViewportView(tblDatos);
        this.getContentPane().add(scroll, new AbsoluteConstraints(10, 250, 450, 360));

    }

    public static void main(String[] args) {
        Vista v = new Vista();
        v.setVisible(true);
    }

}
